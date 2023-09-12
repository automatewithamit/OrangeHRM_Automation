/**
 * 
 */
package com.hrm.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
		System.out.println("Starting Browser.....");
		String browserType = configProperty.getProperty("browserType").toLowerCase();

		switch (browserType) {
		case "edge":
			driver = new EdgeDriver(optionsManager.getEdgeOptions());
		case "chrome":
			driver = new ChromeDriver(optionsManager.getChromeOptions());
		default:
			System.out.println(browserType + "  broswer Type is not available ");
		}
		driver.manage().window().maximize();
	}

}
