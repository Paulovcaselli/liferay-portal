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

package com.liferay.template.web.internal.portlet.action.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.dynamic.data.mapping.exception.TemplateNameException;
import com.liferay.dynamic.data.mapping.exception.TemplateScriptException;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;
import com.liferay.info.item.InfoItemClassDetails;
import com.liferay.info.item.InfoItemFormVariation;
import com.liferay.info.item.InfoItemServiceTracker;
import com.liferay.info.item.provider.InfoItemFormVariationsProvider;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.portlet.MockLiferayPortletActionRequest;
import com.liferay.portal.kernel.test.portlet.MockLiferayPortletActionResponse;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.rule.Sync;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerMethodTestRule;
import com.liferay.template.info.item.capability.TemplateInfoItemCapability;
import com.liferay.template.model.TemplateEntry;
import com.liferay.template.service.TemplateEntryLocalService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Lourdes Fernández Besada
 */
@RunWith(Arquillian.class)
@Sync
public class AddTemplateEntryMVCActionCommandTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerMethodTestRule.INSTANCE);

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();

		_company = _companyLocalService.getCompany(_group.getCompanyId());

		_serviceContext = ServiceContextTestUtil.getServiceContext(
			_group.getGroupId(), TestPropsValues.getUserId());

		_serviceContext.setCompanyId(TestPropsValues.getCompanyId());

		ServiceContextThreadLocal.pushServiceContext(_serviceContext);
	}

	@Test
	public void testAddTemplateEntry() throws Exception {
		MockLiferayPortletActionRequest mockLiferayPortletActionRequest =
			_getMockLiferayPortletActionRequest();

		String name = RandomTestUtil.randomString();

		String infoItemClassName = null;

		String infoItemFormVariationKey = null;

		for (InfoItemClassDetails infoItemClassDetails :
				_infoItemServiceTracker.getInfoItemClassDetails(
					TemplateInfoItemCapability.KEY)) {

			InfoItemFormVariationsProvider<?> infoItemFormVariationsProvider =
				_infoItemServiceTracker.getFirstInfoItemService(
					InfoItemFormVariationsProvider.class,
					infoItemClassDetails.getClassName());

			if (infoItemFormVariationsProvider != null) {
				Collection<InfoItemFormVariation> infoItemFormVariations =
					infoItemFormVariationsProvider.getInfoItemFormVariations(
						_group.getGroupId());

				Stream<InfoItemFormVariation> infoItemFormVariationsStream =
					infoItemFormVariations.stream();

				InfoItemFormVariation infoItemFormVariation =
					infoItemFormVariationsStream.findFirst(
					).orElse(
						null
					);

				if (infoItemFormVariation == null) {
					continue;
				}

				infoItemClassName = infoItemClassDetails.getClassName();
				infoItemFormVariationKey = infoItemFormVariation.getKey();
			}
			else {
				infoItemClassName = infoItemClassDetails.getClassName();
				infoItemFormVariationKey = StringPool.BLANK;
			}

			break;
		}

		mockLiferayPortletActionRequest.addParameter(
			"infoItemClassName", infoItemClassName);
		mockLiferayPortletActionRequest.addParameter(
			"infoItemFormVariationKey", infoItemFormVariationKey);
		mockLiferayPortletActionRequest.addParameter("name", name);

		ReflectionTestUtil.invoke(
			_mvcActionCommand, "doTransactionalCommand",
			new Class<?>[] {ActionRequest.class, ActionResponse.class},
			mockLiferayPortletActionRequest,
			new MockLiferayPortletActionResponse());

		List<TemplateEntry> templateEntries =
			_templateEntryLocalService.getTemplateEntries(
				_group.getGroupId(), infoItemClassName,
				infoItemFormVariationKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null);

		Assert.assertEquals(
			templateEntries.toString(), 1, templateEntries.size());

		TemplateEntry templateEntry = templateEntries.get(0);

		DDMTemplate ddmTemplate = _ddmTemplateLocalService.getTemplate(
			templateEntry.getDDMTemplateId());

		Assert.assertNotNull(ddmTemplate);
	}

	@Test
	public void testHandleTemplateNameException() throws Exception {
		JSONObject jsonObject = ReflectionTestUtil.invoke(
			_mvcActionCommand, "_getErrorJSONObject",
			new Class<?>[] {PortalException.class, ThemeDisplay.class},
			new TemplateNameException(), _getThemeDisplay());

		Assert.assertTrue(jsonObject.has("name"));
	}

	@Test
	public void testHandleTemplateScriptException() throws Exception {
		ThemeDisplay themeDisplay = _getThemeDisplay();

		JSONObject jsonObject = ReflectionTestUtil.invoke(
			_mvcActionCommand, "_getErrorJSONObject",
			new Class<?>[] {PortalException.class, ThemeDisplay.class},
			new TemplateScriptException(), themeDisplay);

		Assert.assertTrue(jsonObject.has("other"));

		Assert.assertEquals(
			LanguageUtil.get(
				themeDisplay.getLocale(), "please-enter-a-valid-script"),
			jsonObject.get("other"));
	}

	@Test
	public void testHandleUnexpectedException() throws Exception {
		ThemeDisplay themeDisplay = _getThemeDisplay();

		JSONObject jsonObject = ReflectionTestUtil.invoke(
			_mvcActionCommand, "_getErrorJSONObject",
			new Class<?>[] {PortalException.class, ThemeDisplay.class},
			new PortalException(), themeDisplay);

		Assert.assertTrue(jsonObject.has("other"));

		Assert.assertEquals(
			LanguageUtil.get(
				themeDisplay.getLocale(), "an-unexpected-error-occurred"),
			jsonObject.get("other"));
	}

	private MockLiferayPortletActionRequest
			_getMockLiferayPortletActionRequest()
		throws Exception {

		MockLiferayPortletActionRequest mockLiferayPortletActionRequest =
			new MockLiferayPortletActionRequest();

		mockLiferayPortletActionRequest.setAttribute(
			WebKeys.THEME_DISPLAY, _getThemeDisplay());

		mockLiferayPortletActionRequest.addParameter(
			"groupId", String.valueOf(_group.getGroupId()));

		return mockLiferayPortletActionRequest;
	}

	private ThemeDisplay _getThemeDisplay() throws Exception {
		ThemeDisplay themeDisplay = new ThemeDisplay();

		themeDisplay.setCompany(_company);
		themeDisplay.setPermissionChecker(
			PermissionThreadLocal.getPermissionChecker());
		themeDisplay.setScopeGroupId(_group.getGroupId());
		themeDisplay.setSiteGroupId(_group.getGroupId());
		themeDisplay.setUser(TestPropsValues.getUser());

		return themeDisplay;
	}

	private Company _company;

	@Inject
	private CompanyLocalService _companyLocalService;

	@Inject
	private DDMTemplateLocalService _ddmTemplateLocalService;

	@DeleteAfterTestRun
	private Group _group;

	@Inject
	private InfoItemServiceTracker _infoItemServiceTracker;

	@Inject(filter = "mvc.command.name=/template/add_template_entry")
	private MVCActionCommand _mvcActionCommand;

	@Inject
	private Portal _portal;

	private ServiceContext _serviceContext;

	@Inject
	private TemplateEntryLocalService _templateEntryLocalService;

}