package com.saas.app.reports;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {

	public static Logger logger = Logger.getLogger(Log.class.getName());
	
	public static void initializeLog() {
		DOMConfigurator.configure("log4j.xml");
	}
	
	public static void trace(String desc) {
		logger.trace(desc);
	}
	
	public static void debug(String desc) {
		logger.debug(desc);
	}
	
	public static void info(String desc) {
		logger.info(desc);
	}

	public static void warn(String desc) {
		logger.warn(desc);
	}

	public static void error(String desc) {
		logger.error(desc);
	}

	public static void fatal(String desc) {
		logger.fatal(desc);
	}
	
	public static void startTest(String testName, String desc) {
		logger.info("Start ********** " + testName + ": " + desc + " ********** Start");
	}

	public static void endTest(String testName, String desc) {
		logger.info("End   ********** " + testName + ": " + desc + " ********** End");
	}
	
}
