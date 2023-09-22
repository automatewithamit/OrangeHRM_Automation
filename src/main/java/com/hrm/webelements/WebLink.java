package com.hrm.webelements;

import org.openqa.selenium.By;

import com.hrm.framework.ElementUtil;
import com.hrm.pages.BasePage;
import com.hrm.reporting.Reporter;

import bsh.org.objectweb.asm.Type;
import lombok.SneakyThrows;

public class WebLink {

	public WebLink(By locator) {
		this.locator = locator;
	}

	public By locator;

	@SuppressWarnings("deprecation")

	public <T> T click(Class<T> type) {
		ElementUtil.click(locator);
		T typeClass = null;
		try {
			typeClass = type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			Reporter.fail("Exception occurred in Weblink...");
		}
		return typeClass;

	}

	public boolean isDisplayed() {
		return true;
	}

	public boolean isEnabled() {

		return true;
	}

}
