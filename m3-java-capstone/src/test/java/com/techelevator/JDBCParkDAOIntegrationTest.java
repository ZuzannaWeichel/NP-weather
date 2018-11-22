package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.jdbc.JDBCParkDAO;
import com.techelevator.npgeek.model.Park;

import org.junit.Assert;

public class JDBCParkDAOIntegrationTest extends DAOIntegrationTest {

	
	private JDBCParkDAO parkDao;	
	private JdbcTemplate jdbcTemplate;
	
	@Before
	public void setup() {
		parkDao = new JDBCParkDAO(getDataSource());
		jdbcTemplate = new JdbcTemplate(getDataSource());
		 
	}
	
	@Test
	public void get_all_parks_test() {
		List<Park> parksTest = new ArrayList<Park>();
		
		parksTest = parkDao.getAllParks();
		int parksTestSize = parksTest.size();
		parksTest.add(new Park() );
		int parksTestAfter = parksTest.size() - 1 ;
		
		Assert.assertEquals(parksTestSize, parksTestAfter);
	}
	
	@Test
	public void get_park_by_parkcode_test() {
		
		Park park = parkDao.getParkByParkCode("CVNP");
		Assert.assertEquals("Ohio", park.getState());		
	}
	
	@Test
	public void get_fav_parks_test() {
		Map<String, Integer> parkVotesMap = new HashMap<String, Integer>();
		parkVotesMap.put("ENP", 3);
		parkVotesMap.put("CVNP", 2);
		parkVotesMap.put("GNP", 1);
		List<Park> parks = parkDao.getFavParks(parkVotesMap);
		Assert.assertEquals(3, parks.size());
	}
}
