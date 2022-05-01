package com.saas.app.testCases;

import org.testng.Assert;
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
		Report.startTest("TC_ContactsPage", "Verify Contacts page");

		ContactsPage cp = new ContactsPage(driver);
		cp.createNewContact(FName, LName);
		
		Thread.sleep(2000);
		
		ContactsPage cp1 = new ContactsPage(driver); // Reinitializing page object so that saved value is considered
		String fullName = cp1.isContactCreated();
		
		if (fullName.equalsIgnoreCase(FName+" "+LName)) {
			Report.pass("Validate Contact Created", "Contact created successfully for " + fullName + ".", false);
		} else {
			Report.fail("Validate Contact Created", "Contact could not be created for " + fullName + ".", true);
		}
		
		Assert.assertEquals(fullName, FName+" "+LName);
		
		Report.endTest("TC_ContactsPage", "Verify Contacts page");
	}
}
