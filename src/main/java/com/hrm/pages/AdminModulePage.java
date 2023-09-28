package com.hrm.pages;

public class AdminModulePage {

	UserManagementMenuPage userManagement;

	public UserManagementMenuPage userManagement() {

		this.userManagement = new UserManagementMenuPage();

		return this.userManagement;
	}
}
