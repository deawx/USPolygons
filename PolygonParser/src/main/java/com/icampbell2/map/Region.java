package com.icampbell2.map;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author icampbell2
 */
public final class Region {
	
	/**
	 * 
	 */
	private final String name;
	
	/**
	 * 
	 */
	private final List<Division> divisions;
	
	/**
	 * 
	 * @param regionType
	 */
	public Region(RegionType regionType) {
		if (regionType == null) {
			throw new IllegalArgumentException();
		}
		
		this.name = regionType.getName();
		this.divisions = new ArrayList<>();
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
	public List<Division> getDivisions() {
		return divisions;
	}
	
	/**
	 * 
	 * @param division
	 */
	public void add(Division division) {
		divisions.add(division);
	}
}
