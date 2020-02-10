package com.CRM.TestCases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

import com.CRM.Pages.CRMHomePage;
import com.CRM.Pages.CRMLogInPage;
import com.CRM.utilities.DataProviders;
import com.CRM.utilities.Constants;
import com.CRM.utilities.TestRunManager;
import com.CRM.utilities.ExcelReader;

public class CRMLogInTest extends TestBase {
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void crmLogInTest(Hashtable<String,String> data) throws InterruptedException {
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		System.out.println(this.getClass().getSimpleName());
		TestRunManager.checkExecution("master", "LoginTest", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		CRMHomePage crmhmpg = new CRMHomePage().open(data.get("url"));
		CRMLogInPage crmloginpg = crmhmpg.gotoLogIn();
		crmloginpg.doLoginAsInvalidUser(data.get("username"), data.get("password"));
		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}
}
