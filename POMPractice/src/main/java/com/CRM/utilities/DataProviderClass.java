package com.CRM.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.CRM.utilities.Constants;
import com.CRM.utilities.TestRunManager;
import com.CRM.utilities.ExcelReader;

public class DataProviderClass {

	 
	@DataProvider(name="masterDP",parallel=true)
	public static Object[][] getDataSuite1(Method m) {

		System.out.println(m.getName());
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		String testcase = m.getName();
		return TestRunManager.getData(testcase, excel);
	
	}
}
