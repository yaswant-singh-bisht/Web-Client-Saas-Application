package com.saas.app.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

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

}
