package com.hrm.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.framework.BrowserManager;
import com.hrm.pages.OrangeDashboardPage;
import com.hrm.pages.OrangeLoginPage;
import com.hrm.reporting.Reporter;

public class OrangeHRMAdminTests extends BaseTest {

	@Test
	public void loginTest() {
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
		// OrangeLoginPage loginPage = PageFactory.initElements(BrowserManager.driver,
		// OrangeLoginPage.class);

		OrangeLoginPage loginPage = new OrangeLoginPage();

		OrangeDashboardPage dashboardPage = loginPage.login(username, password);
		List<String> actualQuickLaunchIcons = dashboardPage.getActualQuickLaunchItemsFromDashboard();
		// Object Chaining or Constructor Chaining
		Assert.assertEquals(dashboardPage.verifyLists(expectedQuickLaunchItems, actualQuickLaunchIcons),
				"Quick Launch Icons are not Matching");
		Reporter.info("Quick Launch Icons are Matching");
	}

}
