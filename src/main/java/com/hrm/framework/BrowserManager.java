/**
 * 
 */
package com.hrm.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.hrm.helpers.PropertiesHelper;
import com.hrm.reporting.Reporter;

/**
 * @author DragonWarrior-PC
 *
 */
public class BrowserManager {
	// Singleton Pattern --> There should be one and only one instance of any Object

	private static ThreadLocal<WebDriver> localWebDriver = new ThreadLocal<WebDriver>();

	OptionsManager optionsManager = new OptionsManager();
	PropertiesHelper configProperty = new PropertiesHelper("//resources//config.properties");

	public void startBrowser() {

		String browserType = configProperty.getProperty("browserType").toLowerCase();
		Reporter.info("Starting Browser....." + browserType);

		if (browserType.equals("edge")) {

			localWebDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
		} else {
			// For Remote Machine Execution
			startRemoteDriver(browserType);
		}
		if (browserType.equals("chrome")) {

			localWebDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		} else {
			startRemoteDriver(browserType);
		}

		Reporter.info(browserType + "  broswer Type is not available ");

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void startRemoteDriver(String browserType) {

	}

	public static WebDriver getDriver() {
		return localWebDriver.get();
	}

	public static void quitBrowser() {
		getDriver().quit();
	}

}
