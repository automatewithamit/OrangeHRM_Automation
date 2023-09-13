/**
 * 
 */
package com.hrm.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.hrm.helpers.PropertiesHelper;

/**
 * @author DragonWarrior-PC
 *
 */
public class BrowserManager {

	public static WebDriver driver;

	OptionsManager optionsManager = new OptionsManager();
	PropertiesHelper configProperty = new PropertiesHelper("//resources//config.properties");

	public void startBrowser() {

		String browserType = configProperty.getProperty("browserType").toLowerCase();
		System.out.println("Starting Browser....." + browserType);
		if (browserType.equals("edge")) {

			driver = new EdgeDriver(optionsManager.getEdgeOptions());
		} else {
			// For Remote Machine Execution
			startRemoteDriver(browserType);
		}
		if (browserType.equals("chrome")) {

			driver = new ChromeDriver(optionsManager.getChromeOptions());
		} else {
			startRemoteDriver(browserType);
		}

		System.out.println(browserType + "  broswer Type is not available ");

		driver.manage().window().maximize();
	}

	public void startRemoteDriver(String browserType) {

	}

}
