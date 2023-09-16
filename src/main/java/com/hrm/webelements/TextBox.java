package com.hrm.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.hrm.framework.BrowserManager;
import com.hrm.framework.ElementUtil;

public class TextBox {

	public TextBox(By locator) {
		this.locator = locator;
	}

	public By locator;

	public void setText(String text) {
		System.out.println("Setting Text ' " + text + " ' to the Text Box --> " + locator);
		//StaleReferenceElementException -->
		
		ElementUtil.setText(locator, text);
		System.out.println("Set Text ' " + text + " ' to the Text Box --> " + locator);
	}
	
	public void clearText() {

	}

	public boolean isDisplayed() {

		return true;
	}

	public boolean isEnabled() {

		return true;
	}

	// Enter Text
	// ClearText
	// isDisplayed
	// isEnabled

}
