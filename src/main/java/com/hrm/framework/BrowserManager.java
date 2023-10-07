/**
 * 
 */
package com.hrm.framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v113.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.hrm.helpers.ExcelHelper;
import com.hrm.helpers.PropertiesHelper;
import com.hrm.reporting.Reporter;

/**
 * @author DragonWarrior-PC
 *
 */
public class BrowserManager {
	// Singleton Pattern --> There should be one and only one instance of any Object

	WebDriver driver;
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
		}

		if (browserType.equals("chrome")) {
			if (isRemote) {
				// For Remote Machine Execution
				startRemoteDriver(browserType);
			} else {
				localWebDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			}
		}

		Reporter.info(browserType + "  broswer Type is not available ");

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
		return localWebDriver.get();
	}

	public static void quitBrowser() {
		getDriver().quit();
	}
}
