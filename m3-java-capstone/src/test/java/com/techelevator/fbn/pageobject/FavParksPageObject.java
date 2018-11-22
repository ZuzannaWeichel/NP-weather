package com.techelevator.fbn.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FavParksPageObject {

	private WebDriver webDriver;

	public FavParksPageObject(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public Boolean isParkNameMatch(String parkName) {
		
//		String park = webDriver.findElement(By.xpath("//table//tr[2]/td[3]")).getText();
		String park = webDriver.findElement(By.xpath("//*[text()='" + parkName + "']")).getText();
		return park.equals(parkName);
		
	}
}
