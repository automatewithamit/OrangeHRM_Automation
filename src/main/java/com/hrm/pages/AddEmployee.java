package com.hrm.pages;

import org.openqa.selenium.By;

import com.hrm.reporting.Reporter;
import com.hrm.webelements.*;

public class AddEmployee extends BasePage {

	public AddEmployee() {

	}

	DropDown userRole = new DropDown(By.xpath("//label[text()='User Role']//following::i/.."));
	DropDown status = new DropDown(By.xpath("//label[text()='Status']//following::i/.."));
	TextBox empFirstName = new TextBox(By.xpath("//label[text()='Employee Full Name']//following::input[1]"));
	TextBox empMiddleName = new TextBox(By.xpath("//label[text()='Employee Full Name']//following::input[2]"));
	TextBox empLastName = new TextBox(By.xpath("//label[text()='Employee Full Name']//following::input[3]"));
	TextBox employeeId = new TextBox(By.xpath("//label[text()='Employee Id']//following::input[1]"));
	Toggle createLoginToggle = new Toggle(By.xpath("//label[text()='Password']//following::input[1]"));
	TextBox username = new TextBox(By.xpath("//label[text()='Username']//following::input[1]"));
	RadioButton enabled = new RadioButton(By.xpath("//label[text()='Enabled']/child::input[1]"));
	RadioButton disabled = new RadioButton(By.xpath("//label[text()='Disabled']/child::input[1]"));
	TextBox password = new TextBox(By.xpath("//label[text()='Password']//following::input[1]"));
	TextBox confirmPassword = new TextBox(By.xpath("//label[text()='Confirm Password']//following::input[1]"));
	Button save = new Button(By.xpath("//button[@type='submit']"));
	Button add = new Button(By.xpath("//button[normalize-space()='Add']"));

	public String addEmployee(String firstName, String lastName) {
		Reporter.info("Adding Employee with details " + firstName + "  and " + lastName);
		add.click();
		empFirstName.setText(firstName);
		empLastName.setText(lastName);
		String empID = employeeId.getText();
		save.click();
		Reporter.info(
				"Employee '" + firstName + " " + lastName + "' with Employee ID  '" + empID + "' got created successfully ");
		return empID;
	}

}
