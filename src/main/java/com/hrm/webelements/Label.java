package com.hrm.webelements;

import org.openqa.selenium.By;

import com.hrm.framework.ElementUtil;

public class Label {
	public By locator;

	public Label(By locator) {
		this.locator = locator;
	}

	public String getText() {
		return ElementUtil.getText(locator);
	}

	public boolean isDisplayed() {
		return ElementUtil.isDisplayed(locator);
	}
}
