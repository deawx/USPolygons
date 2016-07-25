package com.icampbell2.map;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.icampbell2.util.StringHandler;

/**
 * 
 * @author icampbell2
 */
public enum StateType {

	/**
	 * 
	 */
	ALABAMA(),

	/**
	 * 
	 */
	ALASKA(),

	/**
	 * 
	 */
	ARIZONA(),

	/**
	 * 
	 */
	ARKANSAS(),

	/**
	 * 
	 */
	CALIFORNIA(),

	/**
	 * 
	 */
	COLORADO(),

	/**
	 * 
	 */
	CONNECTICUT(),

	/**
	 * 
	 */
	DELAWARE(),

	/**
	 * 
	 */
	DISTRICT_OF_COLUMBIA(),

	/**
	 * 
	 */
	FLORIDA(),

	/**
	 * 
	 */
	GEORGIA(),

	/**
	 * 
	 */
	HAWAII(),

	/**
	 * 
	 */
	IDAHO(),

	/**
	 * 
	 */
	ILLINOIS(),

	/**
	 * 
	 */
	INDIANA(),

	/**
	 * 
	 */
	IOWA(),

	/**
	 * 
	 */
	KANSAS(),

	/**
	 * 
	 */
	KENTUCKY(),

	/**
	 * 
	 */
	LOUISIANA(),

	/**
	 * 
	 */
	MAINE(),

	/**
	 * 
	 */
	MARYLAND(),

	/**
	 * 
	 */
	MASSACHUSETTS(),

	/**
	 * 
	 */
	MICHIGAN(),

	/**
	 * 
	 */
	MINNESOTA(),

	/**
	 * 
	 */
	MISSISSIPPI(),

	/**
	 * 
	 */
	MONTANA(),

	/**
	 * 
	 */
	NEBRASKA(),

	/**
	 * 
	 */
	NEVADA(),

	/**
	 * 
	 */
	NEW_HAMPSHIRE(),

	/**
	 * 
	 */
	NEW_JERSEY(),

	/**
	 * 
	 */
	NEW_MEXICO(),

	/**
	 * 
	 */
	NEW_YORK(),

	/**
	 * 
	 */
	NORTH_CAROLINA(),

	/**
	 * 
	 */
	NORTH_DAKOTA(),

	/**
	 * 
	 */
	OHIO(),

	/**
	 * 
	 */
	OKLAHOMA(),

	/**
	 * 
	 */
	OREGON(),

	/**
	 * 
	 */
	PENNSYLVANIA(),

	/**
	 * 
	 */
	RHODE_ISLAND(),

	/**
	 * 
	 */
	SOUTH_CAROLINA(),

	/**
	 * 
	 */
	SOUTH_DAKOTA(),

	/**
	 * 
	 */
	TENNESSEE(),

	/**
	 * 
	 */
	TEXAS(),

	/**
	 * 
	 */
	UTAH(),

	/**
	 * 
	 */
	VERMONT(),

	/**
	 * 
	 */
	VIRGINIA(),

	/**
	 * 
	 */
	WASHINGTON(),

	/**
	 * 
	 */
	WEST_VIRGINIA(),

	/**
	 * 
	 */
	WISCONSIN(),

	/**
	 * 
	 */
	WYOMING();
	
	/**
	 * 
	 */
	private final String name;
	
	/**
	 * 
	 */
	private static Map<String, StateType> STATE_TYPE_MAP;
	
	/**
	 * 
	 */
	StateType() {
		name = StringHandler.getAsTitle(this);
	}
	
	/**
	 * 
	 */
	static {
		STATE_TYPE_MAP = new HashMap<>();
		for (StateType stateType : EnumSet.allOf(StateType.class)) {
			STATE_TYPE_MAP.put(stateType.getName(), stateType);
		}
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
	 * @param name
	 * @return
	 */
	public static StateType get(String name) {
		return STATE_TYPE_MAP.get(name);
	}
}
