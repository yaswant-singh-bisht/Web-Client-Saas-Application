package com.saas.app.reports;

import java.util.HashMap;
import java.util.Map;

import com.saas.app.utils.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.saas.app.constants.Constants;

public class Report {
	public static ExtentReports reports = new ExtentReports(Constants.ReportOutputPath, false);
	public static ExtentTest test;
	
	public static void startTestReport(String testStepName, String desc) {
		Log.startTest(testStepName, desc);
		test = reports.startTest(testStepName, desc);
		test.assignAuthor(Constants.ReportAuthor);
		test.assignCategory(Constants.ReportCategory);
		
		Map<String, String> sysInfo = new HashMap<String, String>();
		sysInfo.put("Selenium Verson", Constants.ReportSeleniumVersion);
		reports.addSystemInfo(sysInfo);
	}
	
	public static void passReport(String testStepName, String desc, boolean takeScreenshot) {
		if (takeScreenshot == true) {
			String screenshotPath = Utilities.getScreenshot("pass");
			test.log(LogStatus.PASS, "<span style ='color:green'>" + testStepName + "</span>", "<span style ='color:green'>" + desc + "</span>" + test.addScreenCapture(screenshotPath));
		} else {
			test.log(LogStatus.PASS, "<span style ='color:green'>" + testStepName + "</span>", "<span style ='color:green'>" + desc + "</span>");
		}
	}

	public static void failReport(String testStepName, String desc, boolean takeScreenshot) {
		if (takeScreenshot == true) {
			String screenshotPath = Utilities.getScreenshot("fail");
			test.log(LogStatus.FAIL, "<span style ='color:red'>" + testStepName + "</span>", "<span style ='color:red'>" + desc + "</span>" + test.addScreenCapture(screenshotPath));
		} else {
			test.log(LogStatus.FAIL, "<span style ='color:red'>" + testStepName + "</span>", "<span style ='color:red'>" + desc + "</span>");
		}
	}
	
	public static void infoReport(String testStepName, String desc) {
		test.log(LogStatus.INFO, "<span style ='color:blue'>" + testStepName + "</span>", "<span style ='color:blue'>" + desc + "</span>");
	}

	public static void warnReport(String testStepName, String desc) {
		test.log(LogStatus.WARNING, "<span style ='color:brown'>" + testStepName + "</span>", "<span style ='color:brown'>" + desc + "</span>");
	}

	public static void fatalReport(String testStepName, String desc) {
		test.log(LogStatus.FATAL, "<span style ='font-weight:bold; color:red'>" + testStepName + "</span>", "<span style ='font-weight:bold; color:red'>" + desc + "</span>");
	}

	public static void endTestReport(String testStepName, String desc) {
		Log.endTest(testStepName, desc);
		reports.endTest(test);
	}

	public static void flushReport() {
		reports.flush();
	}
}
