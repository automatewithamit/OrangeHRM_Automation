package com.hrm.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.hrm.drivermanager.BrowserManager;
import com.hrm.drivermanager.OptionsManager;
import com.hrm.helpers.PropertiesHelper;

public class BaseTest {

	BrowserManager browserManager = new BrowserManager();
	PropertiesHelper urlHelper = new PropertiesHelper("//resources//url.properties");

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is Before Method");
		browserManager.startBrowser();
		String url = urlHelper.getProperty("url");
		BrowserManager.driver.get(url);
		System.out.println("Navigating to URL --> " + url);

	}

	@BeforeClass
	public void beforeClass() {

	}

}
