package com.hrm.pages;

public class UserManagementMenuPage {
	UsersPage usersPage;

	public UsersPage users() {
		this.usersPage = new UsersPage();
		return this.usersPage;
	}
}
