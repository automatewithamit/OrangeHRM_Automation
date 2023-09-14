package com.hrm.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

/*
 * This class is a Wrapper class aroung Selenium's Basic methods like findElement ,
 *  findElements and many more.
 */
public class ElementUtil {

	public static WebElement findElement(By locator) {
		WebElement element;
		try {

			element = BrowserManager.driver.findElement(locator);

		} catch (StaleElementReferenceException ex) {

			element = BrowserManager.driver.findElement(locator);
		}
		return element;
	}

	public static void setText(By locator, String text) {
		
		WebElement element = BrowserManager.driver.findElement(locator);
		element.sendKeys(text);

	}

}
