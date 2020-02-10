package com.CRM.Pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CRMContactsPage extends BasePage {
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	public WebElement contactTab;
	@FindBy(xpath = "//div[@name='view']")
	public WebElement viewDropDown;
	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")
	public WebElement firstRowName;
	@FindBy(xpath = "//table/tbody/tr[1]/td[3]")
	public WebElement firstRowAddress;
	@FindBy(xpath = "//table/tbody/tr[1]/td[6]")
	public WebElement firstRowPhone;
	@FindBy(xpath = "//table/tbody/tr[2]/td[7]")
	public WebElement secondRowEmail;

	public CRMContactsPage openContactPage() {
		return (CRMContactsPage) openPage(CRMContactsPage.class);
	}

	public void selectDropDown() {
		click(contactTab, "Clicked on contact tab");
		// select(viewDropDown,"Default View");
	}

	public Map<String, String> verifyTableValue() throws InterruptedException {
		Map<String, String> strMap = new HashMap<String, String>();
		Thread.sleep(2000);
		strMap.put("Name", firstRowName.getText());
		strMap.put("Address", firstRowAddress.getText());
		strMap.put("Phone", firstRowPhone.getText());
		strMap.put("Email", secondRowEmail.getText());

		return strMap;
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(contactTab);
	}
}
