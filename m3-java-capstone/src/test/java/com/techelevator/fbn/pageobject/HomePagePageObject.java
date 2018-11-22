package com.techelevator.fbn.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePagePageObject extends PageObject {

	public HomePagePageObject(WebDriver webDriver) {
		super(webDriver, "");
	}
	
	public List<WebElement> getAllParkImages() {
		List<WebElement>parkDetailList = webDriver.findElements(By.cssSelector(".parkimages"));
		return parkDetailList;
	}
	
	public WebElement getLogoImage() {
		WebElement logo = webDriver.findElement(By.cssSelector("header img"));
		
		return logo;
	}
	
	public String returnUrl() {
		String url = webDriver.getCurrentUrl();
		
		return url;
	}
	
	public WebElement getParkImageLink() {
		WebElement parkImageLink = webDriver.findElement(By.cssSelector("a[href$='parkDetail?parkCode=CVNP']"));
		
		return parkImageLink;
	}
	
	public WebElement getSurveyButton() {
		WebElement surveyButton = webDriver.findElement(By.linkText("Survey"));
		
		return surveyButton;
	}
	
	public WebElement getFavParksButton() {
		WebElement favParksButton = webDriver.findElement(By.linkText("Favorite Parks"));
		
		return favParksButton;
	}
	
	public SurveyPageObject clickSurveyLink() {
		WebElement surveyLink = webDriver.findElement(By.linkText("Survey"));
		surveyLink.click();
		return new SurveyPageObject(webDriver);
	}
}
