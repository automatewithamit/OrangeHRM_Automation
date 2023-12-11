package com.awa.framework.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.awa.framework.core.BrowserManager;
import com.awa.framework.core.ElementUtil;
import com.awa.framework.reporting.Reporter;

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
