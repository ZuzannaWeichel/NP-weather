package com.techelevator.npgeek.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Weather;
import com.techelevator.npgeek.model.WeatherDAO;

@Component
public class JDBCWeatherDAO implements WeatherDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	

	@Override
	public List<Weather> getWeatherByParkCode(String parkCode) {
		List<Weather> weatherList = new ArrayList<Weather>();
		
		String sql = "SELECT * FROM weather WHERE parkcode = ?";
		
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, parkCode);
		
		while(result.next()) {
			weatherList.add(mapRowToWeather(result));
		}
		
		return weatherList;
	}



	private Weather mapRowToWeather(SqlRowSet result) {
			Weather weather = new Weather();
			
			weather.setParkCode(result.getString("parkcode"));
			weather.setFiveDayForeCastValue(result.getInt("fivedayforecastvalue"));
			weather.setLow(result.getInt("low"));
			weather.setHigh(result.getInt("high"));
			weather.setForecast(result.getString("forecast"));
		return weather;
	}

}
