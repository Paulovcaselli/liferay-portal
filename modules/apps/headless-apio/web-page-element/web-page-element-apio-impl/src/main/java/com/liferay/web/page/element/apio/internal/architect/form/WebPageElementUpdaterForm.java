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

package com.liferay.web.page.element.apio.internal.architect.form;

import com.liferay.apio.architect.form.Form;
import com.liferay.apio.architect.form.Form.Builder;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;

/**
 * Instances of this class represent the values extracted from a web page
 * element form.
 *
 * @author Alejandro Hernández
 * @review
 */
public class WebPageElementUpdaterForm {

	/**
	 * Builds a {@code Form} that generates {@code WebPageElementUpdaterForm}
	 * depending on the HTTP body.
	 *
	 * @param  formBuilder the {@code Form} builder
	 * @return a web page element updater form
	 * @review
	 */
	public static Form<WebPageElementUpdaterForm> buildForm(
		Builder<WebPageElementUpdaterForm> formBuilder) {

		return formBuilder.title(
			__ -> "The web page element updater form"
		).description(
			__ -> "This form can be used to update a web page element"
		).constructor(
			WebPageElementUpdaterForm::new
		).addRequiredLong(
			"group", WebPageElementUpdaterForm::_setGroup
		).addRequiredLong(
			"user", WebPageElementUpdaterForm::_setUser
		).addRequiredLong(
			"version", WebPageElementUpdaterForm::_setVersion
		).addRequiredString(
			"description", WebPageElementUpdaterForm::_setDescription
		).addRequiredString(
			"text", WebPageElementUpdaterForm::_setText
		).addRequiredString(
			"title", WebPageElementUpdaterForm::_setTitle
		).build();
	}

	/**
	 * Returns the web page element's description map.
	 *
	 * @return the web page element's description map
	 * @review
	 */
	public Map<Locale, String> getDescriptionMap() {
		return Collections.singletonMap(Locale.getDefault(), _description);
	}

	/**
	 * Returns the web page element group's ID.
	 *
	 * @return the web page element group's ID
	 * @review
	 */
	public long getGroup() {
		return _group;
	}

	/**
	 * Returns the web page element's text.
	 *
	 * @return the web page element's text
	 * @review
	 */
	public String getText() {
		return _text;
	}

	/**
	 * Returns the web page element's title map.
	 *
	 * @return the web page element's title map
	 * @review
	 */
	public Map<Locale, String> getTitleMap() {
		return Collections.singletonMap(Locale.getDefault(), _title);
	}

	/**
	 * Returns the web page element user's ID.
	 *
	 * @return the web page element user's ID
	 * @review
	 */
	public long getUser() {
		return _user;
	}

	/**
	 * Returns the web page element version's ID.
	 *
	 * @return the web page element version's ID
	 * @review
	 */
	public long getVersion() {
		return _version;
	}

	private void _setDescription(String description) {
		_description = description;
	}

	private void _setGroup(long group) {
		_group = group;
	}

	private void _setText(String text) {
		_text = text;
	}

	private void _setTitle(String title) {
		_title = title;
	}

	private void _setUser(long user) {
		_user = user;
	}

	private void _setVersion(long version) {
		_version = version;
	}

	private String _description;
	private long _group;
	private String _text;
	private String _title;
	private long _user;
	private long _version;

}