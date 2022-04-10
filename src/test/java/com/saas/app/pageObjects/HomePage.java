package com.saas.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

	// Initializing the page object
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	// Page factory object repository
	@FindBy(xpath = "//*[@class='user-display']")
	@CacheLookup
	WebElement lblUserFullName;

	// Left Navigation bar
	@FindBy(xpath = "//*[@class='ui left fixed vertical  icon menu sidebar-dark left-to-right']")
	@CacheLookup
	WebElement leftNavigationBar;
	
	// Contacts task item
	@FindBy(xpath = "//span[normalize-space()='Contacts']")
	@CacheLookup
	WebElement taskContacts;
		
	// Actions	
	public boolean userNameExists() {
		boolean present = false;
		if (lblUserFullName.isDisplayed()) {
			return true;	
		}
		return present;
	}
	
	public void clickLeftNav() {
		leftNavigationBar.click();
	}
	
	public void clickTaskContacts() {
		taskContacts.click();
	}
	
	
}
