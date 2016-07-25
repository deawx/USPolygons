package com.icampbell2.util;

/**
 * 
 * @author icampbell2
 */
public final class StringHandler {

	/**
	 * 
	 */
	private StringHandler() {
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static String getWithFirstCharUppercase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static String getWithFirstCharLowercase(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	private static String getAsTitle(String name) {
		StringBuilder sb = new StringBuilder();
		for (String token : name.toLowerCase().split("_")) {
			token = getWithFirstCharUppercase(token);
			
			sb.append(token)
				.append(" ");
		}
		
		return sb.toString()
				.trim();
	}
	
	/**
	 * 
	 * @param enumeration
	 * @return
	 */
	public static String getAsTitle(@SuppressWarnings("rawtypes") Enum enumeration) {
		return getAsTitle(enumeration.name());
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static String getAsFilename(String name) {
		StringBuilder sb = new StringBuilder();
		String[] tokens = getAsTitle(name).split(" ");
		
		for (int i = 0, len = tokens.length; i < len; i++) {
			String token = tokens[i];
			
			if (i == 0) {
				token = getWithFirstCharLowercase(token);
				
			} else if (!token.equals(" ")) {
				token = getWithFirstCharUppercase(token);
			}
			
			sb.append(token);
		}
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static String getAsJSONFilename(String name) {
		return getAsFilename(name) + ".json";
	}
}
