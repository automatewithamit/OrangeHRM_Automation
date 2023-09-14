package com.hrm.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.framework.BrowserManager;
import com.hrm.pages.OrangeDashboardPage;
import com.hrm.pages.OrangeLoginPage;

public class OrangeHRMAdminTests extends BaseTest {

	@Test
	public void loginTest() {
		List<String> expectedQuickLaunchItems = new ArrayList<String>();
		
		String username = urlHelper.getProperty("userName");
		String password = urlHelper.getProperty("password");
		//OrangeLoginPage loginPage = PageFactory.initElements(BrowserManager.driver, OrangeLoginPage.class);
		
		OrangeLoginPage loginPage = new OrangeLoginPage();	
		
		
		OrangeDashboardPage dashboardPage = loginPage.login(username, password);
		//Object Chaining or Constructor Chaining
		Assert.assertEquals(dashboardPage.isQuickLaunchItemsDisplayed(expectedQuickLaunchItems),"Quick Launch Icons are not Matching");
		
		

	}

}
