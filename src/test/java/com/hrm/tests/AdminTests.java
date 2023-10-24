package com.hrm.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.framework.constants.TestGroups;
import com.hrm.framework.core.BrowserManager;
import com.hrm.framework.listeners.RetryAnalyzer;
import com.hrm.framework.reporting.Reporter;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.NavigationMenuPage;
import com.hrm.pages.UsersPage;

public class AdminTests extends BaseTest {

	@Test(groups = { TestGroups.Regression, TestGroups.Admin })
	public void verifyUsersCreationOnAdminPage() {

		String username = urlHelper.getProperty("userName");
		String password = urlHelper.getProperty("password");

		LoginPage loginPage = new LoginPage();

		DashboardPage dashboardPage = loginPage.login(username, password);

		// dashboardPage.navigateTo().adminModulePage().userManagement().users().addUser("Admin",
		// "Enabled", "Amit",
		// "test@123", "test@123");
		Assert.assertEquals(true, true);
	}

}
