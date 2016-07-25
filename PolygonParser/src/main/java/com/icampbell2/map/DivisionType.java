package com.icampbell2.map;

import java.util.Arrays;
import java.util.List;

import com.icampbell2.util.StringHandler;

/**
 * 
 * @author icampbell2
 */
public enum DivisionType {

	/**
	 * 
	 */
	EAST_NORTH_CENTRAL(
		StateType.ILLINOIS,
		StateType.INDIANA,
		StateType.MICHIGAN,
		StateType.OHIO,
		StateType.WISCONSIN
	),

	/**
	 * 
	 */
	EAST_SOUTH_CENTRAL(
		StateType.ALABAMA,
		StateType.KENTUCKY,
		StateType.MISSISSIPPI,
		StateType.TENNESSEE
	),

	/**
	 * 
	 */
	MIDDLE_ATLANTIC(
		StateType.NEW_JERSEY,
		StateType.NEW_YORK,
		StateType.PENNSYLVANIA
	),

	/**
	 * 
	 */
	MOUNTAIN(
		StateType.ARIZONA,
		StateType.COLORADO,
		StateType.IDAHO,
		StateType.MONTANA,
		StateType.NEVADA,
		StateType.NEW_MEXICO,
		StateType.UTAH,
		StateType.WYOMING
	),
	
	/**
	 * 
	 */
	NEW_ENGLAND(
		StateType.CONNECTICUT,
		StateType.MAINE,
		StateType.MASSACHUSETTS,
		StateType.NEW_HAMPSHIRE,
		StateType.RHODE_ISLAND,
		StateType.VERMONT
	),

	/**
	 * 
	 */
	PACIFIC(
		StateType.ALASKA,
		StateType.CALIFORNIA,
		StateType.HAWAII,
		StateType.OREGON,
		StateType.WASHINGTON
	),

	/**
	 * 
	 */
	SOUTH_ATLANTIC(
		StateType.DELAWARE,
//		StateType.DISTRICT_OF_COLUMBIA,
		StateType.FLORIDA,
		StateType.GEORGIA,
		StateType.MARYLAND,
		StateType.NORTH_CAROLINA,
		StateType.SOUTH_CAROLINA,
		StateType.VIRGINIA,
		StateType.WEST_VIRGINIA
	),

	/**
	 * 
	 */
	WEST_NORTH_CENTRAL(
		StateType.IOWA,
		StateType.KANSAS,
		StateType.MINNESOTA,
		StateType.NEBRASKA,
		StateType.NORTH_DAKOTA,
		StateType.SOUTH_DAKOTA
	),

	/**
	 * 
	 */
	WEST_SOUTH_CENTRAL(
		StateType.ARKANSAS,
		StateType.LOUISIANA,
		StateType.OKLAHOMA,
		StateType.TEXAS
	);
	
	/**
	 * 
	 */
	private final String name;
	
	/**
	 * 
	 */
	private final List<StateType> stateTypes;
	
	/**
	 * 
	 * @param name
	 * @param stateTypes
	 */
	DivisionType(StateType... stateTypes) {
		name = StringHandler.getAsTitle(this);
		this.stateTypes = Arrays.asList(stateTypes);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<StateType> getStateTypes() {
		return stateTypes;
	}
}
