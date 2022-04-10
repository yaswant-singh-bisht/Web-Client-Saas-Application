package com.saas.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	// Initializing the page object
		public ContactsPage(WebDriver driver){
			PageFactory.initElements(driver, this);
		}

		// Create Contacts button
		@FindBy(xpath = "//button[normalize-space()='Create']")
		@CacheLookup
		WebElement btnCreateContacts;
		
		// Create Contacts - First Name
		@FindBy(xpath = "//input[@name='first_name']")
		@CacheLookup
		WebElement txtFirstName;

		// Create Contacts - Last Name
		@FindBy(xpath = "//input[@name='last_name']")
		@CacheLookup
		WebElement txtLastName;
		
		// Create Contacts - Save button
		@FindBy(xpath = "//i[@class='save icon']")
		@CacheLookup
		WebElement btnSave;
		
		// Create Contacts - New contact record header
		@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
		@CacheLookup
		WebElement lblNewContactName;
		
		// Actions	
		public void clickCreateContacts() {
			btnCreateContacts.click();
		}
				
		public void setFirstName(String firstName) {
			txtFirstName.sendKeys(firstName);
		}
		
		public void setLastName(String lastName) {
			txtLastName.sendKeys(lastName);
		}
		
		public void clickSave() {
			btnSave.click();
		}
		
		public void newtest() {
			String name = lblNewContactName.getText();
			System.out.println("Name is - " + name);
		}
		
}
