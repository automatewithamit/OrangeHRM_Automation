package com.hrm.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.hrm.framework.BrowserManager;

public class Button {

	public By locator;

	public Button(By locator) {
		this.locator = locator;
	}

	public void click() {
		System.out.println("Clicking on Button --> " + locator );
		WebElement element = BrowserManager.driver.findElement(locator);
		element.click();
		System.out.println("Clicked on Button --> " + locator );
	}

	public String getText() {	
		
		
		
		
		
		WebElement element;
	try {
			
			element= BrowserManager.driver.findElement(locator);
			
		}catch(StaleElementReferenceException ex) {
			
			element = BrowserManager.driver.findElement(locator);
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
