package com.awa.framework.webelements;


import org.openqa.selenium.By;

import com.awa.framework.core.ElementUtil;

public class RadioButton {
	public By locator;

	public RadioButton(By locator) {
		this.locator = locator;
	}

	public void click() {
		
		ElementUtil.click(locator);
		
	}

}
