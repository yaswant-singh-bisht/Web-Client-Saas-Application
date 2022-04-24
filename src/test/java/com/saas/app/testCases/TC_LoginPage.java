package com.saas.app.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saas.app.pageObjects.BaseClass;
import com.saas.app.pageObjects.HomePage;
import com.saas.app.pageObjects.LoginPage;
import com.saas.app.reports.Report;

public class TC_LoginPage extends BaseClass {
	
	@Test
	public static void valLoginPageTest() {
		Report.startTestReport("TC_LoginPage", "Verify Login page");
		
		LoginPage lp = new LoginPage(driver);
		lp.login();

		HomePage hp = new HomePage(driver);
		boolean present = hp.userNameExists();		
		Assert.assertTrue(present);
		
		Report.endTestReport("TC_LoginPage", "Verify Login page");
	}
}
