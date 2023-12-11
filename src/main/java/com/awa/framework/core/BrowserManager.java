/**
 * 
 */
package com.awa.framework.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import com.awa.framework.helpers.ExcelHelper;
import com.awa.framework.helpers.PropertiesHelper;
import com.awa.framework.reporting.Reporter;

/**
 * @author DragonWarrior-PC
 *
 */
public class BrowserManager {
	// Singleton Pattern --> There should be one and only one instance of any Object

	// WebDriver driver;
	private static ThreadLocal<WebDriver> localWebDriver = new ThreadLocal<WebDriver>();

	OptionsManager optionsManager = new OptionsManager();
	PropertiesHelper configProperty = new PropertiesHelper("//resources//config.properties");
	PropertiesHelper urlHelper = new PropertiesHelper("//resources//url.properties");
	ExcelHelper projectData = new ExcelHelper("\\src\\test\\resources\\com\\hrm\\data\\ProjectData.xlsx");

	public String getSheetName() {
		String sheetName = "";
		String environmentName = configProperty.getProperty("environmentName").toLowerCase();

		switch (environmentName) {
		case "qa":
			sheetName = "QA";
			break;
		case "dev":
			sheetName = "DEV";
			break;
		case "release":
			sheetName = "RELEASE";
			break;
		case "prod":
			sheetName = "PRODUCTION";
			break;

		default:
			Reporter.info("Incorrect environment Name --> " + environmentName);
			break;
		}

		return sheetName;
	}

	public void startBrowser() {

//		if (getDriver() != null) {
//			return; // Exit the method if a driver instance already exists
//		}

		String browserType = "";

//		if (Boolean.parseBoolean(configProperty.getProperty("readBrowserFromExcel").toLowerCase())) {
		browserType = projectData.read(getSheetName()).get("Browser").toLowerCase();
//		} else {
//			browserType = configProperty.getProperty("browserType").toLowerCase();
//		}

		boolean isRemote = Boolean.parseBoolean(configProperty.getProperty("isRemote").toLowerCase());

		Reporter.info("Starting Browser....." + browserType);

		if (browserType.equals("edge")) {
			if (isRemote) {
				startRemoteDriver(browserType);
			} else {
				localWebDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			}
		} else if (browserType.equals("chrome")) {
			if (isRemote) {
				// For Remote Machine Execution
				startRemoteDriver(browserType);
			} else {
				System.out.println("Starting Browser....." + browserType);
				WebDriver driver = new ChromeDriver(optionsManager.getChromeOptions());
				System.out.println(browserType.toUpperCase() + " Browser Started.");
				localWebDriver.set(driver);
			}
		} else {
			Reporter.info(browserType + "  broswer Type is not available ");
		}
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//getDriver().manage().deleteAllCookies();
		System.out.println("Session ID : " + ((RemoteWebDriver) getDriver()).getSessionId().toString());
	}

	public void startRemoteDriver(String browserType) {
		String remoteUrl = urlHelper.getProperty("hubURL");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if (browserType.equalsIgnoreCase("chrome")) {
			capabilities.setBrowserName("chrome");
			Reporter.info("############TEST CASE EXECUTION STARTED ON ==> ### " + browserType);
		} else if (browserType.equalsIgnoreCase("edge")) {
			capabilities.setBrowserName("MicrosoftEdge");
			Reporter.info("############TEST CASE EXECUTION STARTED ON ==> ### " + browserType);
		}
		try {
			localWebDriver.set(new RemoteWebDriver(new URL(remoteUrl), capabilities));
		} catch (MalformedURLException e) {
			Reporter.info("MalFormed Exception Occurred ");
		}
	}

	public static WebDriver getDriver() {
//		if (localWebDriver.get() == null) {
//			localWebDriver.set(new ChromeDriver());
//		}
//		return localWebDriver.get();
		WebDriver driver = localWebDriver.get();
		return driver;
	}

	public static void quitBrowser() {
		if (getDriver() != null) {
			getDriver().quit();
			System.out.println("Webdriver instance <b>" + getDriver().hashCode() + "</b> is getting terminated");
			// localWebDriver.remove();
		}
	}
}
