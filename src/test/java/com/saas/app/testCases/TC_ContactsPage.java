package com.saas.app.testCases;

import org.testng.annotations.Test;

import com.saas.app.pageObjects.BaseClass;
import com.saas.app.pageObjects.ContactsPage;
import com.saas.app.pageObjects.HomePage;
import com.saas.app.reports.Report;

public class TC_ContactsPage extends BaseClass {
	
	@Test
	public static void createNewContact() throws InterruptedException {
		Report.startTestReport("TC_ContactsPage", "Verify Contacts page");

		HomePage hp = new HomePage(driver);
		hp.clickLeftNav();
		hp.clickTaskContacts();
		Thread.sleep(5000);
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickCreateContacts();
		cp.setFirstName("Yaswant");
		cp.setLastName("Bisht");
		cp.clickSave();
		
		Thread.sleep(5000);
		
		cp.newtest();
		Thread.sleep(5000);
		
//		System.out.println("TEst ************************************** ");
//		
//		WebElement element = driver.findElement(By.xpath(""));
//		String name = element.getText();
//		System.out.println("Name is - " + name);
		
		Report.endTestReport("TC_ContactsPage", "Verify Contacts page");
		
	}
	
}
