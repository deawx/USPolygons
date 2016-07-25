package com.icampbell2.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.icampbell2.map.Division;
import com.icampbell2.map.Point;
import com.icampbell2.map.Region;
import com.icampbell2.map.State;

/**
 * 
 * @author icampbell2
 */
final class JSONHandler {
	
	/**
	 * 
	 */
	private JSONHandler() {
	}
	
	/**
	 * 
	 * @param jsonObject
	 * @return
	 */
	static Map<String, Object> getAsMap(JSONObject jsonObject) {
		Map<String, Object> map = new HashMap<>();
		Iterator<String> keys = jsonObject.keys();
		
		while (keys.hasNext()) {
			String key = keys.next();
			Object value = jsonObject.get(key);
			
			if (value instanceof JSONArray) {
				value = getAsList((JSONArray) value);
				
			} else if (value instanceof JSONObject) {
				value = getAsMap((JSONObject) value);
			}
			
			map.put(key, value);
		}
		
		return map;
	}
	
	/**
	 * 
	 * @param jsonArray
	 * @return
	 */
	static List<Object> getAsList(JSONArray jsonArray) {
		List<Object> list = new ArrayList<>();
		
		for (int i = 0, len = jsonArray.length(); i < len; i++) {
			Object value = jsonArray.get(i);
			
			if (value instanceof JSONArray) {
				value = getAsList((JSONArray) jsonArray);
				
			} else if (value instanceof JSONObject) {
				value = getAsMap((JSONObject) value);
			}
			
			list.add(value);
		}
		
		return list;
	}
	
	/**
	 * 
	 * @param point
	 * @return
	 */
	static JSONObject getJSONFor(Point point) {
		JSONObject json = new JSONObject();
		json.put("lat", String.valueOf(point.getLatitude()));
		json.put("lng", String.valueOf(point.getLongitude()));
		
		return json;
	}
	
	/**
	 * 
	 * @param state
	 * @return
	 */
	static JSONObject getJSONFor(State state) {
		JSONArray pointsArray = new JSONArray();
		for (Point point : state.getPoints()) {
			pointsArray.put(getJSONFor(point));
		}
		JSONObject json = new JSONObject(),
				jsonObject = new JSONObject();
		
		jsonObject.put("name", state.getName());
		jsonObject.put("color", state.getColor());
		jsonObject.put("points", pointsArray);
		json.put("state", jsonObject);
		
		return json;
	}
	
	/**
	 * 
	 * @param division
	 * @return
	 */
	static JSONObject getJSONFor(Division division) {
		JSONObject json = new JSONObject();
		JSONArray statesArray = new JSONArray();
		
		for (State state : division.getStates()) {
			statesArray.put(getJSONFor(state));
		}
		
		json.put(division.getName(), statesArray);
		return json;
	}
	
	/**
	 * 
	 * @param region
	 * @return
	 */
	static JSONObject getJSONFor(Region region) {
		JSONObject json = new JSONObject();
		JSONArray divisionArray = new JSONArray();
		
		for (Division division : region.getDivisions()) {
			divisionArray.put(getJSONFor(division));
		}
		
		json.put(region.getName(), divisionArray);
		return json;
	}
}
