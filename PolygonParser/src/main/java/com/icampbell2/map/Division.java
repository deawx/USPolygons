package com.icampbell2.map;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author icampbell2
 */
public final class Division {
	
	/**
	 * 
	 */
	private final String name;

	/**
	 * 
	 */
	private List<State> states;
	
	/**
	 * 
	 * @param divisionType
	 */
	public Division(DivisionType divisionType) {
		if (divisionType == null) {
			throw new IllegalArgumentException();
		}
		
		this.name = divisionType.getName();
		states = new ArrayList<>();
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
	public List<State> getStates() {
		return states;
	}
	
	/**
	 * 
	 * @param state
	 */
	public void add(State state) {
		states.add(state);
	}
}
