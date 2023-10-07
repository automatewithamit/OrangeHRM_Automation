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
	BrowserManager browserManager = new BrowserManager();
	PropertiesHelper urlHelper = new PropertiesHelper("//resources//url.properties");
	ExtentHelper extentHelper = new ExtentHelper();

	String excelFilePath = "\\src\\test\\resources\\com\\hrm\\data\\ProjectData.xlsx";
	ExcelHelper projectData = new ExcelHelper(excelFilePath);

	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
	String reportPath = "//Reports//" + "Report_" + timeStamp;

	@BeforeSuite
	public void beforeSuite() {
		// String projectPath = System.getProperty("user.dir");
		extentHelper.createExtentReports(reportPath, "OrangeHRM_RegressionReport.html");
	}

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(@Optional String browserType) {

	}

	@BeforeMethod
	public void beforeMethod(Method method) {

		ExtentHelper.startTest(method.getName(), "Test Description");
		Reporter.info("This is Before Method");
		browserManager.startBrowser();
		String url = getDataMap().get("URL");
		// String url = urlHelper.getProperty("url");
		BrowserManager.getDriver().get(url);
		Reporter.info("Navigating to URL --> " + url);

	}

	@AfterMethod
	public void afterMethod() {
		Reporter.info("After Method is going to Execute...");
		BrowserManager.quitBrowser();

	}

	@AfterSuite
	public void afterSuite() {
		extentHelper.endReport();

	}

	public Map<String, String> getDataMap() {
		return projectData.read(browserManager.getSheetName());

	}
}
