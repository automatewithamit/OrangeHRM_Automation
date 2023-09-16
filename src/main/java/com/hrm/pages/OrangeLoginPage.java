package com.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.framework.BrowserManager;
import com.hrm.webelements.*;

public class OrangeLoginPage {

	// 1. WebElements of the Page
	// 2. Actions performed on the WebElements or any actions performed on the page

	public OrangeLoginPage() {
		//PageFactory.initElements(BrowserManager.driver, this.getClass());
	}

//	TextBox userName = new TextBox(By.xpath("//input[@placeholder='Username']"));
//	TextBox password = new TextBox(By.xpath("//input[@placeholder='Password']"));
//	Button loginButton = new Button(By.xpath("//button[@type='submit']"));

	@FindBy(xpath = "//input[@placeholder='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@placeholder='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	public OrangeDashboardPage login(String username, String pass) {

//		userName.setText(username);
//
//		password.setText(pass);
		userName.sendKeys(username);
		password.sendKeys(pass);
		loginButton.click();
		System.out.println("Clicked on Login Button");
		return new OrangeDashboardPage();
	}

}
