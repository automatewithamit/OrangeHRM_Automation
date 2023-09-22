package com.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.framework.BrowserManager;
import com.hrm.reporting.Reporter;
import com.hrm.webelements.*;

public class LoginPage  extends BasePage{

	// 1. WebElements of the Page
	// 2. Actions performed on the WebElements or any actions performed on the page

	public LoginPage() {
	
	}

	TextBox userName = new TextBox(By.xpath("//input[@placeholder='Username']"));
	TextBox password = new TextBox(By.xpath("//input[@placeholder='Password']"));
	Button loginButton = new Button(By.xpath("//button[@type='submit']"));



	public DashboardPage login(String username, String pass) {

		userName.setText(username);
		password.setText(pass);
		loginButton.click();		
		return new DashboardPage();
	}

}