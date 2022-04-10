package com.saas.app.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	
	// Initializing the page object
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	// Page factory object repository
	@FindBy(xpath = "//*[@name='email']")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(xpath = "//*[@name='password']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath = "//*[@class='ui fluid large blue submit button']")
	@CacheLookup
	WebElement btnLogin;

	// Actions	
	public void setUserName(String userName) {
		txtUserName.sendKeys(userName);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
}
