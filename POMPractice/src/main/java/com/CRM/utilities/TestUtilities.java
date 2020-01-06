package com.CRM.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.PropertyConfigurator;

public class TestUtilities {

	public static String getSystemDate() 
	{
		DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
		
	}
	
	public static void setDateForLog4j() 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyy_hhmmss");
		System.setProperty("current_date", dateFormat.format(new Date()));
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
	}
}
