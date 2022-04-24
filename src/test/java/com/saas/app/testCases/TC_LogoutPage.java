package com.saas.app.testCases;

import org.testng.annotations.Test;
import com.saas.app.pageObjects.BaseClass;
import com.saas.app.pageObjects.LogoutPage;
import com.saas.app.reports.Report;

public class TC_LogoutPage extends BaseClass {
	
	@Test
	public static void logoutPageTest() {
		Report.startTestReport("TC_LogoutPage", "Verify logout page");
		
		LogoutPage lp = new LogoutPage(driver);
		lp.logout();
		
		Report.endTestReport("TC_LogoutPage", "Verify logout page");
		
	}
}
