package com.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.framework.BrowserManager;
import com.hrm.webelements.WebLink;

public class NavigationMenuPage  extends BasePage{

	public NavigationMenuPage() {
		
	}

	public WebLink adminMenu = new WebLink(By.xpath("//ul[contains(@class,'oxd-main-menu')]//a[contains(@href,'Admin')]"));
	public WebLink pimMenu = new WebLink(
			By.xpath("//ul[contains(@class,'oxd-main-menu')]//a[contains(@href,'viewPimModule')]"));

	public WebLink leaveModule = new WebLink(
			By.xpath("//ul[contains(@class,'oxd-main-menu')]//a[contains(@href,'viewLeaveModule')]"));

	

}
