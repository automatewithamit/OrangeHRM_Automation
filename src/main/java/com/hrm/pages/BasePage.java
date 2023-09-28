package com.hrm.pages;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrm.framework.BrowserManager;

public class BasePage {
	
	WebDriverWait wait;
	
	public BasePage() {
		wait = new WebDriverWait(BrowserManager.getDriver(), Duration.ofSeconds(20));
	}

	public NavigationMenuPage navigateTo() {
		return new NavigationMenuPage();
	}

}
