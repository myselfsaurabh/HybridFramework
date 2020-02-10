package com.CRM.TestCases;

import java.util.Hashtable;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.CRM.Pages.CRMContactsPage;
import com.CRM.Pages.CRMHomePage;
import com.CRM.Pages.CRMLogInPage;
import com.CRM.utilities.Constants;
import com.CRM.utilities.DataProviders;
import com.CRM.utilities.ExcelReader;
import com.CRM.utilities.TestRunManager;

public class CRMContactsTest extends TestBase {
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void crmContactsTest(Hashtable<String, String> data) throws InterruptedException {
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		System.out.println(this.getClass().getSimpleName());
		TestRunManager.checkExecution("master", this.getClass().getSimpleName(), data.get("Runmode"), excel);
		log.info("Inside Contacts Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		CRMHomePage crmhmpg = new CRMHomePage().open(data.get("url"));
		CRMLogInPage crmloginpg = crmhmpg.gotoLogIn();
		crmloginpg.doLoginAsInvalidUser(data.get("username"), data.get("password"));
		CRMContactsPage cp = new CRMContactsPage().openContactPage();
		cp.selectDropDown();
		Map val = cp.verifyTableValue();
		logInfo("Name is : " + val.get("Name"));
		logInfo("Address is : " + val.get("Address"));
		logInfo("Phone is : " + val.get("Phone"));
		logInfo("Email is : " + val.get("Email"));
		Assert.assertEquals(val.get("Name"), "Saurabh");
	}

	@AfterMethod
	public void tearDown() {

		logInfo("Contact Page Test Completed");

		quit();

		
	}

}
