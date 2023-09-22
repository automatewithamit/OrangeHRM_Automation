package com.hrm.pages;

import org.openqa.selenium.By;

import com.hrm.reporting.Reporter;
import com.hrm.webelements.*;

public class UsersPage extends BasePage {

	public UsersPage() {

	}

	DropDown userRole = new DropDown(By.xpath("//label[text()='User Role']//following::i/.."));
	DropDown status = new DropDown(By.xpath("//label[text()='Status']//following::i/.."));
	TextBox employeeName = new TextBox(By.xpath("//label[text()='Employee Name']//following::input[1]"));
	TextBox username = new TextBox(By.xpath("//label[text()='Username']//following::input[1]"));
	TextBox password = new TextBox(By.xpath("//label[text()='Password']//following::input[1]"));
	TextBox confirmPassword = new TextBox(By.xpath("//label[text()='Confirm Password']//following::input[1]"));
	Button save = new Button(By.xpath("//button[@type='submit']"));
	Button add = new Button(By.xpath("//button[normalize-space()='Add']"));

	public void addUser(String roleToSelect, String statusToSelect, String empName, String pass,
			String confirmPass) {
		Reporter.info("Creating user with details " + userRole + "  , " + status + "  , " + employeeName + "  , " + pass
				+ " , " + confirmPass);
		add.click();
		userRole.selectOption(roleToSelect);
		status.selectOption(statusToSelect);
		employeeName.setText(empName);
		password.setText(pass);
		confirmPassword.setText(confirmPass);
		save.click();
		Reporter.info("Successfully Created User");
	}
	public void searchUser(String userName) {
		
	}

}
