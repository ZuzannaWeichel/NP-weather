package com.techelevator.fbn.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class PageObject {

	protected WebDriver webDriver;
	
	private String url;

	public PageObject(WebDriver webDriver, String url) {
		this.webDriver = webDriver;
		this.url = url;
		
	}
	
	protected void enterFieldValue(String fieldId, String value) {
		WebElement field = webDriver.findElement(By.id(fieldId));
		field.sendKeys(value);
	}
	
	protected void chooseOptionFromSelect(String fieldId, String optionText) {
		Select selectField = new Select(webDriver.findElement(By.id(fieldId)));
		selectField.selectByVisibleText(optionText);
	}
	
	protected void visit() {
		webDriver.navigate().to("http://localhost:8080/m3-java-capstone/"+ url);
	}
}
