package com.testsuite;
/**
 * @author VikramSingh Rajput
 * Test suite containing all test cases
 * */
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.calendar.Calendar;
import com.pagemodule.AutoSuggest;
import com.utility.DriverBase;
import com.utility.Logger;

public class TestSuite extends DriverBase {
	WebDriver driver = null;
	@Test(priority = 0, enabled = false)
	public void browserLaunch() throws Exception {
		WebDriver driver = setDriver(objectMap.getData("browserName").toUpperCase());
		driver.get(objectMap.getData("browserURL"));
		Logger.info("Browser launched");
		driver.findElement(objectMap.getLocator("searchTextbox")).sendKeys("Moto");
	}

	// Test case to select departure date and month
	@Test(priority = 1, enabled = false)
	public void calendarDateSelection() throws Exception {
		driver = setDriver(objectMap.getData("browserName").toUpperCase());
		driver.get(objectMap.getData("browserURL"));
		Logger.info("Browser launched");
		Calendar calendar = new Calendar();
		calendar.setCalendar(objectMap.getData("month").toUpperCase(), objectMap.getData("date"));
	}
	//Using page object model.
	@Test(priority = 1, enabled = true)
	public void calendarDateSelectionPageObject() throws Exception {
		driver = setDriver(objectMap.getData("browserName").toUpperCase());
		driver.get(objectMap.getData("browserURL"));
		Logger.info("Browser launched");
		Calendar calendar = new Calendar();
		calendar.setCalendar(objectMap.getData("month").toUpperCase(), objectMap.getData("date"));
	}
	
	//Test case to automate AJAX using selenium
	@Test(priority = 2, enabled = false)
	public void ajaxPlaceSelection() throws Exception {
		driver = setDriver(objectMap.getData("browserName").toUpperCase());
		driver.get(objectMap.getData("browserURL"));
		Logger.info("Browser launched");
		AutoSuggest autoSuggest = new AutoSuggest();
		autoSuggest.enterDestination(objectMap.getData("searchKeyword"), objectMap.getData("destination"));
		
	}
}
