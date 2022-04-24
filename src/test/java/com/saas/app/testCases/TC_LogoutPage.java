package com.saas.app.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.saas.app.pageObjects.BaseClass;
import com.saas.app.pageObjects.LoginPage;
import com.saas.app.pageObjects.LogoutPage;
import com.saas.app.reports.Report;

public class TC_LogoutPage extends BaseClass {
	
	@Test
	public static void logoutPageTest() {
		Report.startTestReport("TC_LogoutPage", "Verify logout page");
		
		LogoutPage logoutPg = new LogoutPage(driver);
		logoutPg.logout();
		
		LoginPage loginPg = new LoginPage(driver);
		Boolean flag = loginPg.isEmailExists();
		Assert.assertTrue(flag);
		
		Report.endTestReport("TC_LogoutPage", "Verify logout page");
		
	}
}
