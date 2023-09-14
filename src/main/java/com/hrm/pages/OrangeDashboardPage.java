package com.hrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hrm.framework.BrowserManager;

public class OrangeDashboardPage {

	List<WebElement> quickLaunchIcons = BrowserManager.driver
			.findElements(By.xpath("//div[@class='oxd-grid-3 orangehrm-quick-launch']//p"));

	public OrangeDashboardPage() {

	}

	public boolean isQuickLaunchItemsDisplayed(List<String> quickLaunchItemsList) {
		boolean isDisplayed = true;
		
		
		

		return !isDisplayed;
	}

}
