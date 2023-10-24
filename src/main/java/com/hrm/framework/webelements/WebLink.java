package com.hrm.framework.webelements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrm.framework.core.BrowserManager;
import com.hrm.framework.core.ElementUtil;
import com.hrm.framework.reporting.Reporter;
import com.hrm.framework.utilities.TimeDelay;


public class WebLink {
	WebDriverWait wait = new WebDriverWait(BrowserManager.getDriver(), Duration.ofSeconds(TimeDelay.TimeOut20Secs));

	public WebLink(By locator) {
		this.locator = locator;
	}

	public By locator;

	@SuppressWarnings("deprecation")

	public <T> T click(Class<T> type) {
		ElementUtil.click(locator);
		
		T typeClass = null;
		try {
			typeClass = type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			Reporter.fail("Exception occurred in Weblink...");
		}
		return typeClass;

	}

	public boolean isDisplayed() {
		return true;
	}

	public boolean isEnabled() {

		return true;
	}

}
