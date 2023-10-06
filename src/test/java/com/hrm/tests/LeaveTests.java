package com.hrm.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.hrm.helpers.ExcelHelper;
import com.hrm.pages.LoginPage;

public class LeaveTests extends BaseTest {

	@Test
	public void verifyLeaves() {
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
