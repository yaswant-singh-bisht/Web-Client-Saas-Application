package com.saas.app.pageObjects;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.saas.app.base.LaunchEnv;
import com.saas.app.constants.Constants;
import com.saas.app.reports.Log;
import com.saas.app.reports.Report;
import com.saas.app.utils.Utilities;

public class BaseClass extends LaunchEnv {
	static Boolean flag;

	@BeforeSuite
	public static void initEnvironment() {
		Log.initializeLog(); // Initializing log4j logs

		launchBrowser(Utilities.Config_Properties.getProperty("browser"));
		launchURL(Utilities.Config_Properties.getProperty("url"));

	}



	@AfterSuite
	public static void shutDownEnvironment() {

		Utilities.cleanupFramework(Integer.parseInt(Utilities.Config_Properties.getProperty("frameworkCleanUpDays")), Constants.cleanupScreenshotPath);
		Utilities.cleanupFramework(Integer.parseInt(Utilities.Config_Properties.getProperty("frameworkCleanUpDays")), Constants.cleanupExecutionReportPath);

		tearDown(); // Close driver

		Report.flush();
//		Report.close();
	}

}
