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

import com.techelevator.fbn.pageobject.HomePagePageObject;
import com.techelevator.npgeek.jdbc.JDBCParkDAO;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDAO;

import org.junit.Assert;

public class HomePageSeleniumTest {

	private static WebDriver webDriver;
	private HomePagePageObject homePage;
	private static JDBCParkDAO parkDAO;
	private static SingleConnectionDataSource dataSource;

	@BeforeClass
	public static void openWebBrowserForTesting() {

		String homeDir = System.getProperty("user.home");
		System.setProperty("webdriver.chrome.driver", homeDir + "/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
		parkDAO = new JDBCParkDAO(dataSource);
	}

	@Before
	public void openHomePage() throws InterruptedException {
		webDriver.get("http://localhost:8080/m3-java-capstone/");
		homePage = new HomePagePageObject(webDriver);

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
	public void test_are_the_parks_displaying() throws InterruptedException {
		List<WebElement> parkImagesList = homePage.getAllParkImages();
		List<Park> parks = parkDAO.getAllParks();

		Assert.assertEquals(parkImagesList.size(), parks.size());
		Thread.sleep(1000);
	}

	@Test
	public void test_logo_selected() throws InterruptedException {
		WebElement logo = homePage.getLogoImage();

		Assert.assertTrue(logo.isDisplayed());
		Thread.sleep(1000);
	}

	@Test
	public void test_click_logo_takes_to_homepage() throws InterruptedException {
		WebElement logo = homePage.getLogoImage();
		logo.click();
		Assert.assertEquals("http://localhost:8080/m3-java-capstone/", homePage.returnUrl());
		Thread.sleep(1000);
	}

	@Test
	public void test_click_parkimage_goes_to_park_detail() throws InterruptedException {
		WebElement parkImage = homePage.getParkImageLink();
		parkImage.click();
		Assert.assertEquals("http://localhost:8080/m3-java-capstone/parkDetail?parkCode=CVNP",
				webDriver.getCurrentUrl());
		Thread.sleep(1000);

	}

	@Test
	public void test_click_navbar_survey_button() throws InterruptedException {
		WebElement surveyButton = homePage.getSurveyButton();
		surveyButton.click();
		Assert.assertEquals("http://localhost:8080/m3-java-capstone/survey", webDriver.getCurrentUrl());
		Thread.sleep(1000);

	}

	@Test
	public void test_click_favparks_button() throws InterruptedException {
		WebElement favParksButton = homePage.getFavParksButton();
		favParksButton.click();
		Assert.assertEquals("http://localhost:8080/m3-java-capstone/favParks", webDriver.getCurrentUrl());
		Thread.sleep(1000);

	}

}
