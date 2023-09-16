package com.hrm.framework;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This class is a Wrapper class aroung Selenium's Basic methods like findElement ,
 *  findElements and many more.
 */
public class ElementUtil {

	static WebDriverWait wait = new WebDriverWait(BrowserManager.driver, Duration.ofSeconds(20));

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
		// prerequisites
		// 1. that text box should be enable and displayed
		WebElement element;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element = BrowserManager.driver.findElement(locator);

			if (element.isDisplayed() && element.isEnabled())
				element.sendKeys(text);
			else {
				System.out.println("Text Box --> " + locator + "is not enable or Displayed");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Text Box --> " + locator + "incurred Stale Element Exception");
			element = BrowserManager.driver.findElement(locator);
		} catch (Exception ex) {

		}

	}

//1. simple Click
	public static void click(By locator) {
		WebElement element;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element = BrowserManager.driver.findElement(locator);

			if (element.isDisplayed() && element.isEnabled())
				element.click();
			else {
				System.out.println("WebElement --> " + locator + "is not enable or Displayed");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("WebElement --> " + locator + "incurred Stale Element Exception");
			element = BrowserManager.driver.findElement(locator);
		} catch (Exception ex) {

		}
	}

	// 2. Java Script Click
	public static void clickJS(By locator) {

	}

	// 3. Click using Actions class
	public static void clickUsingMouse(By locator) {

	}
}
