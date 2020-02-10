package com.CRM.utilities;

import org.openqa.selenium.WebDriver;


public class DriverManager {
	
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	
	public static void setWebDriver(WebDriver driver) {

		dr.set(driver);
	}
	
	public static WebDriver getDriver() {

		return dr.get();

	}

	
}
