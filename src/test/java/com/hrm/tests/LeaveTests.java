package com.hrm.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.constants.TestGroups;
import com.hrm.helpers.ExcelHelper;
import com.hrm.pages.LoginPage;

public class LeaveTests extends BaseTest {

	@Test(groups = { TestGroups.Smoke, TestGroups.Regression, TestGroups.Leaves })
	public void verifyLeaves() {

		String username = getDataMap().get("UserName");
		String password = getDataMap().get("Password");
		LoginPage loginPage = new LoginPage();
		loginPage.login(username, password);
		Assert.assertEquals(true, true);
	}

	@Test(groups = { "Retry", TestGroups.Leaves })
	public void verifyAppliedLeavesApproval() {
		String username = getDataMap().get("UserName");
		String password = getDataMap().get("Password");
		LoginPage loginPage = new LoginPage();
		loginPage.login(username, password);
		Assert.assertEquals(true, false);
	}

	@Test(groups = { TestGroups.Smoke, TestGroups.Leaves })
	public void verifyLeavesGettingRejected() {
		String username = getDataMap().get("UserName");
		String password = getDataMap().get("Password");
		LoginPage loginPage = new LoginPage();
		loginPage.login(username, password);
		Assert.assertEquals(true, false);
	}

	@Test(groups = { TestGroups.Regression, TestGroups.Leaves })
	public void verifyMultipleApprovalOfLeaves() {
		String username = getDataMap().get("UserName");
		String password = getDataMap().get("Password");
		LoginPage loginPage = new LoginPage();
		loginPage.login(username, password);
		Assert.assertEquals(true, true);
	}

	@Test(groups = { TestGroups.Regression, TestGroups.Leaves })
	public void verifyLeavesGettingRejectedByManager() {
		String username = getDataMap().get("UserName");
		String password = getDataMap().get("Password");
		LoginPage loginPage = new LoginPage();
		loginPage.login(username, password);
		Assert.assertEquals(true, true);
	}
	// 1. Waits--> DONE  
	// 2. Verification--> DONE  
	// 3. Parallel Testing --> we are getting issue --> DONE  
	// Maven Configurations --> Plug ins SureFire Plugin , Compiler Plugin --> DONE  
	// 4. Constants --> groupname , timeout values , --> DONE  
	// 5. TestData Management --> Excel ,   --> DONE         DataBase
	// 6. retry --> DONE
	// Data Driven Tests @DataProviders --> DONE
	// configure pom.xml to execute  -- DONE
	// 7. Test Case Execution --> Jenkins (pull the code from remote repo and the
	// trigger the test case)
	// 2000 --> runnning tests in parallel with 8 threads , each test case takes 1
	// min to complete 1000 mins , parallel 10 thread 100 mins
// increase infra 2VMs
	// Jenkins --> Selenium Grid --> DockerContainer/VMs

}
