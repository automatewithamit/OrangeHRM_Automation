package com.hrm.pages;

public class PIMModulePage {

	public PIMModulePage() {

	}

	AddEmployeePage addEmployeePage;
	EmployeeListPage employeeListPage;

	public EmployeeListPage employeeList() {
		employeeListPage = new EmployeeListPage();
		return this.employeeListPage;
	}

	public AddEmployeePage addEmployee() {
		addEmployeePage = new AddEmployeePage();
		return this.addEmployeePage;
	}
	
}
