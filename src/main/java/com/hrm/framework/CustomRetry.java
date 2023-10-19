package com.hrm.framework;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.hrm.helpers.PropertiesHelper;

public class CustomRetry implements IRetryAnalyzer {

	int counter = 0;
	// int retryLimit = 3;

	public boolean retry(ITestResult result) {
		PropertiesHelper configProperty = new PropertiesHelper("//resources//config.properties");
		String retryLimit = configProperty.getProperty("maxRetryCount");
		// String retryLimit =
		// Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("retry");
		System.out.println("Retyr Count --> " + retryLimit);

		if (counter < Integer.valueOf(retryLimit)) {
			counter++;
			return true;
		}
		return false;
	}

}
