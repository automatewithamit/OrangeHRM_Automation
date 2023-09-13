package com.hrm.tests;

import org.testng.annotations.Test;

import com.hrm.drivermanager.BrowserManager;
import com.hrm.pages.OrangeLoginPage;

public class OrangeHRMAdminTests extends BaseTest {

	@Test
	public void loginTest() {
		String username = urlHelper.getProperty("userName");
		String password = urlHelper.getProperty("password");
		
		OrangeLoginPage loginPage = new OrangeLoginPage();

		loginPage.login(username, password);

	}

}
