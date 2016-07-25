package com.icampbell2.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONObject;

import com.icampbell2.map.Division;
import com.icampbell2.map.Region;
import com.icampbell2.map.State;
import com.icampbell2.util.StringHandler;

/**
 * 
 * @author icampbell2
 */
public final class JSONFileWriter {
	
	/**
	 * 
	 */
	private String currentDirectory;
	
	/**
	 * 
	 */
	private static final String RESOURCES_PATH = "src\\main\\resources";
	
	/**
	 * 
	 * @param rootpath
	 */
	public JSONFileWriter(String rootpath) {
		currentDirectory = rootpath;
		
		File file = new File(rootpath),
				parentFile = file.getParentFile();
		
		if (!parentFile.exists()) {
			parentFile.mkdirs();
		}
	}
	
	/**
	 * 
	 */
	public JSONFileWriter() {
		this(RESOURCES_PATH);
	}
	
	/**
	 * 
	 * @param dirPath
	 */
	private void mkdir(String dirPath) {
		File directory = new File(dirPath);
		
		if (!directory.exists()) {
			directory.mkdir();
		}
	}
	
	/**
	 * 
	 * @param json
	 * @param filepath
	 * @throws IOException
	 */
	private void write(JSONObject json, String filepath) throws IOException {
		File file = new File(filepath);
		
		if (!file.exists()) {
			try (FileWriter fileWriter = new FileWriter(file)) {
				fileWriter.write(json.toString());
			}
		}
	}
	
	/**
	 * 
	 * @param state
	 * @throws IOException
	 */
	public void write(State state) throws IOException {
		String filepath = Paths.get(currentDirectory,
				StringHandler.getAsJSONFilename(state.getName()))
				.toString();
		
		write(JSONHandler.getJSONFor(state), filepath);
	}
	
	/**
	 * 
	 * @param mapObjects
	 * @throws IOException
	 */
	public <T extends Object> void write(List<T> mapObjects) throws IOException {
		T mapObject = mapObjects.get(0);
		
		if (mapObject instanceof Region) {
			String regionsPath = currentDirectory;
			
			for (T obj : mapObjects) {
				Region region = (Region) obj;
				
				currentDirectory = Paths.get(regionsPath,
						StringHandler.getAsFilename(region.getName()))
						.toString();
				mkdir(currentDirectory);
				
				write(region);
			}
		} else if (mapObject instanceof Division) {
			String divisionsPath = currentDirectory;
			
			for (T obj : mapObjects) {
				Division division = (Division) obj;
				
				currentDirectory = Paths.get(divisionsPath,
						StringHandler.getAsFilename(division.getName()))
						.toString();
				mkdir(currentDirectory);
				
				write(division);
			}
		} else if (mapObject instanceof State) {
			for (T obj : mapObjects) {
				write((State) obj);
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * 
	 * @param division
	 * @throws IOException
	 */
	public void write(Division division) throws IOException {
		write(division.getStates());
	}
	
	/**
	 * 
	 * @param region
	 * @throws IOException
	 */
	public void write(Region region) throws IOException {
		write(region.getDivisions());
	}
}
