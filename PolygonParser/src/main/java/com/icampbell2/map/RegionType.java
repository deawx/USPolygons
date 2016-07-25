package com.icampbell2.map;

import java.util.Arrays;
import java.util.List;

import com.icampbell2.util.StringHandler;

/**
 * 
 * @author icampbell2
 */
public enum RegionType {
	
	/**
	 * 
	 */
	NORTHEAST(
		DivisionType.NEW_ENGLAND,
		DivisionType.MIDDLE_ATLANTIC
	),

	/**
	 * 
	 */
	MIDWEST(
		DivisionType.EAST_NORTH_CENTRAL,
		DivisionType.WEST_NORTH_CENTRAL
	),

	/**
	 * 
	 */
	SOUTH(
		DivisionType.SOUTH_ATLANTIC,
		DivisionType.EAST_SOUTH_CENTRAL,
		DivisionType.WEST_SOUTH_CENTRAL
	),

	/**
	 * 
	 */
	WEST(
		DivisionType.MOUNTAIN,
		DivisionType.PACIFIC
	);
	
	/**
	 * 
	 */
	private final String name;
	
	/**
	 * 
	 */
	private final List<DivisionType> divisionTypes;
	
	/**
	 * 
	 * @param divisionTypes
	 */
	RegionType(DivisionType... divisionTypes) {
		this.name = StringHandler.getAsTitle(this);
		this.divisionTypes = Arrays.asList(divisionTypes);
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
	public List<DivisionType> getDivisionTypes() {
		return divisionTypes;
	}
}
