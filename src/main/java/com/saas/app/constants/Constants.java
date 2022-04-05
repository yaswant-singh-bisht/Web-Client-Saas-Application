package com.saas.app.constants;

import com.saas.app.utils.Utilities;

public class Constants {
	
	
	// Extent Report
	public static final String ReportOutputPath = System.getProperty("user.dir")+"\\Execution Reports\\"+Utilities.getDate()+"\\"+Utilities.getDatetime()+".html";
	public static final String ReportAuthor = "Yaswant Bisht";
	public static final String ReportCategory = "Regression";
	
}
