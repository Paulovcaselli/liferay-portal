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

package com.liferay.commerce.price.list.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CommercePriceListCommerceAccountGroupRel service. Represents a row in the &quot;CPLCommerceGroupAccountRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.commerce.price.list.model.impl.CommercePriceListCommerceAccountGroupRelModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.commerce.price.list.model.impl.CommercePriceListCommerceAccountGroupRelImpl</code>.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListCommerceAccountGroupRel
 * @generated
 */
@ProviderType
public interface CommercePriceListCommerceAccountGroupRelModel
	extends BaseModel<CommercePriceListCommerceAccountGroupRel>, MVCCModel,
			ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce price list commerce account group rel model instance should use the {@link CommercePriceListCommerceAccountGroupRel} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce price list commerce account group rel.
	 *
	 * @return the primary key of this commerce price list commerce account group rel
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce price list commerce account group rel.
	 *
	 * @param primaryKey the primary key of this commerce price list commerce account group rel
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this commerce price list commerce account group rel.
	 *
	 * @return the mvcc version of this commerce price list commerce account group rel
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this commerce price list commerce account group rel.
	 *
	 * @param mvccVersion the mvcc version of this commerce price list commerce account group rel
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this commerce price list commerce account group rel.
	 *
	 * @return the uuid of this commerce price list commerce account group rel
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this commerce price list commerce account group rel.
	 *
	 * @param uuid the uuid of this commerce price list commerce account group rel
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the commerce price list commerce account group rel ID of this commerce price list commerce account group rel.
	 *
	 * @return the commerce price list commerce account group rel ID of this commerce price list commerce account group rel
	 */
	public long getCommercePriceListCommerceAccountGroupRelId();

	/**
	 * Sets the commerce price list commerce account group rel ID of this commerce price list commerce account group rel.
	 *
	 * @param commercePriceListCommerceAccountGroupRelId the commerce price list commerce account group rel ID of this commerce price list commerce account group rel
	 */
	public void setCommercePriceListCommerceAccountGroupRelId(
		long commercePriceListCommerceAccountGroupRelId);

	/**
	 * Returns the company ID of this commerce price list commerce account group rel.
	 *
	 * @return the company ID of this commerce price list commerce account group rel
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce price list commerce account group rel.
	 *
	 * @param companyId the company ID of this commerce price list commerce account group rel
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce price list commerce account group rel.
	 *
	 * @return the user ID of this commerce price list commerce account group rel
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce price list commerce account group rel.
	 *
	 * @param userId the user ID of this commerce price list commerce account group rel
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce price list commerce account group rel.
	 *
	 * @return the user uuid of this commerce price list commerce account group rel
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce price list commerce account group rel.
	 *
	 * @param userUuid the user uuid of this commerce price list commerce account group rel
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce price list commerce account group rel.
	 *
	 * @return the user name of this commerce price list commerce account group rel
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce price list commerce account group rel.
	 *
	 * @param userName the user name of this commerce price list commerce account group rel
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce price list commerce account group rel.
	 *
	 * @return the create date of this commerce price list commerce account group rel
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce price list commerce account group rel.
	 *
	 * @param createDate the create date of this commerce price list commerce account group rel
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce price list commerce account group rel.
	 *
	 * @return the modified date of this commerce price list commerce account group rel
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce price list commerce account group rel.
	 *
	 * @param modifiedDate the modified date of this commerce price list commerce account group rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the commerce price list ID of this commerce price list commerce account group rel.
	 *
	 * @return the commerce price list ID of this commerce price list commerce account group rel
	 */
	public long getCommercePriceListId();

	/**
	 * Sets the commerce price list ID of this commerce price list commerce account group rel.
	 *
	 * @param commercePriceListId the commerce price list ID of this commerce price list commerce account group rel
	 */
	public void setCommercePriceListId(long commercePriceListId);

	/**
	 * Returns the commerce account group ID of this commerce price list commerce account group rel.
	 *
	 * @return the commerce account group ID of this commerce price list commerce account group rel
	 */
	public long getCommerceAccountGroupId();

	/**
	 * Sets the commerce account group ID of this commerce price list commerce account group rel.
	 *
	 * @param commerceAccountGroupId the commerce account group ID of this commerce price list commerce account group rel
	 */
	public void setCommerceAccountGroupId(long commerceAccountGroupId);

	/**
	 * Returns the order of this commerce price list commerce account group rel.
	 *
	 * @return the order of this commerce price list commerce account group rel
	 */
	public int getOrder();

	/**
	 * Sets the order of this commerce price list commerce account group rel.
	 *
	 * @param order the order of this commerce price list commerce account group rel
	 */
	public void setOrder(int order);

	/**
	 * Returns the last publish date of this commerce price list commerce account group rel.
	 *
	 * @return the last publish date of this commerce price list commerce account group rel
	 */
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this commerce price list commerce account group rel.
	 *
	 * @param lastPublishDate the last publish date of this commerce price list commerce account group rel
	 */
	public void setLastPublishDate(Date lastPublishDate);

	@Override
	public CommercePriceListCommerceAccountGroupRel cloneWithOriginalValues();

}