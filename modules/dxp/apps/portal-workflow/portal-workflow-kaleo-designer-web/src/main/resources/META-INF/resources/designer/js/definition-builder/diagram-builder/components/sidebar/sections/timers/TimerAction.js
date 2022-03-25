/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 */

import ClayButton, {ClayButtonWithIcon} from '@clayui/button';
import PropTypes from 'prop-types';
import React, {useState} from 'react';

import SidebarPanel from '../../SidebarPanel';
import ActionTypeAction from './select-action/ActionTypeAction';
import ActionTypeNotification from './select-action/ActionTypeNotification';
import ActionTypeReassignment from './select-action/ActionTypeReassignment';
import SelectActionType from './select-action/SelectActionType';

const actionSectionComponents = {
	actions: ActionTypeAction,
	notifications: ActionTypeNotification,
	reassignments: ActionTypeReassignment,
};

const TimerAction = ({
	actionSectionsIndex,
	reassignments,
	sectionsLength,
	setActionSections,
	setErrors,
	timersIndex,
}) => {
	const [actionType, setActionType] = useState('actions');

	const ActionSectionComponent = actionSectionComponents[actionType];

	const deleteSection = (identifier) => {
		setActionSections((prevSections) => {
			const newSections = prevSections.filter(
				(prevSection) => prevSection.identifier !== identifier
			);

			return newSections;
		});
	};

	const handleClickNew = (prev) => [
		...prev,
		{
			identifier: `${Date.now()}-${prev.length}`,
		},
	];

	return (
		<SidebarPanel panelTitle={Liferay.Language.get('action')}>
			<SelectActionType
				reassignments={reassignments}
				setActionSections={setActionSections}
			/>

			<ActionSectionComponent
				actionSectionsIndex={actionSectionsIndex}
				actionType={actionType}
				identifier={identifier}
				key={`section-${identifier}`}
				sectionsLength={sectionsLength}
				setActionSections={setActionSections}
				setErrors={setErrors}
				timersIndex={timersIndex}
			/>
			
			<div className="autofit-float autofit-padded-no-gutters-x autofit-row autofit-row-center mb-3">
				<div className="autofit-col">
					<ClayButton
						className="mr-3"
						displayType="secondary"
						onClick={() =>
							setActionSections((prev) => handleClickNew(prev))
						}
					>
						{Liferay.Language.get('new-action')}
					</ClayButton>
				</div>

				<div className="autofit-col autofit-col-end">
					{sectionsLength > 1 && (
						<ClayButtonWithIcon
							className="delete-button"
							displayType="unstyled"
							onClick={() => deleteSection(identifier)}
							symbol="trash"
						/>
					)}
				</div>
			</div>
		</SidebarPanel>
	);
};

TimerAction.propTypes = {
	actionSectionsIndex: PropTypes.number.isRequired,
	identifier: PropTypes.string.isRequired,
	sectionsLength: PropTypes.number.isRequired,
	setActionSections: PropTypes.func.isRequired,
	timersIndex: PropTypes.number.isRequired,
};

export default TimerAction;
