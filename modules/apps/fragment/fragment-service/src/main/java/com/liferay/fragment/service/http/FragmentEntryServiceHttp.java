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

package com.liferay.fragment.service.http;

import com.liferay.fragment.service.FragmentEntryServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>FragmentEntryServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FragmentEntryServiceSoap
 * @generated
 */
public class FragmentEntryServiceHttp {

	public static com.liferay.fragment.model.FragmentEntry addFragmentEntry(
			HttpPrincipal httpPrincipal, long groupId,
			long fragmentCollectionId, String fragmentEntryKey, String name,
			long previewFileEntryId, int type, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "addFragmentEntry",
				_addFragmentEntryParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, fragmentEntryKey,
				name, previewFileEntryId, type, status, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry addFragmentEntry(
			HttpPrincipal httpPrincipal, long groupId,
			long fragmentCollectionId, String fragmentEntryKey, String name,
			String css, String html, String js, boolean cacheable,
			String configuration, long previewFileEntryId, int type, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "addFragmentEntry",
				_addFragmentEntryParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, fragmentEntryKey,
				name, css, html, js, cacheable, configuration,
				previewFileEntryId, type, status, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry addFragmentEntry(
			HttpPrincipal httpPrincipal, long groupId,
			long fragmentCollectionId, String fragmentEntryKey, String name,
			String css, String html, String js, boolean cacheable,
			String configuration, String icon, long previewFileEntryId,
			int type, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "addFragmentEntry",
				_addFragmentEntryParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, fragmentEntryKey,
				name, css, html, js, cacheable, configuration, icon,
				previewFileEntryId, type, status, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry addFragmentEntry(
			HttpPrincipal httpPrincipal, long groupId,
			long fragmentCollectionId, String fragmentEntryKey, String name,
			String css, String html, String js, String configuration,
			long previewFileEntryId, int type, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "addFragmentEntry",
				_addFragmentEntryParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, fragmentEntryKey,
				name, css, html, js, configuration, previewFileEntryId, type,
				status, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry copyFragmentEntry(
			HttpPrincipal httpPrincipal, long groupId, long fragmentEntryId,
			long fragmentCollectionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "copyFragmentEntry",
				_copyFragmentEntryParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentEntryId, fragmentCollectionId,
				serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deleteFragmentEntries(
			HttpPrincipal httpPrincipal, long[] fragmentEntriesIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "deleteFragmentEntries",
				_deleteFragmentEntriesParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fragmentEntriesIds);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry deleteFragmentEntry(
			HttpPrincipal httpPrincipal, long fragmentEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "deleteFragmentEntry",
				_deleteFragmentEntryParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fragmentEntryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry fetchDraft(
		HttpPrincipal httpPrincipal, long primaryKey) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "fetchDraft",
				_fetchDraftParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry fetchFragmentEntry(
			HttpPrincipal httpPrincipal, long fragmentEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "fetchFragmentEntry",
				_fetchFragmentEntryParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fragmentEntryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry getDraft(
			HttpPrincipal httpPrincipal, long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "getDraft",
				_getDraftParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<Object>
		getFragmentCompositionsAndFragmentEntries(
			HttpPrincipal httpPrincipal, long groupId,
			long fragmentCollectionId, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<?>
				orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class,
				"getFragmentCompositionsAndFragmentEntries",
				_getFragmentCompositionsAndFragmentEntriesParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, status, start, end,
				orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<Object>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<Object>
		getFragmentCompositionsAndFragmentEntries(
			HttpPrincipal httpPrincipal, long groupId,
			long fragmentCollectionId, String name, int status, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator<?>
				orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class,
				"getFragmentCompositionsAndFragmentEntries",
				_getFragmentCompositionsAndFragmentEntriesParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, name, status, start,
				end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<Object>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getFragmentCompositionsAndFragmentEntriesCount(
		HttpPrincipal httpPrincipal, long groupId, long fragmentCollectionId,
		int status) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class,
				"getFragmentCompositionsAndFragmentEntriesCount",
				_getFragmentCompositionsAndFragmentEntriesCountParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getFragmentCompositionsAndFragmentEntriesCount(
		HttpPrincipal httpPrincipal, long groupId, long fragmentCollectionId,
		String name, int status) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class,
				"getFragmentCompositionsAndFragmentEntriesCount",
				_getFragmentCompositionsAndFragmentEntriesCountParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, name, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.fragment.model.FragmentEntry>
		getFragmentEntries(
			HttpPrincipal httpPrincipal, long fragmentCollectionId) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "getFragmentEntries",
				_getFragmentEntriesParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fragmentCollectionId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.fragment.model.FragmentEntry>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.fragment.model.FragmentEntry>
		getFragmentEntries(
			HttpPrincipal httpPrincipal, long groupId,
			long fragmentCollectionId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "getFragmentEntries",
				_getFragmentEntriesParameterTypes15);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.fragment.model.FragmentEntry>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.fragment.model.FragmentEntry>
		getFragmentEntries(
			HttpPrincipal httpPrincipal, long groupId,
			long fragmentCollectionId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.fragment.model.FragmentEntry> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "getFragmentEntries",
				_getFragmentEntriesParameterTypes16);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, start, end,
				orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.fragment.model.FragmentEntry>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.fragment.model.FragmentEntry>
		getFragmentEntriesByName(
			HttpPrincipal httpPrincipal, long groupId,
			long fragmentCollectionId, String name, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.fragment.model.FragmentEntry> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "getFragmentEntriesByName",
				_getFragmentEntriesByNameParameterTypes17);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, name, start, end,
				orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.fragment.model.FragmentEntry>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.fragment.model.FragmentEntry>
		getFragmentEntriesByNameAndStatus(
			HttpPrincipal httpPrincipal, long groupId,
			long fragmentCollectionId, String name, int status, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.fragment.model.FragmentEntry> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class,
				"getFragmentEntriesByNameAndStatus",
				_getFragmentEntriesByNameAndStatusParameterTypes18);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, name, status, start,
				end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.fragment.model.FragmentEntry>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.fragment.model.FragmentEntry>
		getFragmentEntriesByStatus(
			HttpPrincipal httpPrincipal, long groupId,
			long fragmentCollectionId, int status) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "getFragmentEntriesByStatus",
				_getFragmentEntriesByStatusParameterTypes19);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.fragment.model.FragmentEntry>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.fragment.model.FragmentEntry>
		getFragmentEntriesByStatus(
			HttpPrincipal httpPrincipal, long groupId,
			long fragmentCollectionId, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.fragment.model.FragmentEntry> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "getFragmentEntriesByStatus",
				_getFragmentEntriesByStatusParameterTypes20);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, status, start, end,
				orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.fragment.model.FragmentEntry>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.fragment.model.FragmentEntry>
		getFragmentEntriesByType(
			HttpPrincipal httpPrincipal, long groupId,
			long fragmentCollectionId, int type, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.fragment.model.FragmentEntry> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "getFragmentEntriesByType",
				_getFragmentEntriesByTypeParameterTypes21);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, type, start, end,
				orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.fragment.model.FragmentEntry>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.fragment.model.FragmentEntry>
		getFragmentEntriesByTypeAndStatus(
			HttpPrincipal httpPrincipal, long groupId,
			long fragmentCollectionId, int type, int status) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class,
				"getFragmentEntriesByTypeAndStatus",
				_getFragmentEntriesByTypeAndStatusParameterTypes22);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, type, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.fragment.model.FragmentEntry>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.fragment.model.FragmentEntry>
		getFragmentEntriesByTypeAndStatus(
			HttpPrincipal httpPrincipal, long groupId,
			long fragmentCollectionId, int type, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.fragment.model.FragmentEntry> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class,
				"getFragmentEntriesByTypeAndStatus",
				_getFragmentEntriesByTypeAndStatusParameterTypes23);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, type, status, start,
				end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.fragment.model.FragmentEntry>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getFragmentEntriesCount(
		HttpPrincipal httpPrincipal, long groupId, long fragmentCollectionId) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "getFragmentEntriesCount",
				_getFragmentEntriesCountParameterTypes24);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getFragmentEntriesCountByName(
		HttpPrincipal httpPrincipal, long groupId, long fragmentCollectionId,
		String name) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "getFragmentEntriesCountByName",
				_getFragmentEntriesCountByNameParameterTypes25);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getFragmentEntriesCountByNameAndStatus(
		HttpPrincipal httpPrincipal, long groupId, long fragmentCollectionId,
		String name, int status) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class,
				"getFragmentEntriesCountByNameAndStatus",
				_getFragmentEntriesCountByNameAndStatusParameterTypes26);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, name, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getFragmentEntriesCountByStatus(
		HttpPrincipal httpPrincipal, long groupId, long fragmentCollectionId,
		int status) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class,
				"getFragmentEntriesCountByStatus",
				_getFragmentEntriesCountByStatusParameterTypes27);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getFragmentEntriesCountByType(
		HttpPrincipal httpPrincipal, long groupId, long fragmentCollectionId,
		int type) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "getFragmentEntriesCountByType",
				_getFragmentEntriesCountByTypeParameterTypes28);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, type);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getFragmentEntriesCountByTypeAndStatus(
		HttpPrincipal httpPrincipal, long groupId, long fragmentCollectionId,
		int type, int status) {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class,
				"getFragmentEntriesCountByTypeAndStatus",
				_getFragmentEntriesCountByTypeAndStatusParameterTypes29);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, fragmentCollectionId, type, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static String[] getTempFileNames(
			HttpPrincipal httpPrincipal, long groupId, String folderName)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "getTempFileNames",
				_getTempFileNamesParameterTypes30);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, folderName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (String[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry moveFragmentEntry(
			HttpPrincipal httpPrincipal, long fragmentEntryId,
			long fragmentCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "moveFragmentEntry",
				_moveFragmentEntryParameterTypes31);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fragmentEntryId, fragmentCollectionId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry publishDraft(
			HttpPrincipal httpPrincipal,
			com.liferay.fragment.model.FragmentEntry draftFragmentEntry)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "publishDraft",
				_publishDraftParameterTypes32);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, draftFragmentEntry);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry updateDraft(
			HttpPrincipal httpPrincipal,
			com.liferay.fragment.model.FragmentEntry draftFragmentEntry)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "updateDraft",
				_updateDraftParameterTypes33);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, draftFragmentEntry);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry updateFragmentEntry(
			HttpPrincipal httpPrincipal,
			com.liferay.fragment.model.FragmentEntry fragmentEntry)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "updateFragmentEntry",
				_updateFragmentEntryParameterTypes34);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fragmentEntry);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry updateFragmentEntry(
			HttpPrincipal httpPrincipal, long fragmentEntryId,
			long previewFileEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "updateFragmentEntry",
				_updateFragmentEntryParameterTypes35);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fragmentEntryId, previewFileEntryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry updateFragmentEntry(
			HttpPrincipal httpPrincipal, long fragmentEntryId,
			long fragmentCollectionId, String name, String css, String html,
			String js, boolean cacheable, String configuration,
			long previewFileEntryId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "updateFragmentEntry",
				_updateFragmentEntryParameterTypes36);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fragmentEntryId, fragmentCollectionId, name, css,
				html, js, cacheable, configuration, previewFileEntryId, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry updateFragmentEntry(
			HttpPrincipal httpPrincipal, long fragmentEntryId,
			long fragmentCollectionId, String name, String css, String html,
			String js, boolean cacheable, String configuration, String icon,
			long previewFileEntryId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "updateFragmentEntry",
				_updateFragmentEntryParameterTypes37);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fragmentEntryId, fragmentCollectionId, name, css,
				html, js, cacheable, configuration, icon, previewFileEntryId,
				status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry updateFragmentEntry(
			HttpPrincipal httpPrincipal, long fragmentEntryId, String name)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "updateFragmentEntry",
				_updateFragmentEntryParameterTypes38);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fragmentEntryId, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry updateFragmentEntry(
			HttpPrincipal httpPrincipal, long fragmentEntryId, String name,
			String css, String html, String js, boolean cacheable,
			String configuration, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "updateFragmentEntry",
				_updateFragmentEntryParameterTypes39);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fragmentEntryId, name, css, html, js, cacheable,
				configuration, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry updateFragmentEntry(
			HttpPrincipal httpPrincipal, long fragmentEntryId, String name,
			String css, String html, String js, boolean cacheable,
			String configuration, long previewFileEntryId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "updateFragmentEntry",
				_updateFragmentEntryParameterTypes40);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fragmentEntryId, name, css, html, js, cacheable,
				configuration, previewFileEntryId, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry updateFragmentEntry(
			HttpPrincipal httpPrincipal, long fragmentEntryId, String name,
			String css, String html, String js, String configuration,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "updateFragmentEntry",
				_updateFragmentEntryParameterTypes41);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fragmentEntryId, name, css, html, js, configuration,
				status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.fragment.model.FragmentEntry updateFragmentEntry(
			HttpPrincipal httpPrincipal, long fragmentEntryId, String name,
			String css, String html, String js, String configuration,
			long previewFileEntryId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FragmentEntryServiceUtil.class, "updateFragmentEntry",
				_updateFragmentEntryParameterTypes42);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fragmentEntryId, name, css, html, js, configuration,
				previewFileEntryId, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.fragment.model.FragmentEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		FragmentEntryServiceHttp.class);

	private static final Class<?>[] _addFragmentEntryParameterTypes0 =
		new Class[] {
			long.class, long.class, String.class, String.class, long.class,
			int.class, int.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _addFragmentEntryParameterTypes1 =
		new Class[] {
			long.class, long.class, String.class, String.class, String.class,
			String.class, String.class, boolean.class, String.class, long.class,
			int.class, int.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _addFragmentEntryParameterTypes2 =
		new Class[] {
			long.class, long.class, String.class, String.class, String.class,
			String.class, String.class, boolean.class, String.class,
			String.class, long.class, int.class, int.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _addFragmentEntryParameterTypes3 =
		new Class[] {
			long.class, long.class, String.class, String.class, String.class,
			String.class, String.class, String.class, long.class, int.class,
			int.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _copyFragmentEntryParameterTypes4 =
		new Class[] {
			long.class, long.class, long.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteFragmentEntriesParameterTypes5 =
		new Class[] {long[].class};
	private static final Class<?>[] _deleteFragmentEntryParameterTypes6 =
		new Class[] {long.class};
	private static final Class<?>[] _fetchDraftParameterTypes7 = new Class[] {
		long.class
	};
	private static final Class<?>[] _fetchFragmentEntryParameterTypes8 =
		new Class[] {long.class};
	private static final Class<?>[] _getDraftParameterTypes9 = new Class[] {
		long.class
	};
	private static final Class<?>[]
		_getFragmentCompositionsAndFragmentEntriesParameterTypes10 =
			new Class[] {
				long.class, long.class, int.class, int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class
			};
	private static final Class<?>[]
		_getFragmentCompositionsAndFragmentEntriesParameterTypes11 =
			new Class[] {
				long.class, long.class, String.class, int.class, int.class,
				int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class
			};
	private static final Class<?>[]
		_getFragmentCompositionsAndFragmentEntriesCountParameterTypes12 =
			new Class[] {long.class, long.class, int.class};
	private static final Class<?>[]
		_getFragmentCompositionsAndFragmentEntriesCountParameterTypes13 =
			new Class[] {long.class, long.class, String.class, int.class};
	private static final Class<?>[] _getFragmentEntriesParameterTypes14 =
		new Class[] {long.class};
	private static final Class<?>[] _getFragmentEntriesParameterTypes15 =
		new Class[] {long.class, long.class, int.class, int.class};
	private static final Class<?>[] _getFragmentEntriesParameterTypes16 =
		new Class[] {
			long.class, long.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getFragmentEntriesByNameParameterTypes17 =
		new Class[] {
			long.class, long.class, String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[]
		_getFragmentEntriesByNameAndStatusParameterTypes18 = new Class[] {
			long.class, long.class, String.class, int.class, int.class,
			int.class, com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[]
		_getFragmentEntriesByStatusParameterTypes19 = new Class[] {
			long.class, long.class, int.class
		};
	private static final Class<?>[]
		_getFragmentEntriesByStatusParameterTypes20 = new Class[] {
			long.class, long.class, int.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getFragmentEntriesByTypeParameterTypes21 =
		new Class[] {
			long.class, long.class, int.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[]
		_getFragmentEntriesByTypeAndStatusParameterTypes22 = new Class[] {
			long.class, long.class, int.class, int.class
		};
	private static final Class<?>[]
		_getFragmentEntriesByTypeAndStatusParameterTypes23 = new Class[] {
			long.class, long.class, int.class, int.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getFragmentEntriesCountParameterTypes24 =
		new Class[] {long.class, long.class};
	private static final Class<?>[]
		_getFragmentEntriesCountByNameParameterTypes25 = new Class[] {
			long.class, long.class, String.class
		};
	private static final Class<?>[]
		_getFragmentEntriesCountByNameAndStatusParameterTypes26 = new Class[] {
			long.class, long.class, String.class, int.class
		};
	private static final Class<?>[]
		_getFragmentEntriesCountByStatusParameterTypes27 = new Class[] {
			long.class, long.class, int.class
		};
	private static final Class<?>[]
		_getFragmentEntriesCountByTypeParameterTypes28 = new Class[] {
			long.class, long.class, int.class
		};
	private static final Class<?>[]
		_getFragmentEntriesCountByTypeAndStatusParameterTypes29 = new Class[] {
			long.class, long.class, int.class, int.class
		};
	private static final Class<?>[] _getTempFileNamesParameterTypes30 =
		new Class[] {long.class, String.class};
	private static final Class<?>[] _moveFragmentEntryParameterTypes31 =
		new Class[] {long.class, long.class};
	private static final Class<?>[] _publishDraftParameterTypes32 =
		new Class[] {com.liferay.fragment.model.FragmentEntry.class};
	private static final Class<?>[] _updateDraftParameterTypes33 = new Class[] {
		com.liferay.fragment.model.FragmentEntry.class
	};
	private static final Class<?>[] _updateFragmentEntryParameterTypes34 =
		new Class[] {com.liferay.fragment.model.FragmentEntry.class};
	private static final Class<?>[] _updateFragmentEntryParameterTypes35 =
		new Class[] {long.class, long.class};
	private static final Class<?>[] _updateFragmentEntryParameterTypes36 =
		new Class[] {
			long.class, long.class, String.class, String.class, String.class,
			String.class, boolean.class, String.class, long.class, int.class
		};
	private static final Class<?>[] _updateFragmentEntryParameterTypes37 =
		new Class[] {
			long.class, long.class, String.class, String.class, String.class,
			String.class, boolean.class, String.class, String.class, long.class,
			int.class
		};
	private static final Class<?>[] _updateFragmentEntryParameterTypes38 =
		new Class[] {long.class, String.class};
	private static final Class<?>[] _updateFragmentEntryParameterTypes39 =
		new Class[] {
			long.class, String.class, String.class, String.class, String.class,
			boolean.class, String.class, int.class
		};
	private static final Class<?>[] _updateFragmentEntryParameterTypes40 =
		new Class[] {
			long.class, String.class, String.class, String.class, String.class,
			boolean.class, String.class, long.class, int.class
		};
	private static final Class<?>[] _updateFragmentEntryParameterTypes41 =
		new Class[] {
			long.class, String.class, String.class, String.class, String.class,
			String.class, int.class
		};
	private static final Class<?>[] _updateFragmentEntryParameterTypes42 =
		new Class[] {
			long.class, String.class, String.class, String.class, String.class,
			String.class, long.class, int.class
		};

}