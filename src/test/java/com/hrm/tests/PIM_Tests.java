package com.hrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.awa.framework.constants.TestGroups;
import com.awa.framework.utilities.DateTime;
import com.hrm.pages.*;
import com.hrm.pages.LoginPage;

public class PIM_Tests extends BaseTest {

	@Test(groups = { TestGroups.Regression, TestGroups.PIM })
	public void verifyEmployeeCreation() {
		String username = urlHelper.getProperty("userName");
		String password = urlHelper.getProperty("password");
		String dateTime = DateTime.getCurrentDateTime();
		String firstName = "FirstName_" + dateTime;
		String lastName = "LastName_" + dateTime;
		String expectedFullName = firstName + " " + lastName;
		System.out.println("Expected : " + expectedFullName);

		LoginPage loginPage = new LoginPage();

		DashboardPage dashboardPage = loginPage.login(username, password);
		PersonalDetailsPage personalDetailsPage = dashboardPage.navigateTo().pimModule().addEmployee()
				.createNewEmployee(firstName, lastName);
		String actualFullName = personalDetailsPage.getFullName();
		System.out.println("Actual : " + actualFullName);
		Assert.assertEquals(actualFullName, expectedFullName);
	}

	@Test(groups = { TestGroups.Regression, TestGroups.PIM })
	public void verifyEmployeeGettingDeleted() {

		String username = urlHelper.getProperty("userName");
		String password = urlHelper.getProperty("password");
		LoginPage loginPage = new LoginPage();

		DashboardPage dashboardPage = loginPage.login(username, password);
		EmployeeListPage employeeListPage = dashboardPage.navigateTo().pimModule().employeeList().deleteEmployee();

	}

}
