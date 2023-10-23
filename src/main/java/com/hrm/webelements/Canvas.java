package com.hrm.webelements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrm.framework.BrowserManager;
import com.hrm.framework.ElementUtil;
import com.hrm.reporting.Reporter;
import com.hrm.utilities.TimeDelay;

public class Canvas {
	WebDriverWait wait = new WebDriverWait(BrowserManager.getDriver(), Duration.ofSeconds(TimeDelay.TimeOut20Secs));
	public By locator;

	public Canvas(By locator) {
		this.locator = locator;
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
