package com.hrm.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.pages.OrangeDashboardPage;
import com.hrm.pages.OrangeLoginPage;

public class DashboardTests extends BaseTest {

	@Test
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
		OrangeLoginPage loginPage = new OrangeLoginPage();
		loginPage.login(username, password);
		OrangeDashboardPage dashboardPage = new OrangeDashboardPage();
		List<String> actualWidgetsList = dashboardPage.getActualWidgetsOnDashboard();
		// 2. Get All the Widget Names from Dashboard
		boolean areWidgetsAvailable = dashboardPage.verifyLists(expectedWidgets, actualWidgetsList);
		// 3. Verify that Wiget Names captured from Dashboard have same expected Widgets
		// available
		Assert.assertEquals(areWidgetsAvailable, true, "All the Expected Widgets are not available on the Dashboard");
	}

}
