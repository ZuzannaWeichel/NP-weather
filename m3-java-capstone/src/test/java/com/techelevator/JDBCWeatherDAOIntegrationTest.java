package com.techelevator;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.jdbc.JDBCParkDAO;
import com.techelevator.npgeek.jdbc.JDBCWeatherDAO;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;

public class JDBCWeatherDAOIntegrationTest extends DAOIntegrationTest{

	
private JDBCWeatherDAO weatherDao;
	
	private JdbcTemplate jdbcTemplate;
	
	@Before
	public void setup() {
		weatherDao = new JDBCWeatherDAO(getDataSource());
		jdbcTemplate = new JdbcTemplate(getDataSource());
		
	}
	
	@Test
	public void get_weather_by_parkcode_test() {
		
		List<Weather> weather = weatherDao.getWeatherByParkCode("CVNP");
		
		Assert.assertEquals(5, weather.size());
		
	}
}
