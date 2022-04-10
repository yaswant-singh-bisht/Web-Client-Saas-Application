package com.saas.app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.saas.app.base.LaunchEnv;
import com.saas.app.constants.Constants;
import com.saas.app.reports.Log;

public class Utilities extends LaunchEnv {

	public static String filePath;
	public static FileInputStream file;
	public static Properties Config_Properties = loadProperties(Constants.ConfigPath);

	/***************************************************************************************
	 * This method loads the property file in buffer
	 **************************************************************************************/
	public static Properties loadProperties(String filePath) {
		Log.info("Loading properties for " + filePath);
		Properties prop = new Properties();
		try {
			file = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Log.info(e.fillInStackTrace().toString());
		}
		try {
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
			Log.info(e.fillInStackTrace().toString());
		}
		return prop;
	}

	
	/***************************************************************************************
	 * This method will return date in String format as MM-dd-yyyy
	 **************************************************************************************/
	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String founddate = dateFormat.format(date);
		return founddate;
	}

	/***************************************************************************************
	 * This method will return date and time in String format as MMddyyHHmmss
	 **************************************************************************************/
	public static String getDatetime() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
		Date date = new Date();
		String founddate = dateFormat.format(date);
		String[] parts = founddate.split(" ");
		String[] appenderpart1 = parts[0].split("/");
		String[] appenderpart2 = parts[1].split(":");
		String appender = appenderpart1[0] + appenderpart1[1] + appenderpart1[2] + appenderpart2[0] + appenderpart2[1] + appenderpart2[2];
		return appender;
	}

	/*************************************************************************************
	 * This method will get screenshot for the executed Test Case
	 **************************************************************************************/
	public static String getScreenshot(String passFail) {
		Log.info("Generating " + passFail + " screenshot");
		try {
			filePath = null;
			File f1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			if (passFail.equalsIgnoreCase("pass")) {
				filePath = Constants.passScreenshotPath;
			} else if (passFail.equalsIgnoreCase("fail")) {
				filePath = Constants.failScreenshotPath;
			} else {
				Log.info("Invalid test status");
			}
			File f2 = new File(filePath);
			FileUtils.copyFile(f1, f2);
		} catch (IOException e) {
			e.printStackTrace();
			Log.info(e.fillInStackTrace().toString());
		}
		return filePath;
	}

	
	
	
	/*****************************************************************************************
	 * This method will dynamically wait for an element to be visible on page
	 ****************************************************************************************/
	public static void waitForVisibilityOfElement(WebElement element) {
		Log.info("Waiting for the element to be visible");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(InvalidSelectorException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/***************************************************************************************
	 * This method will dynamically wait for an element to be clickable on page
	 **************************************************************************************/
	public static void waitForElementToBeClickable(WebElement element) {
		Log.info("Waiting for the element to be clickable");
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class)
				.ignoring(InvalidSelectorException.class)
				.ignoring(WebDriverException.class);
		fwait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/***************************************************************************************
	 * This method will encrypt password
	 **************************************************************************************/
	public static String encryptPassword(String decryptedPassword) {
		Log.info("Encrypting password");
		String encodedBytes = Base64.getEncoder().encodeToString(decryptedPassword.getBytes());
		return encodedBytes;
	}

	/***************************************************************************************
	 * This method will decrypt password
	 **************************************************************************************/
	public static String decryptPassword(String encryptedPassword) {
		Log.info("Decrpted text");
		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(encryptedPassword);
		String decryptedPassword = new String(decryptedPasswordBytes);
		return decryptedPassword;
	}

	/***************************************************************************************
	 * This method will perform mouse hover action
	 **************************************************************************************/
	public static void mouseHover(WebElement element) {
		Log.info("Mouse hover action");
		Actions ac = new Actions(driver);
		ac.moveToElement(element);
	}

	
	
	
	
	
	
	/*******************************************************************************************
	 * This method will clean the framework and will delete the files and folder for
	 * specific time duration
	 ******************************************************************************************/
	public static void cleanupFramework(int daysBack, String dirWay) {
		File directory = new File(dirWay);
		if (directory.exists()) {
			File[] listFiles = directory.listFiles();
			long purgeTime = System.currentTimeMillis() - (daysBack * 24 * 60 * 60 * 1000);
			for (File listFile : listFiles) {
				if (listFile.lastModified() < purgeTime) {
					if (!listFile.delete()) {
						Log.info("Unable to delete file: " + listFile);
					}
				}
			}
		}
	}
	
	
	
	
	
}
