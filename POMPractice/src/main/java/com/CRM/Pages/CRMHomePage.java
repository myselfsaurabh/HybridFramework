package com.CRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.CRM.Pages.CRMHomePage;
import com.CRM.utilities.DriverManager;


public class CRMHomePage extends BasePage {
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	public WebElement logIn;

	
	public CRMHomePage open(String url) {
		DriverManager.getDriver().get(url);
		return (CRMHomePage) openPage(CRMHomePage.class);
		
	}

	public CRMLogInPage gotoLogIn() {
		
		return (CRMLogInPage) openPage(CRMLogInPage.class);
			
	}
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(logIn);
	}
}
