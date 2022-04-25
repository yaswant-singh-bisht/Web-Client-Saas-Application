package com.saas.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends BaseClass {
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
		
		public void createNewContact(String firstName, String lastName) {
			HomePage hp = new HomePage(driver);
			hp.clickLeftNav();
			hp.clickTaskContacts();
			
			btnCreateContacts.click();
			txtFirstName.clear();
			txtFirstName.sendKeys(firstName);
			txtLastName.clear();
			txtLastName.sendKeys(lastName);
			
			btnSave.click();

		}
		
		public String isContactCreated() {
			String name = lblNewContactName.getText();
			return name;
		}
		
		
		
		
		
}
