package com.hrm.webelements;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.hrm.framework.BrowserManager;
import com.hrm.framework.ElementUtil;

public class Button {

	public By locator;

	public Button(By locator) {
		this.locator = locator;
	}

	public void click() {
		ElementUtil.click(locator);
	}

	public String getText() {

		WebElement element;
		try {

			element = BrowserManager.getDriver().findElement(locator);

		} catch (StaleElementReferenceException ex) {

			element = BrowserManager.getDriver().findElement(locator);
		}

		return element.getText();
	}

	public boolean isDisplayed() {

		return true;
	}

	public boolean isEnabled() {

		return true;
	}

}
