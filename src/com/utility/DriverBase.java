package com.utility;
/**
 * @author VikramSingh Rajput
 * Base class to initialize driver.
 * */

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverBase {
	private static WebDriver driver = null;
	private static WebDriver result = null;
	public static ObjectMap objectMap = null;

	public static WebDriver setDriver(String browserName) {
		switch (browserName) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", Constants.chromePath);
			driver = new ChromeDriver();
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
	
	@BeforeSuite
	public static ObjectMap initialise() {
		objectMap = new ObjectMap(System.getProperty("user.dir")+Constants.objectMapPath);
		return objectMap;
	}
	
	
/*	@AfterSuite
	public static void terminate() {
		driver.close();
	}*/
	
}
