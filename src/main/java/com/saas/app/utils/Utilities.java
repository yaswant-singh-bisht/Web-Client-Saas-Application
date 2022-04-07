package com.saas.app.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.saas.app.constants.Constants;
import com.saas.app.modules.LaunchEnvironment;
import com.saas.app.reports.Log;

public class Utilities extends LaunchEnvironment {

	public static String filePath;
	
	
	/***************************************************************************************
	 * This method will return date in String format as MM-dd-yyyy
	 **************************************************************************************/
	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String founddate = dateFormat.format(date);
		String[] parts = founddate.split(" ");
		String[] appenderpart1 = parts[0].split("/");
		String appender = appenderpart1[1] + "-" + appenderpart1[2] + "-" + appenderpart1[0];
		return appender;
	}

	/***************************************************************************************
	 * This method will return date and time in String format as MMddHHmmss
	 **************************************************************************************/
	public static String getDatetime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String founddate = dateFormat.format(date);
		String[] parts = founddate.split(" ");
		String[] appenderpart1 = parts[0].split("/");
		String[] appenderpart2 = parts[1].split(":");
		String appender = appenderpart1[1] + appenderpart1[2] + appenderpart2[0] + appenderpart2[1] + appenderpart2[2];
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

}
