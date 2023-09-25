package com.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hrm.webelements.Label;

public class PersonalDetailsPage extends BasePage {

	Label fullName = new Label(By.xpath("//div[@class='orangehrm-edit-employee-name']/h6"));

	public String getFullName() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fullName.locator));
		return fullName.getText();
	}
	public String isDisplayed() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fullName.locator));
		return fullName.getText();
	}
}
