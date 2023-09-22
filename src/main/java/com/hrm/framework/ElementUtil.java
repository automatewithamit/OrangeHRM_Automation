package com.hrm.framework;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrm.reporting.Reporter;

/*
 * This class is a Wrapper class aroung Selenium's Basic methods like findElement ,
 *  findElements and many more.
 */
public final class ElementUtil {

	static WebDriverWait wait = new WebDriverWait(BrowserManager.getDriver(), Duration.ofSeconds(20));

	public static WebElement findElement(By locator) {
		WebElement element;
		try {

			element = BrowserManager.getDriver().findElement(locator);

		} catch (StaleElementReferenceException ex) {

			element = BrowserManager.getDriver().findElement(locator);
		}
		return element;
	}

	public static void setText(By locator, String text) {
		// prerequisites
		// 1. that text box should be enable and displayed
		WebElement element;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element = BrowserManager.getDriver().findElement(locator);

			if (element.isDisplayed() && element.isEnabled())
				element.sendKeys(text);
			else {
				Reporter.info("Text Box --> " + locator + "is not enabled or Displayed");
			}
		} catch (StaleElementReferenceException e) {
			Reporter.info("Text Box --> " + locator + "incurred Stale Element Exception");
			element = BrowserManager.getDriver().findElement(locator);
		} catch (Exception ex) {

		}

	}

	public static String getText(By locator) {

		WebElement element;
		String text = "";
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element = BrowserManager.getDriver().findElement(locator);

			if (element.isDisplayed() && element.isEnabled()) {
				text = element.getText();
				Reporter.info("Retrieved Text from Text Box --> " + locator);
			} else {
				Reporter.info("Text Box --> " + locator + "is not enabled or Displayed");
			}
		} catch (StaleElementReferenceException e) {
			Reporter.info("Text Box --> " + locator + "incurred Stale Element Exception");
			element = BrowserManager.getDriver().findElement(locator);
		} catch (Exception ex) {

		}
		return text;
	}

//1. simple Click
	public static void click(By locator) {
		WebElement element;

		Reporter.info("Clicking on  --> " + locator);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element = BrowserManager.getDriver().findElement(locator);

			if (element.isDisplayed() && element.isEnabled())

				element.click();
			else {
				Reporter.info("WebElement --> " + locator + "is not enable or Displayed");
			}
		} catch (StaleElementReferenceException e) {
			Reporter.info("WebElement --> " + locator + "incurred Stale Element Exception");
			element = BrowserManager.getDriver().findElement(locator);
		} catch (Exception ex) {

		}
		Reporter.info("Clicked on --> " + locator);
	}

	// 2. Java Script Click
	public static void clickJS(By locator) {

	}

	// 3. Click using Actions class
	public static void clickUsingMouse(By locator) {

	}

	public static void doubleClick(By locator) {

	}
}
