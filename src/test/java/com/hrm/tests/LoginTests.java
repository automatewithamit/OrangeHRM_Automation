package com.hrm.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.awa.framework.constants.TestGroups;
import com.awa.framework.helpers.DBHelper;
import com.hrm.pages.LoginPage;

public class LoginTests extends BaseTest {
	@Test(groups = { TestGroups.Regression,
			TestGroups.Login }, dataProvider = "excelData", dataProviderClass = com.awa.framework.core.DataProviders.class)
	public void verifyLogin(String testID, String scenarioID, String username, String password, String message) {
		// Map<String, String> dataMap = projectData.read("QA_SmokeTestURL");

		// String username = dataMap.get("UserName");
		// String password = dataMap.get("Password");

//		String username = "Admin";
//		String password = "admin123";
		LoginPage loginPage = new LoginPage();
		loginPage.login(username, password);

	}

	@Test(groups = { TestGroups.Regression, TestGroups.Login, TestGroups.DB })
	public void verifyLoginUsingDB() {
		// Map<String, String> dataMap = projectData.read("QA_SmokeTestURL");

		// String username = dataMap.get("UserName");
		// String password = dataMap.get("Password");

//		String username = "Admin";
//		String password = "admin123";
		DBHelper db = new DBHelper();
		String username = db.readLoginTable().get("username");
		String password = db.readLoginTable().get("password");
		LoginPage loginPage = new LoginPage();
		loginPage.login(username, password);

	}

}
