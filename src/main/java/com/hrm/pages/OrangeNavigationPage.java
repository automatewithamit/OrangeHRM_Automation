package com.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.framework.BrowserManager;

public class OrangeNavigationPage {

	public OrangeNavigationPage() {
		PageFactory.initElements(BrowserManager.driver, this.getClass());
	}

	@FindBy(xpath = "//ul[contains(@class,'oxd-main-menu')]//a[contains(@href,'Admin')]")
	WebElement adminMenu;

	@FindBy(xpath = "//ul[contains(@class,'oxd-main-menu')]//a[contains(@href,'viewPimModule')]")
	WebElement pimMenu;

	@FindBy(xpath = "//ul[contains(@class,'oxd-main-menu')]//a[contains(@href,'viewLeaveModule')]")
	WebElement leaveModule;

}
