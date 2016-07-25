package com.icampbell2.map;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author icampbell2
 */
public final class State {
	
	/**
	 * 
	 */
	private final String name;
	
	/**
	 * 
	 */
	private final String color;
	
	/**
	 * 
	 */
	private final List<Point> points;
	
	/**
	 * 
	 * @param name
	 * @param color
	 */
	public State(String name, String color) {
		if (name == null || name.equals("")) {
			throw new IllegalArgumentException();
		}
		
		this.name = name;
		this.color = color;
		points = new ArrayList<>();
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
	public String getColor() {
		return color;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Point> getPoints() {
		return points;
	}
	
	/**
	 * 
	 * @param point
	 */
	public void add(Point point) {
		points.add(point);
	}
}
