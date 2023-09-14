/**
 * 
 */
package com.hrm.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.hrm.helpers.PropertiesHelper;

/**
 * @author DragonWarrior-PC
 *
 */
public class BrowserManager {
	//Singleton Pattern --> There should be one and only one instance of any Object
	

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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void startRemoteDriver(String browserType) {

	}

}
