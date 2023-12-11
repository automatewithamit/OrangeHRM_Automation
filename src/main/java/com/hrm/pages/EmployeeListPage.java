package com.hrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;

import com.awa.framework.core.BrowserManager;
import com.awa.framework.reporting.Reporter;
import com.awa.framework.webelements.Button;
import com.awa.framework.webelements.DropDown;
import com.awa.framework.webelements.TextBox;

public class EmployeeListPage {

	public EmployeeListPage() {

	}

	TextBox employeeName = new TextBox(By.xpath("//label[text()='Employee Name']//following::input[1]"));
	TextBox employeeId = new TextBox(By.xpath("//label[text()='Employee Id']//following::input[1]"));
	DropDown employmentStatus = new DropDown(By.xpath("(//label[text()='Employment Status']//following::i/..)[1]"));
	Button search = new Button(By.xpath("//button[@type='submit']"));
	Button add = new Button(By.xpath("//button[normalize-space()='Add']"));
	Button deleteConfirmation = new Button(By.xpath("//button[normalize-space()='Yes, Delete']"));

	public String searchEmployee(String empID, @Optional String empName) {

		if (!empName.isEmpty()) {
			Reporter.info("Searching Employee with details " + empID + "  and " + empName);
			employeeName.setText(empName);
			employeeId.setText(empID);
			search.click();

		} else {
			Reporter.info("Searching Employee with details " + empID);
			employeeId.setText(empID);
		}
		search.click();

		Reporter.info("Employee '" + empName + "' with Employee ID  '" + empID + "' got Searched successfully ");
		return empID;
	}

	public EmployeeListPage deleteEmployee(String employeeID) {
		String deleteButtonxPath = "//div[contains(@class,'orangehrm-employee-list')]//div[.='" + employeeID
				+ "']/..//button[1]";
		Button deleteButton = new Button(By.xpath(deleteButtonxPath));
		deleteButton.click();
		deleteConfirmation.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.info("Employee with ID " + employeeID + "Got Deleted Successfully");
		return new EmployeeListPage();
	}
	
	
	public EmployeeListPage deleteEmployee() {
		String deleteButtonxPath = "//div[contains(@class,'orangehrm-employee-list')]//button[1]";
		
		
		for(int i=1;i<=3;i++) {
			WebElement deleteButtonsList = BrowserManager.getDriver().findElement(By.xpath(deleteButtonxPath));
			deleteButtonsList.click();
			deleteConfirmation.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		//Reporter.info("Employee with ID " + employeeID + "Got Deleted Successfully");
		return new EmployeeListPage();
	}
}
