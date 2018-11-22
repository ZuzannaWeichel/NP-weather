package com.techelevator.fbn.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SurveyPageObject {

	private WebDriver webDriver;

	public SurveyPageObject(WebDriver webDriver) {
		this.webDriver = webDriver;	
	}
	
	
	public SurveyPageObject selectFavPark(String parkCode) {
		Select selector = new Select(webDriver.findElement(By.name("parkCode")));
		selector.selectByVisibleText(parkCode);
		return this;
	}
	
	public SurveyPageObject enterEmailAddress(String emailAddress) {
		WebElement emailField = webDriver.findElement(By.name("emailAddress"));
		emailField.sendKeys(emailAddress);
		return this;
	}
	
	public SurveyPageObject selectState(String state) {
		Select selector = new Select(webDriver.findElement(By.name("state")));
		selector.selectByVisibleText(state);
		return this;
	}
	
	public SurveyPageObject selectActivityLevel(String activityLevel) {
		Select selector = new Select(webDriver.findElement(By.name("activityLevel")));
		selector.selectByVisibleText(activityLevel);
		return this;
	}
	
	public FavParksPageObject submitForm() {
		WebElement submitButton = webDriver.findElement(By.className("btn-primary"));
		submitButton.click();
		return new FavParksPageObject(webDriver);
	}
}
