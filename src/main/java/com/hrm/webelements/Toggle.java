package com.hrm.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hrm.framework.BrowserManager;
import com.hrm.framework.ElementUtil;
import com.hrm.reporting.Reporter;

public class Toggle {
	public Toggle(By locator) {
		this.locator = locator;
	}

	public By locator;
	
	public void click() {
		//Reporter.info("Turning On Toggle --> " + locator );
		ElementUtil.click(locator);
		//Reporter.info("Clicked on Button --> " + locator );
	}
}
