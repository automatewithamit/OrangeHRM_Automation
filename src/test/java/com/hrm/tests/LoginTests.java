package com.hrm.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.hrm.pages.LoginPage;

public class LoginTests extends BaseTest {
	@Test
	public void verifyLogin() {
//		Map<String, String> dataMap = projectData.read("QA_SmokeTestURL");
//
//		String username = dataMap.get("UserName");
//		String password = dataMap.get("Password");
		String username = "Admin";
		String password = "admin123";
		LoginPage loginPage = new LoginPage();
		loginPage.login(username, password);

	}

}
