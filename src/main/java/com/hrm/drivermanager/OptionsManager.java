/**
 * 
 */
package com.hrm.drivermanager;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

/**
 * @author DragonWarrior-PC
 *
 */
public class OptionsManager {

	public ChromeOptions getChromeOptions() {
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		
		return options;
	}
	
	
	
	public EdgeOptions getEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		return options;
	}
}
