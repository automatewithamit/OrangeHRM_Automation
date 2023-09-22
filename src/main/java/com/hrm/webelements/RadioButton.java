package com.hrm.webelements;


import org.openqa.selenium.By;

import com.hrm.framework.ElementUtil;

public class RadioButton {
	public By locator;

	public RadioButton(By locator) {
		this.locator = locator;
	}

	public void click() {
		
		ElementUtil.click(locator);
		
	}

}
