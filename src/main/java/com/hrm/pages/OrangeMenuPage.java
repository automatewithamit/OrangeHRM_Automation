package com.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeMenuPage {

	@FindBy(xpath = "//ul[contains(@class,'oxd-main-menu')]//a[contains(@href,'Admin')]")
	WebElement adminMenu;
	
	

}
