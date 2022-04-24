package com.saas.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saas.app.utils.Utilities;

public class LoginPage extends BaseClass {
	
	// Initializing the page object
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	// Page factory object repository
	@FindBy(xpath = "//*[@name='email']")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath = "//*[@name='password']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath = "//*[@class='ui fluid large blue submit button']")
	@CacheLookup
	WebElement btnLogin;

	// Actions	
	public void login() {
		txtEmail.sendKeys(Utilities.Config_Properties.getProperty("username"));
		txtPassword.sendKeys(Utilities.decryptPassword(Utilities.Config_Properties.getProperty("password")));
		btnLogin.click();
	}
	
	public boolean isEmailExists() {
		boolean present = false;
		if (txtEmail.isDisplayed()) {
			return true;	
		}
		return present;
	}
}
