package com.hrm.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.framework.constants.TestGroups;
import com.hrm.framework.reporting.Reporter;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;

public class DashboardTests extends BaseTest {

	@Test(groups = { TestGroups.Regression, TestGroups.Dashboard })
	public void verifyAllWidgetsOnDashboardScreen() {

		String username = urlHelper.getProperty("userName");
		String password = urlHelper.getProperty("password");

		List<String> expectedWidgets = new ArrayList<>();
		expectedWidgets.add("Time at Work");
		expectedWidgets.add("My Actions");
		expectedWidgets.add("Quick Launch");
		expectedWidgets.add("Buzz Latest Posts");
		expectedWidgets.add("Employees on Leave Today");
		expectedWidgets.add("Employee Distribution by Sub Unit");
		expectedWidgets.add("Employee Distribution by Location");

		// 1. Navigate to Orange HRM Dashboard Page
		LoginPage loginPage = new LoginPage();
		loginPage.login(username, password);
		DashboardPage dashboardPage = new DashboardPage();
		List<String> actualWidgetsList = dashboardPage.getActualWidgetsOnDashboard();
		// 2. Get All the Widget Names from Dashboard
		boolean areWidgetsAvailable = dashboardPage.verifyLists(expectedWidgets, actualWidgetsList);
		// 3. Verify that Wiget Names captured from Dashboard have same expected Widgets
		// available
		Assert.assertEquals(areWidgetsAvailable, true, "All the Expected Widgets are not available on the Dashboard");
		Reporter.info("All the Expected Widgets are not available on the Dashboard");
	}

	@Test(groups = { TestGroups.Regression, TestGroups.Dashboard })
	public void verifyQuickLaunchSectionOnDashboardPage() {
		List<String> expectedQuickLaunchItems = new ArrayList<String>();
		// Test Data can be fetched into the tests from different sources
		// Sources --> 1. CSV files 2. Excel Files 3. Properties file 4. JSON file 5.
		// XML files 6. DataBase or 7. with in the Tests itself
		expectedQuickLaunchItems.add("Assign Leave");
		expectedQuickLaunchItems.add("Leave List");
		expectedQuickLaunchItems.add("Timesheets");
		expectedQuickLaunchItems.add("Apply Leave");
		expectedQuickLaunchItems.add("My Leave");
		expectedQuickLaunchItems.add("My Timesheet");

		String username = urlHelper.getProperty("userName");
		String password = urlHelper.getProperty("password");

		LoginPage loginPage = new LoginPage();

		DashboardPage dashboardPage = loginPage.login(username, password);
		List<String> actualQuickLaunchIcons = dashboardPage.getActualQuickLaunchItemsFromDashboard();
		// Object Chaining or Constructor Chaining
		Assert.assertEquals(dashboardPage.verifyLists(expectedQuickLaunchItems, actualQuickLaunchIcons),
				"Quick Launch Icons are not Matching");
		Reporter.info("Quick Launch Icons are Matching");
	}
}
