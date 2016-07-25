package com.icampbell2;

import com.icampbell2.json.JSONFileWriter;
import com.icampbell2.xml.XMLFile;

/**
 * 
 * @author icampbell2
 */
public final class Main {
	
	/**
	 * 
	 */
	private Main() {
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new JSONFileWriter()
					.write(new XMLFile()
					.getRegions());
//			new JSONFileWriter()
//					.write(new XMLFile("http://econym.org.uk/gmap/states.xml")
//					.getRegions());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
