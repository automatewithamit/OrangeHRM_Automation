package com.hrm.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import com.hrm.framework.BrowserManager;
import com.hrm.framework.OptionsManager;
import com.hrm.helpers.ExcelHelper;
import com.hrm.helpers.PropertiesHelper;
import com.hrm.reporting.ExtentHelper;
import com.hrm.reporting.Reporter;

public class BaseTest {
	// String projectPath = System.getProperty("user.dir");

	PropertiesHelper urlHelper = new PropertiesHelper("//resources//url.properties");
	ExtentHelper extentHelper = new ExtentHelper();

	String excelFilePath = "\\src\\test\\resources\\com\\hrm\\data\\ProjectData.xlsx";
	ExcelHelper projectData = new ExcelHelper(excelFilePath);

	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
	String reportPath = "//Reports//" + "Report_" + timeStamp;

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		// String projectPath = System.getProperty("user.dir");
		System.out.println("Inside Before Suite");
		extentHelper.createExtentReports(reportPath, "OrangeHRM_RegressionReport.html");
	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		System.out.println("Inside Before Test");
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		System.out.println("Inside Before Method");
		BrowserManager browserManager = new BrowserManager();
		ExtentHelper.startTest(method.getName(), "Test Description");
		Reporter.info("This is Before Method");
		browserManager.startBrowser();
		String url = getDataMap().get("URL");
		// String url = urlHelper.getProperty("url");
		BrowserManager.getDriver().get(url);
		Reporter.info("Navigating to URL --> " + url);
		System.out.println("Navigating to URL --> " + url);
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("Inside After Method");
		Reporter.info("After Method is going to Execute...");
		BrowserManager.quitBrowser();
		

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		System.out.println("Inside After Test");
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println("Inside After Suite");
		extentHelper.endReport();
	}

	public Map<String, String> getDataMap() {
		BrowserManager browserManager = new BrowserManager();
		return projectData.read(browserManager.getSheetName());
	}
}
