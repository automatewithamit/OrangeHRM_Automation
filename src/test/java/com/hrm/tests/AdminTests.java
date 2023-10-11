package com.hrm.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.constants.TestGroups;
import com.hrm.framework.BrowserManager;
import com.hrm.framework.CustomRetry;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.NavigationMenuPage;
import com.hrm.pages.UsersPage;
import com.hrm.reporting.Reporter;

public class AdminTests extends BaseTest {

	@Test(groups = { TestGroups.Regression, TestGroups.Admin }, retryAnalyzer = CustomRetry.class)
	public void verifyUsersCreationOnAdminPage() {

		String username = urlHelper.getProperty("userName");
		String password = urlHelper.getProperty("password");

		LoginPage loginPage = new LoginPage();

		DashboardPage dashboardPage = loginPage.login(username, password);

		dashboardPage.navigateTo().adminModulePage().userManagement().users().addUser("Admin", "Enabled", "Amit",
				"test@123", "test@123");
		Assert.assertEquals(false, true);
	}

}
