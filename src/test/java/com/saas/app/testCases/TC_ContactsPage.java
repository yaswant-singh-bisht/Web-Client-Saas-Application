package com.saas.app.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.saas.app.constants.Constants;
import com.saas.app.pageObjects.BaseClass;
import com.saas.app.pageObjects.ContactsPage;
import com.saas.app.reports.Report;
import com.saas.app.utils.ExcelUtilities;

public class TC_ContactsPage extends BaseClass {
	
	@DataProvider (name = "newContact")
	public Object[][] getNewContactData() {
		ExcelUtilities obj = new ExcelUtilities();
		Object[][] outputData = obj.getExcelData(Constants.ExcelDataProvidePath, Constants.CreateNewConstantSheetName);
		return outputData;
	}
	
	@Test (dataProvider = "newContact")
	public void valCreateNewContact(String FName, String LName) throws InterruptedException {
		Report.startTestReport("TC_ContactsPage", "Verify Contacts page");

		ContactsPage cp = new ContactsPage(driver);
		cp.createNewContact(FName, LName);
		String name = cp.isContactCreated();
		Thread.sleep(2000);
		System.out.println("Name is - " + name);
//		Assert.assertEquals(name, FName+" "+LName);
		
		Report.endTestReport("TC_ContactsPage", "Verify Contacts page");
	}
}