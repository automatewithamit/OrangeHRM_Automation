package com.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.framework.BrowserManager;
import com.hrm.webelements.WebLink;

public class NavigationMenuPage extends BasePage {

	public NavigationMenuPage() {

	}

	WebLink adminMenu = new WebLink(By.xpath("//ul[contains(@class,'oxd-main-menu')]//a[contains(@href,'Admin')]"));
	WebLink pimMenu = new WebLink(By.xpath("//ul[contains(@class,'oxd-main-menu')]//a[contains(@href,'viewPimModule')]"));

	WebLink leaveModule = new WebLink(By.xpath("//ul[contains(@class,'oxd-main-menu')]//a[contains(@href,'viewLeaveModule')]"));

	public AdminModulePage adminModulePage() {
		AdminModulePage adminPage = adminMenu.click(AdminModulePage.class);
		return adminPage;
	}

	public PIMModulePage pimModule() {
		return pimMenu.click(PIMModulePage.class);
	}

	public LeaveModulePage leaveModulePage() {
		return leaveModule.click(LeaveModulePage.class);
	}
}
