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

package com.liferay.dispatch.model.impl;

import com.liferay.dispatch.model.DispatchLog;
import com.liferay.dispatch.model.DispatchLogModel;
import com.liferay.dispatch.model.DispatchLogSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

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
 * The base model implementation for the DispatchLog service. Represents a row in the &quot;DispatchLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DispatchLogModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DispatchLogImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see DispatchLogImpl
 * @generated
 */
@JSON(strict = true)
public class DispatchLogModelImpl
	extends BaseModelImpl<DispatchLog> implements DispatchLogModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dispatch log model instance should use the <code>DispatchLog</code> interface instead.
	 */
	public static final String TABLE_NAME = "DispatchLog";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"dispatchLogId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"dispatchTriggerId", Types.BIGINT},
		{"endDate", Types.TIMESTAMP}, {"error", Types.CLOB},
		{"output_", Types.CLOB}, {"startDate", Types.TIMESTAMP},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dispatchLogId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("dispatchTriggerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("endDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("error", Types.CLOB);
		TABLE_COLUMNS_MAP.put("output_", Types.CLOB);
		TABLE_COLUMNS_MAP.put("startDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DispatchLog (mvccVersion LONG default 0 not null,dispatchLogId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,dispatchTriggerId LONG,endDate DATE null,error TEXT null,output_ TEXT null,startDate DATE null,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table DispatchLog";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dispatchLog.modifiedDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DispatchLog.modifiedDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long DISPATCHTRIGGERID_COLUMN_BITMASK = 1L;

	public static final long STATUS_COLUMN_BITMASK = 2L;

	public static final long MODIFIEDDATE_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static DispatchLog toModel(DispatchLogSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		DispatchLog model = new DispatchLogImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setDispatchLogId(soapModel.getDispatchLogId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setDispatchTriggerId(soapModel.getDispatchTriggerId());
		model.setEndDate(soapModel.getEndDate());
		model.setError(soapModel.getError());
		model.setOutput(soapModel.getOutput());
		model.setStartDate(soapModel.getStartDate());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<DispatchLog> toModels(DispatchLogSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<DispatchLog> models = new ArrayList<DispatchLog>(
			soapModels.length);

		for (DispatchLogSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public DispatchLogModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dispatchLogId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDispatchLogId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dispatchLogId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DispatchLog.class;
	}

	@Override
	public String getModelClassName() {
		return DispatchLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DispatchLog, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DispatchLog, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DispatchLog, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DispatchLog)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DispatchLog, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DispatchLog, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DispatchLog)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DispatchLog, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DispatchLog, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DispatchLog>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DispatchLog.class.getClassLoader(), DispatchLog.class,
			ModelWrapper.class);

		try {
			Constructor<DispatchLog> constructor =
				(Constructor<DispatchLog>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<DispatchLog, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DispatchLog, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DispatchLog, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<DispatchLog, Object>>();
		Map<String, BiConsumer<DispatchLog, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DispatchLog, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", DispatchLog::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<DispatchLog, Long>)DispatchLog::setMvccVersion);
		attributeGetterFunctions.put(
			"dispatchLogId", DispatchLog::getDispatchLogId);
		attributeSetterBiConsumers.put(
			"dispatchLogId",
			(BiConsumer<DispatchLog, Long>)DispatchLog::setDispatchLogId);
		attributeGetterFunctions.put("companyId", DispatchLog::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DispatchLog, Long>)DispatchLog::setCompanyId);
		attributeGetterFunctions.put("userId", DispatchLog::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<DispatchLog, Long>)DispatchLog::setUserId);
		attributeGetterFunctions.put("userName", DispatchLog::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<DispatchLog, String>)DispatchLog::setUserName);
		attributeGetterFunctions.put("createDate", DispatchLog::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<DispatchLog, Date>)DispatchLog::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", DispatchLog::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DispatchLog, Date>)DispatchLog::setModifiedDate);
		attributeGetterFunctions.put(
			"dispatchTriggerId", DispatchLog::getDispatchTriggerId);
		attributeSetterBiConsumers.put(
			"dispatchTriggerId",
			(BiConsumer<DispatchLog, Long>)DispatchLog::setDispatchTriggerId);
		attributeGetterFunctions.put("endDate", DispatchLog::getEndDate);
		attributeSetterBiConsumers.put(
			"endDate", (BiConsumer<DispatchLog, Date>)DispatchLog::setEndDate);
		attributeGetterFunctions.put("error", DispatchLog::getError);
		attributeSetterBiConsumers.put(
			"error", (BiConsumer<DispatchLog, String>)DispatchLog::setError);
		attributeGetterFunctions.put("output", DispatchLog::getOutput);
		attributeSetterBiConsumers.put(
			"output", (BiConsumer<DispatchLog, String>)DispatchLog::setOutput);
		attributeGetterFunctions.put("startDate", DispatchLog::getStartDate);
		attributeSetterBiConsumers.put(
			"startDate",
			(BiConsumer<DispatchLog, Date>)DispatchLog::setStartDate);
		attributeGetterFunctions.put("status", DispatchLog::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<DispatchLog, Integer>)DispatchLog::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public long getDispatchLogId() {
		return _dispatchLogId;
	}

	@Override
	public void setDispatchLogId(long dispatchLogId) {
		_dispatchLogId = dispatchLogId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
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
		catch (PortalException portalException) {
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

		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getDispatchTriggerId() {
		return _dispatchTriggerId;
	}

	@Override
	public void setDispatchTriggerId(long dispatchTriggerId) {
		_columnBitmask |= DISPATCHTRIGGERID_COLUMN_BITMASK;

		if (!_setOriginalDispatchTriggerId) {
			_setOriginalDispatchTriggerId = true;

			_originalDispatchTriggerId = _dispatchTriggerId;
		}

		_dispatchTriggerId = dispatchTriggerId;
	}

	public long getOriginalDispatchTriggerId() {
		return _originalDispatchTriggerId;
	}

	@JSON
	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@JSON
	@Override
	public String getError() {
		if (_error == null) {
			return "";
		}
		else {
			return _error;
		}
	}

	@Override
	public void setError(String error) {
		_error = error;
	}

	@JSON
	@Override
	public String getOutput() {
		if (_output == null) {
			return "";
		}
		else {
			return _output;
		}
	}

	@Override
	public void setOutput(String output) {
		_output = output;
	}

	@JSON
	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), DispatchLog.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DispatchLog toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DispatchLog>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DispatchLogImpl dispatchLogImpl = new DispatchLogImpl();

		dispatchLogImpl.setMvccVersion(getMvccVersion());
		dispatchLogImpl.setDispatchLogId(getDispatchLogId());
		dispatchLogImpl.setCompanyId(getCompanyId());
		dispatchLogImpl.setUserId(getUserId());
		dispatchLogImpl.setUserName(getUserName());
		dispatchLogImpl.setCreateDate(getCreateDate());
		dispatchLogImpl.setModifiedDate(getModifiedDate());
		dispatchLogImpl.setDispatchTriggerId(getDispatchTriggerId());
		dispatchLogImpl.setEndDate(getEndDate());
		dispatchLogImpl.setError(getError());
		dispatchLogImpl.setOutput(getOutput());
		dispatchLogImpl.setStartDate(getStartDate());
		dispatchLogImpl.setStatus(getStatus());

		dispatchLogImpl.resetOriginalValues();

		return dispatchLogImpl;
	}

	@Override
	public int compareTo(DispatchLog dispatchLog) {
		int value = 0;

		value = DateUtil.compareTo(
			getModifiedDate(), dispatchLog.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DispatchLog)) {
			return false;
		}

		DispatchLog dispatchLog = (DispatchLog)object;

		long primaryKey = dispatchLog.getPrimaryKey();

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

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		DispatchLogModelImpl dispatchLogModelImpl = this;

		dispatchLogModelImpl._setModifiedDate = false;

		dispatchLogModelImpl._originalDispatchTriggerId =
			dispatchLogModelImpl._dispatchTriggerId;

		dispatchLogModelImpl._setOriginalDispatchTriggerId = false;

		dispatchLogModelImpl._originalStatus = dispatchLogModelImpl._status;

		dispatchLogModelImpl._setOriginalStatus = false;

		dispatchLogModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DispatchLog> toCacheModel() {
		DispatchLogCacheModel dispatchLogCacheModel =
			new DispatchLogCacheModel();

		dispatchLogCacheModel.mvccVersion = getMvccVersion();

		dispatchLogCacheModel.dispatchLogId = getDispatchLogId();

		dispatchLogCacheModel.companyId = getCompanyId();

		dispatchLogCacheModel.userId = getUserId();

		dispatchLogCacheModel.userName = getUserName();

		String userName = dispatchLogCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dispatchLogCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dispatchLogCacheModel.createDate = createDate.getTime();
		}
		else {
			dispatchLogCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dispatchLogCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dispatchLogCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dispatchLogCacheModel.dispatchTriggerId = getDispatchTriggerId();

		Date endDate = getEndDate();

		if (endDate != null) {
			dispatchLogCacheModel.endDate = endDate.getTime();
		}
		else {
			dispatchLogCacheModel.endDate = Long.MIN_VALUE;
		}

		dispatchLogCacheModel.error = getError();

		String error = dispatchLogCacheModel.error;

		if ((error != null) && (error.length() == 0)) {
			dispatchLogCacheModel.error = null;
		}

		dispatchLogCacheModel.output = getOutput();

		String output = dispatchLogCacheModel.output;

		if ((output != null) && (output.length() == 0)) {
			dispatchLogCacheModel.output = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			dispatchLogCacheModel.startDate = startDate.getTime();
		}
		else {
			dispatchLogCacheModel.startDate = Long.MIN_VALUE;
		}

		dispatchLogCacheModel.status = getStatus();

		return dispatchLogCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DispatchLog, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DispatchLog, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DispatchLog, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((DispatchLog)this));
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
		Map<String, Function<DispatchLog, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DispatchLog, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DispatchLog, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DispatchLog)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, DispatchLog>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _dispatchLogId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _dispatchTriggerId;
	private long _originalDispatchTriggerId;
	private boolean _setOriginalDispatchTriggerId;
	private Date _endDate;
	private String _error;
	private String _output;
	private Date _startDate;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _columnBitmask;
	private DispatchLog _escapedModel;

}