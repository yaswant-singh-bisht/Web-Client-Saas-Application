package com.saas.app.modules;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.saas.app.constants.Constants;
import com.saas.app.reports.Log;

public class LaunchEnvironment {

	public static WebDriver driver;
	public static boolean flag;

	/***************************************************************************************
	 * This method will launcher the browser and return a flag that can be used with Assert
	 **************************************************************************************/
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
				System.setProperty("webdriver.firefox.driver", Constants.FirefoxDriverPath);
				driver = new FirefoxDriver();
				
			} else {
				Log.info(browser + " browser not found");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.pageLoadTime));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.implicitWaitTime));
			
			Log.info("Browser launched successfully");
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(e.fillInStackTrace().toString());
		}
		return flag;
	}
	
}
