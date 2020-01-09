package com.CRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CRMLogInPage extends BasePage {
	
	@FindBy(xpath = "//input[@placeholder='E-mail address']")
	public WebElement email;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement pass;

	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	public WebElement signin;
	
	public CRMLogInPage doLoginAsInvalidUser(String username, String password) throws InterruptedException {

		type(email, username, "Username textbox");
		Thread.sleep(4000);
		type(pass, password, "Password textbox");
		Thread.sleep(4000);
		click(signin, "Sign in Button");
		Thread.sleep(4000);

		return this;

	}

	

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(email);
	}

}
