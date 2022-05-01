package com.saas.app.testCases;

import org.testng.annotations.Test;
import com.saas.app.pageObjects.BaseClass;
import com.saas.app.reports.Report;

public class TC_HomePage extends BaseClass {

	@Test
	public static void homePageTest() throws InterruptedException {
		Report.startTest("TC_HomePage", "Verify Home page");

		
		
		Report.endTest("TC_HomePage", "Verify Home page");
		
	}
}
