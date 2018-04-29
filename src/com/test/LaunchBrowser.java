package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.utility.DriverBase;
import com.utility.Logger;

public class LaunchBrowser extends DriverBase {

	@Test(priority=0)
	public void browserLaunch() throws Exception {
		WebDriver driver = setDriver(objectMap.getData("browserName").toUpperCase());
		driver.get(objectMap.getData("browserURL"));
		Logger.info("Browser launched");
		driver.findElement(objectMap.getLocator("searchTextbox")).sendKeys("Moto");
	}
}
