package com.techelevator.npgeek.model;

import java.util.List;
import java.util.Map;

public interface ParkDAO {

	
	public List<Park> getAllParks();
	
	public Park getParkByParkCode(String parkCode);
	
	public List<Park> getFavParks(Map<String,Integer> favParks );
	
	
}
