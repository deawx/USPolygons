package com.icampbell2.xml;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.icampbell2.map.Division;
import com.icampbell2.map.DivisionType;
import com.icampbell2.map.Point;
import com.icampbell2.map.Region;
import com.icampbell2.map.RegionType;
import com.icampbell2.map.State;
import com.icampbell2.map.StateType;

/**
 * 
 * @author icampbell2
 */
public final class XMLFile {
	
	/**
	 * 
	 */
	private final Map<RegionType, Region> regionMap;
	
	/**
	 * 
	 */
	private final Map<DivisionType, Division> divisionMap;
	
	/**
	 * 
	 */
	private final Map<StateType, State> stateMap;
	
	/**
	 * 
	 * @param inputSource
	 * @throws IOException
	 * @throws SAXException
	 */
	private XMLFile(InputSource inputSource) throws IOException, SAXException {
		XMLReader xmlReader = XMLReaderFactory.createXMLReader();
		XMLHandler xmlHandler = new XMLHandler();
		
		xmlReader.setContentHandler(xmlHandler);
		xmlReader.parse(inputSource);
		stateMap = xmlHandler.getStateMap();
		
		regionMap = new HashMap<>();
		divisionMap = new HashMap<>();
		for (RegionType regionType : RegionType.values()) {
			Region region = new Region(regionType);
			regionMap.put(regionType, region);
			
			for (DivisionType divisionType : regionType.getDivisionTypes()) {
				Division division = new Division(divisionType);
				divisionMap.put(divisionType, division);
				region.add(division);
				
				for (StateType stateType : divisionType.getStateTypes()) {
					division.add(stateMap.get(stateType));
				}
			}
		}
	}

	/**
	 * 
	 * @param url
	 * @throws URISyntaxException
	 * @throws SAXException 
	 * @throws IOException 
	 */
	public XMLFile(String url) throws URISyntaxException, SAXException, IOException {
		this(new InputSource(new URL(url).openStream()));
	}
	
	/**
	 * 
	 * @throws SAXException
	 * @throws IOException
	 */
	public XMLFile() throws SAXException, IOException {
		this(new InputSource("src/main/resources/states.xml"));
	}

	/**
	 * 
	 * @param stateType
	 * @return
	 */
	public List<Point> getPoints(StateType stateType) {
		return stateMap.get(stateType).getPoints();
	}
	
	/**
	 * 
	 * @param stateType
	 * @return
	 */
	public State getState(StateType stateType) {
		return stateMap.get(stateType);
	}

	/**
	 * 
	 * @param divisionType
	 * @return
	 */
	public List<State> getStates(DivisionType divisionType) {
		return divisionMap.get(divisionType).getStates();
	}
	
	/**
	 * 
	 * @param divisionType
	 * @return
	 */
	public Division getDivision(DivisionType divisionType) {
		return divisionMap.get(divisionType);
	}

	/**
	 * 
	 * @param regionType
	 * @return
	 */
	public List<State> getStates(RegionType regionType) {
		List<State> states = new ArrayList<>();
		
		for (Division division : regionMap.get(regionType).getDivisions()) {
			states.addAll(division.getStates());
		}
		
		return states;
	}
	
	/**
	 * 
	 * @param regionType
	 * @return
	 */
	public List<Division> getDivisions(RegionType regionType) {
		return regionMap.get(regionType).getDivisions();
	}
	
	/**
	 * 
	 * @param regionType
	 * @return
	 */
	public Region getRegion(RegionType regionType) {
		return regionMap.get(regionType);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Region> getRegions() {
		List<Region> regions = new ArrayList<>();
		
		for (RegionType regionType : RegionType.values()) {
			regions.add(regionMap.get(regionType));
		}
		
		return regions;
	}
}
