package com.icampbell2.xml;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.icampbell2.map.Point;
import com.icampbell2.map.State;
import com.icampbell2.map.StateType;

/**
 * 
 * @author icampbell2
 */
final class XMLHandler extends DefaultHandler {
	
	/**
	 * 
	 */
	private State currentState;
	
	/**
	 * 
	 */
	private final Map<StateType, State> stateMap;

	/**
	 * 
	 */
	private static final String STATE = "state";

	/**
	 * 
	 */
	private static final String STATE_NAME = "name";

	/**
	 * 
	 */
	private static final String STATE_COLOR = "colour";

	/**
	 * 
	 */
	private static final String POINT = "point";

	/**
	 * 
	 */
	private static final String POINT_LAT = "lat";

	/**
	 * 
	 */
	private static final String POINT_LNG = "lng";
	
	/**
	 * 
	 */
	XMLHandler() {
		stateMap = new HashMap<>();
	}
	
	/**
	 * 
	 * @param uri
	 * @param localName
	 * @param qName
	 * @param attributes
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		localName = localName.toLowerCase();
		
		if (localName.equals(STATE)) {
			String stateName = attributes.getValue(STATE_NAME);
			currentState = new State(stateName, attributes.getValue(STATE_COLOR));
			stateMap.put(StateType.get(stateName), currentState);
			
		} else if (localName.equals(POINT)) {
			currentState.add(new Point(Double.valueOf(attributes.getValue(POINT_LNG)),
					Double.valueOf(attributes.getValue(POINT_LAT))));
		}
	}
	
	/**
	 * 
	 * @return
	 */
	Map<StateType, State> getStateMap() {
		return stateMap;
	}
}
