package com.hrm.reporting;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentHelper {

	public static final ExtentReports extentReports = new ExtentReports();

	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

	public synchronized static ExtentReports createExtentReports(String reportPath, String reportName) {

		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath + "\\" + reportName);

		reporter.config().setReportName(reportName);
		extentReports.attachReporter(reporter);
		// extentReports.setSystemInfo("Blog Name", "SW Test Academy");
		// extentReports.setSystemInfo("Author", "Onur Baskirt");
		return extentReports;
	}

	public static synchronized ExtentTest getTest() {

		return extentTestMap.get((int) Thread.currentThread().getId());

	}

	public static synchronized ExtentTest startTest(String testName, String desc) {

		ExtentTest test = extentReports.createTest(testName, desc);

		extentTestMap.put((int) Thread.currentThread().getId(), test);

		return test;
	}

// public static synchronized void endTest() {
//      
//	 extentReports.test;
//		
//    }

	public static synchronized void endReport() {

		extentReports.flush();

	}
}
