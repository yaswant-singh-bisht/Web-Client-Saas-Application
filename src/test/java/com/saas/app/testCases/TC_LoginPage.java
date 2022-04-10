package com.saas.app.testCases;

import org.testng.annotations.Test;
import com.saas.app.pageObjects.BaseClass;
import com.saas.app.pageObjects.LoginPage;
import com.saas.app.reports.Report;
import com.saas.app.utils.Utilities;

public class TC_LoginPage extends BaseClass {
	static Boolean flag;
	
	@Test
	public static void loginPageTest() throws InterruptedException {
		Report.startTestReport("TC_LoginPage", "Verify Login page");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(Utilities.Config_Properties.getProperty("username"));
		lp.setPassword(Utilities.decryptPassword(Utilities.Config_Properties.getProperty("password")));
		lp.clickLogin();
		Thread.sleep(5000);
		
		Report.endTestReport("TC_LoginPage", "Verify Login page");
		
	}
	
	
	
	
	
}
