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

import ClayAlert from '@clayui/alert';
import ClayButton from '@clayui/button';
import ClayProgressBar from '@clayui/progress-bar';
import {useIsMounted} from '@liferay/frontend-js-react-web';
import {fetch} from 'frontend-js-web';
import PropTypes from 'prop-types';
import React, {useCallback, useContext, useEffect, useState} from 'react';

import {LOAD_DATA, SET_DATA, SET_ERROR} from '../constants/actionTypes';
import {ConstantsContext} from '../context/ConstantsContext';
import {StoreDispatchContext, StoreStateContext} from '../context/StoreContext';
import getPageSpeedProgress from '../utils/getPageSpeedProgress';
import loadIssues from '../utils/loadIssues';
import BasicInformation from './BasicInformation';
import EmptyLayoutReports from './EmptyLayoutReports';
import LayoutReportsIssuesList from './LayoutReportsIssuesList';

export default function LayoutReports({eventTriggered}) {
	const isMounted = useIsMounted();

	const {data, error, languageId, loading} = useContext(StoreStateContext);

	const {
		isPanelStateOpen,
		layoutReportsDataURL,
		portletNamespace,
	} = useContext(ConstantsContext);

	const dispatch = useContext(StoreDispatchContext);

	const safeDispatch = useCallback(
		(action) => {
			if (isMounted()) {
				dispatch(action);
			}
		},
		[dispatch, isMounted]
	);

	const [percentage, setPercentage] = useState(0);

	useEffect(() => {
		if (loading && !error) {
			const initial = Date.now();
			const interval = setInterval(() => {
				const elapsedTimeInSeconds = (Date.now() - initial) / 1000;
				const progress = getPageSpeedProgress(elapsedTimeInSeconds);

				setPercentage(progress.toFixed(0));
			}, 500);

			return () => {
				clearInterval(interval);
				setPercentage(0);
			};
		}
	}, [error, loading]);

	const getData = useCallback(
		(fetchURL) => {
			safeDispatch({type: LOAD_DATA});

			fetch(fetchURL, {method: 'GET'})
				.then((response) =>
					response.json().then((data) => {
						safeDispatch({
							data,
							loading: data.validConnection,
							type: SET_DATA,
						});

						if (data.validConnection) {
							const url = data.pageURLs.find(
								(pageURL) =>
									pageURL.languageId ===
									(languageId || data.defaultLanguageId)
							);

							loadIssues({
								dispatch: safeDispatch,
								portletNamespace,
								url,
							});
						}
					})
				)
				.catch(() => {
					safeDispatch({
						error: Liferay.Language.get(
							'an-unexpected-error-occurred'
						),
						type: SET_ERROR,
					});
				});
		},
		[languageId, portletNamespace, safeDispatch]
	);

	useEffect(() => {
		if (isPanelStateOpen && !data && !loading) {
			getData(layoutReportsDataURL);
		}
	}, [data, isPanelStateOpen, layoutReportsDataURL, loading, getData]);

	useEffect(() => {
		if (eventTriggered && !data) {
			getData(layoutReportsDataURL);
		}
	}, [eventTriggered, data, layoutReportsDataURL, getData]);

	const onRelaunchButtonClick = () => {
		const url = data.pageURLs.find(
			(pageURL) =>
				pageURL.languageId === (languageId || data.defaultLanguageId)
		);

		loadIssues({
			dispatch: safeDispatch,
			portletNamespace,
			url,
		});
	};

	return (
		<>
			{data?.validConnection && error && (
				<ErrorAlert error={error} onRelaunch={onRelaunchButtonClick} />
			)}

			<div className="c-p-3">
				{data && !error && (
					<BasicInformation
						defaultLanguageId={data.defaultLanguageId}
						pageURLs={data.pageURLs}
						selectedLanguageId={languageId}
					/>
				)}

				{loading ? (
					<div className="c-my-4 text-secondary">
						{Liferay.Language.get(
							'connecting-with-google-pagespeed'
						)}
						<ClayProgressBar value={percentage} />
					</div>
				) : (
					data &&
					!error &&
					(data.validConnection && data?.layoutReportsIssues ? (
						<LayoutReportsIssuesList />
					) : (
						<EmptyLayoutReports />
					))
				)}
			</div>
		</>
	);
}

LayoutReports.propTypes = {
	eventTriggered: PropTypes.bool.isRequired,
};

const ErrorAlert = ({error, onRelaunch}) =>
	error?.message ? (
		<ClayAlert displayType="danger" variant="stripe">
			{error.message}

			<ClayAlert.Footer>
				<ClayButton.Group>
					<ClayButton alert onClick={onRelaunch}>
						{error.buttonTitle}
					</ClayButton>
				</ClayButton.Group>
			</ClayAlert.Footer>
		</ClayAlert>
	) : (
		<ClayAlert displayType="danger" variant="stripe">
			{error}
		</ClayAlert>
	);

ErrorAlert.propTypes = {
	error: PropTypes.object.isRequired,
	onRelaunch: PropTypes.func.isRequired,
};
