package com.utility;
/**
 * @author VikramSingh Rajput
 * Base class to initialize driver.
 * */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverBase {
	protected static WebDriver driver = null;
	private static WebDriver result = null;
	public static ObjectMap objectMap = null;

	//Code to select browser based on parameter passed
	/**
	 * @param{browserName}
	 * */
	public static WebDriver setDriver(String browserName) {
		switch (browserName) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", Constants.chromePath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications ");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			result = driver;
			return result;
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", Constants.firefoxPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			result = driver;
			return result;
		}
		return null;
	}

	//Code to  object map file 
	@BeforeSuite
	public static ObjectMap initialise() {
		objectMap = new ObjectMap(System.getProperty("user.dir") + Constants.objectMapPath);
		return objectMap;
	}

	@AfterSuite
	public static void terminate() {
		driver.close();
	}

}
