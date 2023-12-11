package com.awa.framework.core;

import org.testng.annotations.DataProvider;

import com.awa.framework.helpers.ExcelHelper;

public class DataProviders {

	@DataProvider(name = "getCustomerNameAgeData")
	public static Object[][] getCustomerNameAgeData() {

		return new Object[][] {};
	}

	@DataProvider(name = "excelData")
	public Object[][] testData() {
		String excelFilePath = "\\src\\test\\resources\\com\\hrm\\data\\ProjectData.xlsx";
		ExcelHelper projectData = new ExcelHelper(excelFilePath);
		return projectData.readExcelData("LoginTestData");
	}

	@DataProvider(name = "getDataAsString")
	public Object[] getDataAsString() {
		return new Object[] { "Automate" };
	}

}
