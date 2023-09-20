package com.hrm.reporting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.hrm.framework.BrowserManager;

public class Reporter implements ITestListener {

	private static Logger Log = LogManager.getLogger(Reporter.class.getName());
	public static String testMethodReportFolder;
	private static String screenshotBase64 = null;

	public static void takeScreenShot(String screenshotName) {

		try {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
			TakesScreenshot scrShot = ((TakesScreenshot) BrowserManager.getDriver());

			// Call getScreenshotAs method to create image file
			File fullScreenshot = scrShot.getScreenshotAs(OutputType.FILE);

			// Use a file utility library to save the screenshot to a desired location
			FileUtils.copyFile(fullScreenshot,
					new File(testMethodReportFolder + "//" + screenshotName + "_" + timeStamp + ".png"));
		} catch (Exception e) {

		}

	}

	public static void takeScreenShot() {

		try {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
			TakesScreenshot scrShot = ((TakesScreenshot) BrowserManager.getDriver());

			// Call getScreenshotAs method to create image file
			File fullScreenshot = scrShot.getScreenshotAs(OutputType.FILE);

			// Use a file utility library to save the screenshot to a desired location
			FileUtils.copyFile(fullScreenshot, new File(testMethodReportFolder + "//" + timeStamp + ".png"));
		} catch (Exception e) {

		}

	}

	public static void extentScreenShot() {

		try {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
			TakesScreenshot scrShot = ((TakesScreenshot) BrowserManager.getDriver());

			// Call getScreenshotAs method to create image file
			File fullScreenshot = scrShot.getScreenshotAs(OutputType.FILE);

			try {
				FileInputStream fileInputStream = new FileInputStream(fullScreenshot);
				byte[] bytes = new byte[(int) fullScreenshot.length()];
				fileInputStream.read(bytes);
				screenshotBase64 = new String(Base64.encodeBase64(bytes));
			} catch (IOException e) {
				screenshotBase64 = null;
			}

		} catch (Exception e) {
			screenshotBase64 = null;
		}

	}

	public static void info(String message) {
		Log.info(message);
		ExtentHelper.getTest().log(Status.INFO, message);
		extentScreenShot();
		ExtentHelper.getTest().info(message);
				//MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
	}

	public static void warn(String message) {
		Log.warn(message);
		ExtentHelper.getTest().log(Status.WARNING, message);
	}

	public static void fail(String message) {
		Log.error(message);
		ExtentHelper.getTest().log(Status.FAIL, message);
		extentScreenShot();
		ExtentHelper.getTest().fail(message,
				MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
		screenshotBase64 = null;
	}

	public static void pass(String message) {
		Log.info(message);
		ExtentHelper.getTest().log(Status.PASS, message);
	}

	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " Started ***");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " Ending ***"));

	}

	public void onTestStart(ITestResult result) {
		System.out.println(("** Running test method " + result.getMethod().getMethodName() + "..."));

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentHelper.getTest().log(Status.PASS, "Test passed");
		ExtentHelper.getTest().pass("Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("** Test execution " + result.getMethod().getMethodName() + " failed...");
		ExtentHelper.getTest().log(Status.FAIL, "Test Failed");
		ExtentHelper.getTest().fail("Test Failed");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentHelper.getTest().log(Status.SKIP, "Test Skipped");
		ExtentHelper.getTest().skip("Test Skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}
