package com.hrm.pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hrm.framework.BrowserManager;
import com.hrm.reporting.Reporter;

public class DashboardPage extends BasePage {

	List<WebElement> quickLaunchIconNames = BrowserManager.getDriver()
			.findElements(By.xpath("//div[@class='oxd-grid-3 orangehrm-quick-launch']//p"));

	List<WebElement> dashboardWidgetElements = BrowserManager.getDriver()
			.findElements(By.xpath("//div[@class='orangehrm-dashboard-widget-name']/p"));
	

	public DashboardPage() {
		
	}

	
	
	
	public List<String> getActualQuickLaunchItemsFromDashboard() {
		List<String> actualQuickLaunchItems = new ArrayList<String>();

		for (WebElement iconName : quickLaunchIconNames) {
			actualQuickLaunchItems.add(iconName.getText());
		}

		return actualQuickLaunchItems;
	}

	public List<String> getActualWidgetsOnDashboard() {
		List<String> actualWidgetsPresent = new ArrayList<String>();

		for (WebElement widget : dashboardWidgetElements) {
			actualWidgetsPresent.add(widget.getText());
		}

		return actualWidgetsPresent;
	}

	public <T> boolean verifyLists(List<T> expectedList, List<T> actualList) {
		boolean isEqual = true;
		isEqual = new HashSet<>(expectedList).equals(new HashSet<>(actualList));
		if (!isEqual) {
			Reporter.info("expected " + expectedList + "and actual List" + actualList + " are NOT SAME");
		} else
			Reporter.info("expected " + expectedList + "and actual List" + actualList + " SAME");

		return isEqual;

	}

}
