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
		Report.startTest("TC_LogoutPage", "Verify logout page");
		
		LogoutPage logoutPg = new LogoutPage(driver);
		logoutPg.logout();
		
		LoginPage loginPg = new LoginPage(driver);
		Boolean flag = loginPg.isEmailExists();
		
		if (flag) {
			Report.pass("Validate Logout", "User logged-out successfully.", false);
		} else {
			Report.fail("Validate Logout", "User could not logged-out.", true);
		}
		
		Assert.assertTrue(flag);
		
		Report.endTest("TC_LogoutPage", "Verify logout page");
		
	}
}
