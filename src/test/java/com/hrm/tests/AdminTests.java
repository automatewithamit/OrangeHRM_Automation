package com.hrm.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.devtools.v113.page.model.NavigatedWithinDocument;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.framework.BrowserManager;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.NavigationMenuPage;
import com.hrm.pages.UsersPage;
import com.hrm.reporting.Reporter;

public class AdminTests extends BaseTest {

	@Test
	public void verifyUsersCreationOnAdminPage() {

		String username = urlHelper.getProperty("userName");
		String password = urlHelper.getProperty("password");

		LoginPage loginPage = new LoginPage();

		DashboardPage dashboardPage = loginPage.login(username, password);

		dashboardPage.navigate().admin().click(UsersPage.class).addUser("Admin", "Enabled", "Amit",
				"test@123", "test@123");		
	}

}
