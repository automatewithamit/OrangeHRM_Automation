package com.hrm.pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hrm.framework.BrowserManager;

public class OrangeDashboardPage {

	List<WebElement> quickLaunchIcons = BrowserManager.driver
			.findElements(By.xpath("//div[@class='oxd-grid-3 orangehrm-quick-launch']//p"));

	List<WebElement> dashboardWidgetElements = BrowserManager.driver
			.findElements(By.xpath("//div[@class='orangehrm-dashboard-widget-name']/p"));

	public OrangeDashboardPage() {

	}

	public boolean isQuickLaunchItemsDisplayed(List<String> quickLaunchItemsList) {
		boolean isDisplayed = true;

		return !isDisplayed;
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
			System.out.println("expected " + expectedList + "and actual List" + actualList + " are NOT SAME");
		}

		return isEqual;

	}

}
