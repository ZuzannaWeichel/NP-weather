package com.techelevator.npgeek.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDAO;

@Component
public class JDBCParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		
		List<Park> parks = new ArrayList<Park>();
		String sql = "SELECT * FROM park";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
		while (result.next()) {
			parks.add(mapRowToPark(result));
		} 
		return parks;
	}

	@Override
	public Park getParkByParkCode(String parkCode) {
		
		Park park = new Park();		
		String sql = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, parkCode);
		while (result.next()) {
			 park = mapRowToPark(result);
		}
		return park;
	}

	@Override
	public List<Park> getFavParks(Map<String, Integer> favParks) {
		List<Park> parks = new ArrayList<>();
		for( String code : favParks.keySet()) {
			parks.add(getParkByParkCode(code));
		}
		return parks;
	}

	private Park mapRowToPark(SqlRowSet result) {
		Park park = new Park();

		park.setParkCode(result.getString("parkcode"));
		park.setParkName(result.getString("parkname"));
		park.setState(result.getString("state"));
		park.setAcreage(result.getInt("acreage"));
		park.setState(result.getString("state"));
		park.setElevationInFeet(result.getInt("elevationinfeet"));
		park.setMilesOfTrail(result.getDouble("milesoftrail"));
		park.setNumberOfCampsites(result.getInt("numberofcampsites"));
		park.setClimate(result.getString("climate"));
		park.setYearFounded(result.getInt("yearfounded"));
		park.setAnnualVisitorCount(result.getInt("annualvisitorcount"));
		park.setInspirationalQuote(result.getString("inspirationalquote"));
		park.setInspirationalQuoteSource(result.getString("inspirationalquotesource"));
		park.setParkDescription(result.getString("parkdescription"));
		park.setEntryFee(result.getInt("entryfee"));
		park.setNumberOfAnimalSpecies(result.getInt("numberofanimalspecies"));

		return park;

	}

}
