package com.saas.app.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.saas.app.constants.Constants;
import com.saas.app.reports.Log;
import com.saas.app.utils.Utilities;

public class LaunchEnv {

	public static WebDriver driver;
	public static boolean flag;

	/***************************************************************************************
	 * This method will launcher the browser and return a flag that can be used with Assert
	 ***************************************************************************************/
	public static boolean launchBrowser(String browser) {
		flag = false;
		Log.info("Launching browser: " + browser);
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", Constants.ChromeDriverPath);
				driver = new ChromeDriver();
				
			} else if (browser.equalsIgnoreCase("edge") || browser.equalsIgnoreCase("msedge")) {
				System.setProperty("webdriver.edge.driver", Constants.MSEdgeDriverPath);
				driver = new EdgeDriver();
				
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", Constants.FirefoxDriverPath);
				driver = new FirefoxDriver();
				
			} else {
				Log.info(browser + " browser not found");
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(Utilities.Config_Properties.getProperty("pageLoadTime"))));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(Utilities.Config_Properties.getProperty("implicitWaitTime"))));
			
			Log.info("Browser launched successfully");
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(e.fillInStackTrace().toString());
		}
		return flag;
	}
	
	
	/***************************************************************************************
	 * This method will launch the URL and return a flag that can be used with Assert
	 ***************************************************************************************/
	public static boolean launchURL(String URL) {
		flag = false;
		Log.info("Launching URL: " + URL);
		try {
			driver.get(URL);
			flag = true;
			Log.info("URL launched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(e.fillInStackTrace().toString());
		}
		return flag;
	}
	
//	/**********************************************************************************************
//	 * This method will disable any warning message and return a flag that can be used with Assert
//	 **********************************************************************************************/
//	public static boolean disableWarning() {
//		flag = false;
//		Log.info("Closing warning");
//		try {
//			System.err.close();
//			System.setErr(System.out);
//			flag = true;
//			Log.info("Warning closed successfully");
//		} catch (Exception e) {
//			e.printStackTrace();
//			Log.info(e.fillInStackTrace().toString());
//		}
//		return flag;
//	}
	
	/***************************************************************************************
	 * This method will close the browser and return a flag that can be used with Assert
	 ***************************************************************************************/
	public static boolean closeBrowser() {
		flag = false;
		Log.info("Closing browser");
		try {
			driver.close();
			flag = true;
			Log.info("Browser closed successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(e.fillInStackTrace().toString());
		}
		return flag;
	}

	/********************************************************************************************
	 * This method will close the driver instance and return a flag that can be used with Assert
	 ********************************************************************************************/
	public static boolean tearDown() {
		flag = false;
		Log.info("Closing driver instance");
		try {
			driver.quit();
			flag = true;
			Log.info("Driver closed successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(e.fillInStackTrace().toString());
		}
		return flag;
	}
	
}
