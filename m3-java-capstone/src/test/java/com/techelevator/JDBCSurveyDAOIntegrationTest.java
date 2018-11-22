package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.jdbc.JDBCSurveyDAO;
import com.techelevator.npgeek.model.Survey;

public class JDBCSurveyDAOIntegrationTest extends DAOIntegrationTest {
 
	
private JDBCSurveyDAO surveyDao;
	
	private JdbcTemplate jdbcTemplate;
	private Survey survey;
	
	@Before
	public void setup() {
		surveyDao = new JDBCSurveyDAO(getDataSource());
		jdbcTemplate = new JdbcTemplate(getDataSource());
		survey = new Survey();
		survey.setParkCode("ABC");	
		survey.setEmailAddress("AB@JE@DE");
		survey.setState("OH");
		survey.setActivityLevel("good");
		 
	}
	
	@Test
	public void save_survey_test() {
		
		Map<String, Integer> surveysTest;
		int sizeBefore = surveyDao.getAllSurveys().size();
		surveyDao.saveSurvey(survey);
		surveysTest = surveyDao.getAllSurveys();
		
		Assert.assertEquals(sizeBefore + 1 ,surveysTest.size());
		
	}
	
	@Test
	public void get_all_surveys_test() {
		
		surveyDao.saveSurvey(survey);
		int surveysTestSize = surveyDao.getAllSurveys().size();
		
		Assert.assertTrue(surveysTestSize > 0);
	}
	
}
