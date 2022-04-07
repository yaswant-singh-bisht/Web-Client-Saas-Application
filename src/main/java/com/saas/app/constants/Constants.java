package com.saas.app.constants;

import com.saas.app.utils.Utilities;

public class Constants {
	// Driver
	public static final String ChromeDriverPath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
	public static final String MSEdgeDriverPath = System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe";
	public static final String FirefoxDriverPath = System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";
	
	// Extent Report
	public static final String ReportOutputPath = System.getProperty("user.dir")+"\\Execution Reports\\"+Utilities.getDate()+"\\"+Utilities.getDatetime()+".html";
	public static final String ReportAuthor = "Yaswant Bisht";
	public static final String ReportCategory = "Regression";
	public static final String ReportSeleniumVersion = "4.1.3";
	
	// Screenshot
	public static final String passScreenshotPath = System.getProperty("user.dir") + "\\Screenshots\\Pass Screenshots\\" + "p_" + System.currentTimeMillis() + ".png";
	public static final String failScreenshotPath = System.getProperty("user.dir") + "\\Screenshots\\Fail Screenshots\\" + "f_" + System.currentTimeMillis() + ".png";

	// Wait
	public static final int implicitWaitTime = 10;
	public static final int pageLoadTime = 15;
	
}
