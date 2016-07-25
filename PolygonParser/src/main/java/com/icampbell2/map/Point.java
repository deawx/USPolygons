package com.icampbell2.map;

/**
 * 
 * @author icampbell2
 */
public final class Point {
	
	/**
	 * 
	 */
	private final double longitude;
	
	/**
	 * 
	 */
	private final double latitude;
	
	/**
	 * 
	 * @param longitude
	 * @param latitude
	 */
	public Point(double longitude, double latitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getLongitude() {
		return this.longitude;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getLatitude() {
		return this.latitude;
	}
}
