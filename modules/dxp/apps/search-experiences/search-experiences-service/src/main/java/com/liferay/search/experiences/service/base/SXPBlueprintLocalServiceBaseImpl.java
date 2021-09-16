/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.search.experiences.service.base;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerRegistryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.search.experiences.model.SXPBlueprint;
import com.liferay.search.experiences.service.SXPBlueprintLocalService;
import com.liferay.search.experiences.service.SXPBlueprintLocalServiceUtil;
import com.liferay.search.experiences.service.persistence.SXPBlueprintPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the sxp blueprint local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.search.experiences.service.impl.SXPBlueprintLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.search.experiences.service.impl.SXPBlueprintLocalServiceImpl
 * @generated
 */
public abstract class SXPBlueprintLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, SXPBlueprintLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>SXPBlueprintLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>SXPBlueprintLocalServiceUtil</code>.
	 */

	/**
	 * Adds the sxp blueprint to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SXPBlueprintLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sxpBlueprint the sxp blueprint
	 * @return the sxp blueprint that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SXPBlueprint addSXPBlueprint(SXPBlueprint sxpBlueprint) {
		sxpBlueprint.setNew(true);

		return sxpBlueprintPersistence.update(sxpBlueprint);
	}

	/**
	 * Creates a new sxp blueprint with the primary key. Does not add the sxp blueprint to the database.
	 *
	 * @param sxpBlueprintId the primary key for the new sxp blueprint
	 * @return the new sxp blueprint
	 */
	@Override
	@Transactional(enabled = false)
	public SXPBlueprint createSXPBlueprint(long sxpBlueprintId) {
		return sxpBlueprintPersistence.create(sxpBlueprintId);
	}

	/**
	 * Deletes the sxp blueprint with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SXPBlueprintLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sxpBlueprintId the primary key of the sxp blueprint
	 * @return the sxp blueprint that was removed
	 * @throws PortalException if a sxp blueprint with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SXPBlueprint deleteSXPBlueprint(long sxpBlueprintId)
		throws PortalException {

		return sxpBlueprintPersistence.remove(sxpBlueprintId);
	}

	/**
	 * Deletes the sxp blueprint from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SXPBlueprintLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sxpBlueprint the sxp blueprint
	 * @return the sxp blueprint that was removed
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SXPBlueprint deleteSXPBlueprint(SXPBlueprint sxpBlueprint)
		throws PortalException {

		return sxpBlueprintPersistence.remove(sxpBlueprint);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return sxpBlueprintPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			SXPBlueprint.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return sxpBlueprintPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.search.experiences.model.impl.SXPBlueprintModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return sxpBlueprintPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.search.experiences.model.impl.SXPBlueprintModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return sxpBlueprintPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return sxpBlueprintPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return sxpBlueprintPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public SXPBlueprint fetchSXPBlueprint(long sxpBlueprintId) {
		return sxpBlueprintPersistence.fetchByPrimaryKey(sxpBlueprintId);
	}

	/**
	 * Returns the sxp blueprint matching the UUID and group.
	 *
	 * @param uuid the sxp blueprint's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sxp blueprint, or <code>null</code> if a matching sxp blueprint could not be found
	 */
	@Override
	public SXPBlueprint fetchSXPBlueprintByUuidAndGroupId(
		String uuid, long groupId) {

		return sxpBlueprintPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sxp blueprint with the primary key.
	 *
	 * @param sxpBlueprintId the primary key of the sxp blueprint
	 * @return the sxp blueprint
	 * @throws PortalException if a sxp blueprint with the primary key could not be found
	 */
	@Override
	public SXPBlueprint getSXPBlueprint(long sxpBlueprintId)
		throws PortalException {

		return sxpBlueprintPersistence.findByPrimaryKey(sxpBlueprintId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(sxpBlueprintLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(SXPBlueprint.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("sxpBlueprintId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			sxpBlueprintLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(SXPBlueprint.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"sxpBlueprintId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(sxpBlueprintLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(SXPBlueprint.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("sxpBlueprintId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					Criterion modifiedDateCriterion =
						portletDataContext.getDateRangeCriteria("modifiedDate");

					Criterion statusDateCriterion =
						portletDataContext.getDateRangeCriteria("statusDate");

					if ((modifiedDateCriterion != null) &&
						(statusDateCriterion != null)) {

						Disjunction disjunction =
							RestrictionsFactoryUtil.disjunction();

						disjunction.add(modifiedDateCriterion);
						disjunction.add(statusDateCriterion);

						dynamicQuery.add(disjunction);
					}

					Property workflowStatusProperty =
						PropertyFactoryUtil.forName("status");

					if (portletDataContext.isInitialPublication()) {
						dynamicQuery.add(
							workflowStatusProperty.ne(
								WorkflowConstants.STATUS_IN_TRASH));
					}
					else {
						StagedModelDataHandler<?> stagedModelDataHandler =
							StagedModelDataHandlerRegistryUtil.
								getStagedModelDataHandler(
									SXPBlueprint.class.getName());

						dynamicQuery.add(
							workflowStatusProperty.in(
								stagedModelDataHandler.
									getExportableStatuses()));
					}
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<SXPBlueprint>() {

				@Override
				public void performAction(SXPBlueprint sxpBlueprint)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, sxpBlueprint);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(SXPBlueprint.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return sxpBlueprintPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return sxpBlueprintLocalService.deleteSXPBlueprint(
			(SXPBlueprint)persistedModel);
	}

	@Override
	public BasePersistence<SXPBlueprint> getBasePersistence() {
		return sxpBlueprintPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return sxpBlueprintPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the sxp blueprints matching the UUID and company.
	 *
	 * @param uuid the UUID of the sxp blueprints
	 * @param companyId the primary key of the company
	 * @return the matching sxp blueprints, or an empty list if no matches were found
	 */
	@Override
	public List<SXPBlueprint> getSXPBlueprintsByUuidAndCompanyId(
		String uuid, long companyId) {

		return sxpBlueprintPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of sxp blueprints matching the UUID and company.
	 *
	 * @param uuid the UUID of the sxp blueprints
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of sxp blueprints
	 * @param end the upper bound of the range of sxp blueprints (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching sxp blueprints, or an empty list if no matches were found
	 */
	@Override
	public List<SXPBlueprint> getSXPBlueprintsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SXPBlueprint> orderByComparator) {

		return sxpBlueprintPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the sxp blueprint matching the UUID and group.
	 *
	 * @param uuid the sxp blueprint's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sxp blueprint
	 * @throws PortalException if a matching sxp blueprint could not be found
	 */
	@Override
	public SXPBlueprint getSXPBlueprintByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return sxpBlueprintPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the sxp blueprints.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.search.experiences.model.impl.SXPBlueprintModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sxp blueprints
	 * @param end the upper bound of the range of sxp blueprints (not inclusive)
	 * @return the range of sxp blueprints
	 */
	@Override
	public List<SXPBlueprint> getSXPBlueprints(int start, int end) {
		return sxpBlueprintPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of sxp blueprints.
	 *
	 * @return the number of sxp blueprints
	 */
	@Override
	public int getSXPBlueprintsCount() {
		return sxpBlueprintPersistence.countAll();
	}

	/**
	 * Updates the sxp blueprint in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SXPBlueprintLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sxpBlueprint the sxp blueprint
	 * @return the sxp blueprint that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SXPBlueprint updateSXPBlueprint(SXPBlueprint sxpBlueprint) {
		return sxpBlueprintPersistence.update(sxpBlueprint);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			SXPBlueprintLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		sxpBlueprintLocalService = (SXPBlueprintLocalService)aopProxy;

		_setLocalServiceUtilService(sxpBlueprintLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return SXPBlueprintLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return SXPBlueprint.class;
	}

	protected String getModelClassName() {
		return SXPBlueprint.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = sxpBlueprintPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		SXPBlueprintLocalService sxpBlueprintLocalService) {

		try {
			Field field = SXPBlueprintLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, sxpBlueprintLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected SXPBlueprintLocalService sxpBlueprintLocalService;

	@Reference
	protected SXPBlueprintPersistence sxpBlueprintPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

}