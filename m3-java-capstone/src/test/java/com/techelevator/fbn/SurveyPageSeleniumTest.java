package com.techelevator.fbn;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.fbn.pageobject.FavParksPageObject;
import com.techelevator.fbn.pageobject.HomePagePageObject;
import com.techelevator.fbn.pageobject.SurveyPageObject;
import com.techelevator.npgeek.jdbc.JDBCParkDAO;
import com.techelevator.npgeek.jdbc.JDBCSurveyDAO;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDAO;

import org.junit.Assert;

public class SurveyPageSeleniumTest {

	
	private static WebDriver webDriver;
	private SurveyPageObject surveyPage;
	private static JDBCSurveyDAO surveyDAO;
	private static SingleConnectionDataSource dataSource;


	@BeforeClass
	public static void openWebBrowserForTesting() {
		
		String homeDir = System.getProperty("user.home");
		System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
		
	}
	
	@Before
	public void openSurveyPage() {
		webDriver.get("http://localhost:8080/m3-java-capstone/survey");
		surveyPage = new SurveyPageObject(webDriver);
		 
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver.close();
		dataSource.destroy();

	}
	
	@Test
	public void test_enter_survey() throws InterruptedException {
		FavParksPageObject resultPage = surveyPage.selectFavPark("Cuyahoga Valley National Park")
												   .enterEmailAddress("parksAreMyLifeForever66@gmail.com")
												   .selectState("Ohio")
												   .selectActivityLevel("Active")
												   .submitForm();
		Thread.sleep(1500);
		Assert.assertEquals(true ,resultPage.isParkNameMatch("Cuyahoga Valley National Park"));
	}
}