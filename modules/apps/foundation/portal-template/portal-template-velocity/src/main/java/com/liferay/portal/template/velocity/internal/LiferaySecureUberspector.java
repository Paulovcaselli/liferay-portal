/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.template.velocity.internal;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.util.introspection.SecureIntrospectorImpl;
import org.apache.velocity.util.introspection.SecureUberspector;

/**
 * @author Tomas Polesovsky
 */
public class LiferaySecureUberspector extends SecureUberspector {

	@Override
	public void init() {
		super.init();

		ExtendedProperties extendedProperties =
			_runtimeServices.getConfiguration();

		String[] restrictedClassNames = extendedProperties.getStringArray(
			RuntimeConstants.INTROSPECTOR_RESTRICT_CLASSES);

		_restrictedClasses = new ArrayList<>(restrictedClassNames.length);

		for (String restrictedClassName : restrictedClassNames) {
			restrictedClassName = StringUtil.trim(restrictedClassName);

			if (Validator.isBlank(restrictedClassName)) {
				continue;
			}

			try {
				_restrictedClasses.add(Class.forName(restrictedClassName));
			}
			catch (ClassNotFoundException cnfe) {
				super.log.error(
					"Unable to find restricted class " + restrictedClassName,
					cnfe);
			}
		}

		String[] restrictedMethodNames = (String[])extendedProperties.get(
			"liferay." + RuntimeConstants.INTROSPECTOR_RESTRICT_CLASSES +
				".methods");

		if (restrictedMethodNames == null) {
			_restrictedMethodNamesMap = Collections.emptyMap();
		}
		else {
			_restrictedMethodNamesMap = new HashMap<>(
				restrictedMethodNames.length);

			for (String restrictedMethodName : restrictedMethodNames) {
				int pos = restrictedMethodName.indexOf(CharPool.POUND);

				if (pos < 0) {
					super.log.error(
						"Invalid syntax of " + restrictedMethodName +
							". Expecting className#methodName");

					continue;
				}

				String className = StringUtil.trim(
					restrictedMethodName.substring(0, pos));

				String methodName = StringUtil.trim(
					restrictedMethodName.substring(pos + 1));

				Set<String> methodNames =
					_restrictedMethodNamesMap.computeIfAbsent(
						className, key -> new HashSet<>());

				methodNames.add(StringUtil.toLowerCase(methodName));
			}
		}

		String[] restrictedPackageNames = extendedProperties.getStringArray(
			RuntimeConstants.INTROSPECTOR_RESTRICT_PACKAGES);

		if (restrictedPackageNames != null) {
			_restrictedPackageNames = new ArrayList<>(
				restrictedPackageNames.length);

			for (String restrictedPackageName : restrictedPackageNames) {
				restrictedPackageName = StringUtil.trim(restrictedPackageName);

				if (Validator.isBlank(restrictedPackageName)) {
					continue;
				}

				_restrictedPackageNames.add(restrictedPackageName);
			}
		}

		super.introspector = new LiferaySecureIntrospectorImpl();
	}

	@Override
	public void setRuntimeServices(RuntimeServices runtimeServices) {
		super.setRuntimeServices(runtimeServices);

		_runtimeServices = runtimeServices;
	}

	private void _checkClassIsRestricted(Class<?> clazz) {
		ClassRestrictionInformation classRestrictionInformation =
			_classRestrictionInformations.computeIfAbsent(
				clazz.getName(),
				className -> {
					for (Class<?> restrictedClass : _restrictedClasses) {
						if (!restrictedClass.isAssignableFrom(clazz)) {
							continue;
						}

						return new ClassRestrictionInformation(
							StringBundler.concat(
								"Denied resolving class ", className, " by ",
								restrictedClass.getName()));
					}

					Package pkg = clazz.getPackage();

					if (pkg == null) {
						return _nullInstance;
					}

					String packageName = pkg.getName();

					packageName = packageName.concat(StringPool.PERIOD);

					for (String restrictedPackageName :
							_restrictedPackageNames) {

						if (!packageName.startsWith(restrictedPackageName)) {
							continue;
						}

						return new ClassRestrictionInformation(
							StringBundler.concat(
								"Denied resolving class ", className, " by ",
								restrictedPackageName));
					}

					return _nullInstance;
				});

		if (classRestrictionInformation.isRestricted()) {
			throw new IllegalArgumentException(
				classRestrictionInformation.getDescription());
		}
	}

	private void _checkClassPropertyIsRestricted(
		Class clazz, String methodName) {

		String className = clazz.getName();

		if (_restrictedClassProperties.containsKey(className)) {
			List<String> properties = _restrictedClassProperties.get(className);

			if (methodName.startsWith("get")) {
				String property = methodName.substring(3);

				if (properties.contains(property)) {
					throw new IllegalArgumentException(
						StringBundler.concat(
							"Forbbiden access to property ", property, " of ",
							clazz.getName()));
				}
			}
		}
	}

	private Map<String, List<String>> _getRestrictedClassPropertiesMap(
		String[] restrictedClassProperties) {

		Map<String, List<String>> restrictedClassPropertiesMap =
			new HashMap<>();

		if (restrictedClassProperties != null) {
			for (String restrictedClassProperty : restrictedClassProperties) {
				String className = StringUtil.extractFirst(
					restrictedClassProperty.trim(), StringPool.EQUAL);
				String propertyName = StringUtil.extractLast(
					restrictedClassProperty.trim(), StringPool.EQUAL);

				if (restrictedClassPropertiesMap.containsKey(className)) {
					List<String> properties = restrictedClassPropertiesMap.get(
						className);

					properties.add(propertyName);
				}
				else {
					restrictedClassPropertiesMap.put(
						className.trim(), Arrays.asList(propertyName));
				}
			}
		}

		return restrictedClassPropertiesMap;
	}

	private static final ClassRestrictionInformation _nullInstance =
		new ClassRestrictionInformation(null);

	private final Map<String, ClassRestrictionInformation>
		_classRestrictionInformations = new ConcurrentHashMap<>();
	private List<Class<?>> _restrictedClasses;
	private Map<String, Set<String>> _restrictedMethodNamesMap;
	private List<String> _restrictedPackageNames;
	private RuntimeServices _runtimeServices;

	private static class ClassRestrictionInformation {

		public String getDescription() {
			return _description;
		}

		public boolean isRestricted() {
			if (_description == null) {
				return false;
			}

			return true;
		}

		private ClassRestrictionInformation(String description) {
			_description = description;
		}

		private final String _description;

	}

	private class LiferaySecureIntrospectorImpl extends SecureIntrospectorImpl {

		@Override
		@SuppressWarnings("rawtypes")
		public boolean checkObjectExecutePermission(
			Class clazz, String methodName) {

			if ((methodName != null) &&
				(methodName.equals("wait") || methodName.equals("notify"))) {

				throw new IllegalArgumentException(
					"Executing method " + methodName + " is not allowed");
			}

			_checkClassIsRestricted(clazz);

			_checkClassPropertyIsRestricted(clazz, methodName);

			return true;
		}

		private LiferaySecureIntrospectorImpl() {
			super(
				new String[0], new String[0],
				LiferaySecureUberspector.this.log);
		}

	}

}