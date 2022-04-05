package com.saas.app.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.saas.app.constants.Constants;

public class Report {
	public static ExtentReports reports = new ExtentReports(Constants.ReportOutputPath, false);
	public static ExtentTest test;
	
	public static void startTest(String testStepName, String desc) {
		test = reports.startTest(testStepName, desc);
		add_System_Info();
		assignAuthor(Constants.ReportAuthor);
		assignTestCategory(Constants.ReportCategory);
		
	}
	
	
}
