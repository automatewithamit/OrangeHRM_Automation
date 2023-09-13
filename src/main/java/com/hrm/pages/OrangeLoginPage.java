package com.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeLoginPage {

	// 1. WebElements of the Page
	// 2. Actions performed on the WebElements or any actions performed on the page

	@FindBy(xpath = "//input[@placeholder='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@placeholder='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	public void login(String username, String pass) {
		userName.sendKeys(username);
		password.sendKeys(pass);
		loginButton.click();
	}

}
