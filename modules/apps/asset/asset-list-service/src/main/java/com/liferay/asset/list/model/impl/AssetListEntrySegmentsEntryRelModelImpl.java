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

package com.liferay.asset.list.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.asset.list.model.AssetListEntrySegmentsEntryRel;
import com.liferay.asset.list.model.AssetListEntrySegmentsEntryRelModel;
import com.liferay.asset.list.model.AssetListEntrySegmentsEntryRelSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the AssetListEntrySegmentsEntryRel service. Represents a row in the &quot;AssetListEntrySegmentsEntryRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>AssetListEntrySegmentsEntryRelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AssetListEntrySegmentsEntryRelImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetListEntrySegmentsEntryRelImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class AssetListEntrySegmentsEntryRelModelImpl
	extends BaseModelImpl<AssetListEntrySegmentsEntryRel>
	implements AssetListEntrySegmentsEntryRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a asset list entry segments entry rel model instance should use the <code>AssetListEntrySegmentsEntryRel</code> interface instead.
	 */
	public static final String TABLE_NAME = "AssetListEntrySegmentsEntryRel";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"assetListSegmentRelId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"assetListEntryId", Types.BIGINT}, {"segmentsEntryId", Types.BIGINT},
		{"typeSettings", Types.CLOB}, {"lastPublishDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("assetListSegmentRelId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("assetListEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("segmentsEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("typeSettings", Types.CLOB);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table AssetListEntrySegmentsEntryRel (uuid_ VARCHAR(75) null,assetListSegmentRelId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,assetListEntryId LONG,segmentsEntryId LONG,typeSettings TEXT null,lastPublishDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table AssetListEntrySegmentsEntryRel";

	public static final String ORDER_BY_JPQL =
		" ORDER BY assetListEntrySegmentsEntryRel.assetListEntrySegmentsEntryRelId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY AssetListEntrySegmentsEntryRel.assetListSegmentRelId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.asset.list.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.asset.list.model.AssetListEntrySegmentsEntryRel"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.asset.list.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.asset.list.model.AssetListEntrySegmentsEntryRel"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.asset.list.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.asset.list.model.AssetListEntrySegmentsEntryRel"),
		true);

	public static final long ASSETLISTENTRYID_COLUMN_BITMASK = 1L;

	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long SEGMENTSENTRYID_COLUMN_BITMASK = 8L;

	public static final long UUID_COLUMN_BITMASK = 16L;

	public static final long ASSETLISTENTRYSEGMENTSENTRYRELID_COLUMN_BITMASK =
		32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AssetListEntrySegmentsEntryRel toModel(
		AssetListEntrySegmentsEntryRelSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		AssetListEntrySegmentsEntryRel model =
			new AssetListEntrySegmentsEntryRelImpl();

		model.setUuid(soapModel.getUuid());
		model.setAssetListEntrySegmentsEntryRelId(
			soapModel.getAssetListEntrySegmentsEntryRelId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setAssetListEntryId(soapModel.getAssetListEntryId());
		model.setSegmentsEntryId(soapModel.getSegmentsEntryId());
		model.setTypeSettings(soapModel.getTypeSettings());
		model.setLastPublishDate(soapModel.getLastPublishDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AssetListEntrySegmentsEntryRel> toModels(
		AssetListEntrySegmentsEntryRelSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<AssetListEntrySegmentsEntryRel> models =
			new ArrayList<AssetListEntrySegmentsEntryRel>(soapModels.length);

		for (AssetListEntrySegmentsEntryRelSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.asset.list.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.asset.list.model.AssetListEntrySegmentsEntryRel"));

	public AssetListEntrySegmentsEntryRelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _assetListEntrySegmentsEntryRelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAssetListEntrySegmentsEntryRelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _assetListEntrySegmentsEntryRelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AssetListEntrySegmentsEntryRel.class;
	}

	@Override
	public String getModelClassName() {
		return AssetListEntrySegmentsEntryRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AssetListEntrySegmentsEntryRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AssetListEntrySegmentsEntryRel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AssetListEntrySegmentsEntryRel, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(AssetListEntrySegmentsEntryRel)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AssetListEntrySegmentsEntryRel, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AssetListEntrySegmentsEntryRel, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AssetListEntrySegmentsEntryRel)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AssetListEntrySegmentsEntryRel, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AssetListEntrySegmentsEntryRel, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map
		<String, Function<AssetListEntrySegmentsEntryRel, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<AssetListEntrySegmentsEntryRel, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<AssetListEntrySegmentsEntryRel, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String,
					 Function<AssetListEntrySegmentsEntryRel, Object>>();
		Map<String, BiConsumer<AssetListEntrySegmentsEntryRel, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<AssetListEntrySegmentsEntryRel, ?>>();

		attributeGetterFunctions.put(
			"uuid", AssetListEntrySegmentsEntryRel::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<AssetListEntrySegmentsEntryRel, String>)
				AssetListEntrySegmentsEntryRel::setUuid);
		attributeGetterFunctions.put(
			"assetListEntrySegmentsEntryRelId",
			AssetListEntrySegmentsEntryRel::
				getAssetListEntrySegmentsEntryRelId);
		attributeSetterBiConsumers.put(
			"assetListEntrySegmentsEntryRelId",
			(BiConsumer<AssetListEntrySegmentsEntryRel, Long>)
				AssetListEntrySegmentsEntryRel::
					setAssetListEntrySegmentsEntryRelId);
		attributeGetterFunctions.put(
			"groupId", AssetListEntrySegmentsEntryRel::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<AssetListEntrySegmentsEntryRel, Long>)
				AssetListEntrySegmentsEntryRel::setGroupId);
		attributeGetterFunctions.put(
			"companyId", AssetListEntrySegmentsEntryRel::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<AssetListEntrySegmentsEntryRel, Long>)
				AssetListEntrySegmentsEntryRel::setCompanyId);
		attributeGetterFunctions.put(
			"userId", AssetListEntrySegmentsEntryRel::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<AssetListEntrySegmentsEntryRel, Long>)
				AssetListEntrySegmentsEntryRel::setUserId);
		attributeGetterFunctions.put(
			"userName", AssetListEntrySegmentsEntryRel::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<AssetListEntrySegmentsEntryRel, String>)
				AssetListEntrySegmentsEntryRel::setUserName);
		attributeGetterFunctions.put(
			"createDate", AssetListEntrySegmentsEntryRel::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<AssetListEntrySegmentsEntryRel, Date>)
				AssetListEntrySegmentsEntryRel::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", AssetListEntrySegmentsEntryRel::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<AssetListEntrySegmentsEntryRel, Date>)
				AssetListEntrySegmentsEntryRel::setModifiedDate);
		attributeGetterFunctions.put(
			"assetListEntryId",
			AssetListEntrySegmentsEntryRel::getAssetListEntryId);
		attributeSetterBiConsumers.put(
			"assetListEntryId",
			(BiConsumer<AssetListEntrySegmentsEntryRel, Long>)
				AssetListEntrySegmentsEntryRel::setAssetListEntryId);
		attributeGetterFunctions.put(
			"segmentsEntryId",
			AssetListEntrySegmentsEntryRel::getSegmentsEntryId);
		attributeSetterBiConsumers.put(
			"segmentsEntryId",
			(BiConsumer<AssetListEntrySegmentsEntryRel, Long>)
				AssetListEntrySegmentsEntryRel::setSegmentsEntryId);
		attributeGetterFunctions.put(
			"typeSettings", AssetListEntrySegmentsEntryRel::getTypeSettings);
		attributeSetterBiConsumers.put(
			"typeSettings",
			(BiConsumer<AssetListEntrySegmentsEntryRel, String>)
				AssetListEntrySegmentsEntryRel::setTypeSettings);
		attributeGetterFunctions.put(
			"lastPublishDate",
			AssetListEntrySegmentsEntryRel::getLastPublishDate);
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			(BiConsumer<AssetListEntrySegmentsEntryRel, Date>)
				AssetListEntrySegmentsEntryRel::setLastPublishDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getAssetListEntrySegmentsEntryRelId() {
		return _assetListEntrySegmentsEntryRelId;
	}

	@Override
	public void setAssetListEntrySegmentsEntryRelId(
		long assetListEntrySegmentsEntryRelId) {

		_assetListEntrySegmentsEntryRelId = assetListEntrySegmentsEntryRelId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getAssetListEntryId() {
		return _assetListEntryId;
	}

	@Override
	public void setAssetListEntryId(long assetListEntryId) {
		_columnBitmask |= ASSETLISTENTRYID_COLUMN_BITMASK;

		if (!_setOriginalAssetListEntryId) {
			_setOriginalAssetListEntryId = true;

			_originalAssetListEntryId = _assetListEntryId;
		}

		_assetListEntryId = assetListEntryId;
	}

	public long getOriginalAssetListEntryId() {
		return _originalAssetListEntryId;
	}

	@JSON
	@Override
	public long getSegmentsEntryId() {
		return _segmentsEntryId;
	}

	@Override
	public void setSegmentsEntryId(long segmentsEntryId) {
		_columnBitmask |= SEGMENTSENTRYID_COLUMN_BITMASK;

		if (!_setOriginalSegmentsEntryId) {
			_setOriginalSegmentsEntryId = true;

			_originalSegmentsEntryId = _segmentsEntryId;
		}

		_segmentsEntryId = segmentsEntryId;
	}

	public long getOriginalSegmentsEntryId() {
		return _originalSegmentsEntryId;
	}

	@JSON
	@Override
	public String getTypeSettings() {
		if (_typeSettings == null) {
			return "";
		}
		else {
			return _typeSettings;
		}
	}

	@Override
	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	@JSON
	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(
				AssetListEntrySegmentsEntryRel.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), AssetListEntrySegmentsEntryRel.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AssetListEntrySegmentsEntryRel toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel =
				(AssetListEntrySegmentsEntryRel)ProxyUtil.newProxyInstance(
					_classLoader, _escapedModelInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AssetListEntrySegmentsEntryRelImpl assetListEntrySegmentsEntryRelImpl =
			new AssetListEntrySegmentsEntryRelImpl();

		assetListEntrySegmentsEntryRelImpl.setUuid(getUuid());
		assetListEntrySegmentsEntryRelImpl.setAssetListEntrySegmentsEntryRelId(
			getAssetListEntrySegmentsEntryRelId());
		assetListEntrySegmentsEntryRelImpl.setGroupId(getGroupId());
		assetListEntrySegmentsEntryRelImpl.setCompanyId(getCompanyId());
		assetListEntrySegmentsEntryRelImpl.setUserId(getUserId());
		assetListEntrySegmentsEntryRelImpl.setUserName(getUserName());
		assetListEntrySegmentsEntryRelImpl.setCreateDate(getCreateDate());
		assetListEntrySegmentsEntryRelImpl.setModifiedDate(getModifiedDate());
		assetListEntrySegmentsEntryRelImpl.setAssetListEntryId(
			getAssetListEntryId());
		assetListEntrySegmentsEntryRelImpl.setSegmentsEntryId(
			getSegmentsEntryId());
		assetListEntrySegmentsEntryRelImpl.setTypeSettings(getTypeSettings());
		assetListEntrySegmentsEntryRelImpl.setLastPublishDate(
			getLastPublishDate());

		assetListEntrySegmentsEntryRelImpl.resetOriginalValues();

		return assetListEntrySegmentsEntryRelImpl;
	}

	@Override
	public int compareTo(
		AssetListEntrySegmentsEntryRel assetListEntrySegmentsEntryRel) {

		long primaryKey = assetListEntrySegmentsEntryRel.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssetListEntrySegmentsEntryRel)) {
			return false;
		}

		AssetListEntrySegmentsEntryRel assetListEntrySegmentsEntryRel =
			(AssetListEntrySegmentsEntryRel)obj;

		long primaryKey = assetListEntrySegmentsEntryRel.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		AssetListEntrySegmentsEntryRelModelImpl
			assetListEntrySegmentsEntryRelModelImpl = this;

		assetListEntrySegmentsEntryRelModelImpl._originalUuid =
			assetListEntrySegmentsEntryRelModelImpl._uuid;

		assetListEntrySegmentsEntryRelModelImpl._originalGroupId =
			assetListEntrySegmentsEntryRelModelImpl._groupId;

		assetListEntrySegmentsEntryRelModelImpl._setOriginalGroupId = false;

		assetListEntrySegmentsEntryRelModelImpl._originalCompanyId =
			assetListEntrySegmentsEntryRelModelImpl._companyId;

		assetListEntrySegmentsEntryRelModelImpl._setOriginalCompanyId = false;

		assetListEntrySegmentsEntryRelModelImpl._setModifiedDate = false;

		assetListEntrySegmentsEntryRelModelImpl._originalAssetListEntryId =
			assetListEntrySegmentsEntryRelModelImpl._assetListEntryId;

		assetListEntrySegmentsEntryRelModelImpl._setOriginalAssetListEntryId =
			false;

		assetListEntrySegmentsEntryRelModelImpl._originalSegmentsEntryId =
			assetListEntrySegmentsEntryRelModelImpl._segmentsEntryId;

		assetListEntrySegmentsEntryRelModelImpl._setOriginalSegmentsEntryId =
			false;

		assetListEntrySegmentsEntryRelModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AssetListEntrySegmentsEntryRel> toCacheModel() {
		AssetListEntrySegmentsEntryRelCacheModel
			assetListEntrySegmentsEntryRelCacheModel =
				new AssetListEntrySegmentsEntryRelCacheModel();

		assetListEntrySegmentsEntryRelCacheModel.uuid = getUuid();

		String uuid = assetListEntrySegmentsEntryRelCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			assetListEntrySegmentsEntryRelCacheModel.uuid = null;
		}

		assetListEntrySegmentsEntryRelCacheModel.
			assetListEntrySegmentsEntryRelId =
				getAssetListEntrySegmentsEntryRelId();

		assetListEntrySegmentsEntryRelCacheModel.groupId = getGroupId();

		assetListEntrySegmentsEntryRelCacheModel.companyId = getCompanyId();

		assetListEntrySegmentsEntryRelCacheModel.userId = getUserId();

		assetListEntrySegmentsEntryRelCacheModel.userName = getUserName();

		String userName = assetListEntrySegmentsEntryRelCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			assetListEntrySegmentsEntryRelCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			assetListEntrySegmentsEntryRelCacheModel.createDate =
				createDate.getTime();
		}
		else {
			assetListEntrySegmentsEntryRelCacheModel.createDate =
				Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			assetListEntrySegmentsEntryRelCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			assetListEntrySegmentsEntryRelCacheModel.modifiedDate =
				Long.MIN_VALUE;
		}

		assetListEntrySegmentsEntryRelCacheModel.assetListEntryId =
			getAssetListEntryId();

		assetListEntrySegmentsEntryRelCacheModel.segmentsEntryId =
			getSegmentsEntryId();

		assetListEntrySegmentsEntryRelCacheModel.typeSettings =
			getTypeSettings();

		String typeSettings =
			assetListEntrySegmentsEntryRelCacheModel.typeSettings;

		if ((typeSettings != null) && (typeSettings.length() == 0)) {
			assetListEntrySegmentsEntryRelCacheModel.typeSettings = null;
		}

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			assetListEntrySegmentsEntryRelCacheModel.lastPublishDate =
				lastPublishDate.getTime();
		}
		else {
			assetListEntrySegmentsEntryRelCacheModel.lastPublishDate =
				Long.MIN_VALUE;
		}

		return assetListEntrySegmentsEntryRelCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AssetListEntrySegmentsEntryRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AssetListEntrySegmentsEntryRel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AssetListEntrySegmentsEntryRel, Object>
				attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply(
					(AssetListEntrySegmentsEntryRel)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<AssetListEntrySegmentsEntryRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AssetListEntrySegmentsEntryRel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AssetListEntrySegmentsEntryRel, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(AssetListEntrySegmentsEntryRel)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		AssetListEntrySegmentsEntryRel.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		AssetListEntrySegmentsEntryRel.class, ModelWrapper.class
	};

	private String _uuid;
	private String _originalUuid;
	private long _assetListEntrySegmentsEntryRelId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _assetListEntryId;
	private long _originalAssetListEntryId;
	private boolean _setOriginalAssetListEntryId;
	private long _segmentsEntryId;
	private long _originalSegmentsEntryId;
	private boolean _setOriginalSegmentsEntryId;
	private String _typeSettings;
	private Date _lastPublishDate;
	private long _columnBitmask;
	private AssetListEntrySegmentsEntryRel _escapedModel;

}