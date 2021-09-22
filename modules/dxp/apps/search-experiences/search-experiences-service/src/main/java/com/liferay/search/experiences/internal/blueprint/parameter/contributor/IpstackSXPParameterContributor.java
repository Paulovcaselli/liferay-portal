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

package com.liferay.search.experiences.internal.blueprint.parameter.contributor;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.search.experiences.blueprint.parameter.DoubleSXPParameter;
import com.liferay.search.experiences.blueprint.parameter.SXPParameter;
import com.liferay.search.experiences.blueprint.parameter.StringSXPParameter;
import com.liferay.search.experiences.blueprint.parameter.contributor.SXPParameterContributor;
import com.liferay.search.experiences.blueprint.parameter.contributor.SXPParameterContributorDefinition;
import com.liferay.search.experiences.internal.configuration.IpstackConfiguration;
import com.liferay.search.experiences.model.SXPBlueprint;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Petteri Karttunen
 */
public class IpstackSXPParameterContributor implements SXPParameterContributor {

	public IpstackSXPParameterContributor(
		ConfigurationProvider configurationProvider) {

		_configurationProvider = configurationProvider;
	}

	@Override
	public void contribute(
		SearchContext searchContext, SXPBlueprint sxpBlueprint,
		Set<SXPParameter> sxpParameters) {

		IpstackConfiguration ipstackConfiguration = _getIpstackConfiguration(
			searchContext.getCompanyId());

		if (!ipstackConfiguration.enabled()) {
			return;
		}
	}

	@Override
	public String getSXPParameterCategoryNameKey() {
		return "ip";
	}

	@Override
	public List<SXPParameterContributorDefinition>
		getSXPParameterContributorDefinitions(long companyId) {

		IpstackConfiguration ipstackConfiguration = _getIpstackConfiguration(
			companyId);

		if (!ipstackConfiguration.enabled()) {
			return Collections.<SXPParameterContributorDefinition>emptyList();
		}

		return Arrays.asList(
			new SXPParameterContributorDefinition(
				StringSXPParameter.class, "city", "ipstack.city"),
			new SXPParameterContributorDefinition(
				StringSXPParameter.class, "continent-code",
				"ipstack.continent_code"),
			new SXPParameterContributorDefinition(
				StringSXPParameter.class, "continent-name",
				"ipstack.continent_name"),
			new SXPParameterContributorDefinition(
				StringSXPParameter.class, "country-code",
				"ipstack.country_code"),
			new SXPParameterContributorDefinition(
				StringSXPParameter.class, "country-name",
				"ipstack.country_name"),
			new SXPParameterContributorDefinition(
				DoubleSXPParameter.class, "latitude", "ipstack.latitude"),
			new SXPParameterContributorDefinition(
				DoubleSXPParameter.class, "longitude", "ipstack.longitude"),
			new SXPParameterContributorDefinition(
				StringSXPParameter.class, "region-code", "ipstack.region_code"),
			new SXPParameterContributorDefinition(
				StringSXPParameter.class, "region-name", "ipstack.region_name"),
			new SXPParameterContributorDefinition(
				StringSXPParameter.class, "zip-code", "ipstack.zip"));
	}

	private IpstackConfiguration _getIpstackConfiguration(long companyId) {
		try {
			return _configurationProvider.getCompanyConfiguration(
				IpstackConfiguration.class, companyId);
		}
		catch (ConfigurationException configurationException) {
			return ReflectionUtil.throwException(configurationException);
		}
	}

	private final ConfigurationProvider _configurationProvider;

}