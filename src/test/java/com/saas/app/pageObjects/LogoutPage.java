package com.saas.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BaseClass {

	// Initializing the page object
	public LogoutPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	// Page factory object repository
	@FindBy(xpath = "//*[@class='ui basic button floating item dropdown']")
	@CacheLookup
	WebElement iconSettings;
	
	@FindBy(xpath = "//*[@class='power icon']")
	@CacheLookup
	WebElement iconLogout;

	// Actions	
	public void logout() {
		iconSettings.click();
		iconLogout.click();
	}	
	
}
