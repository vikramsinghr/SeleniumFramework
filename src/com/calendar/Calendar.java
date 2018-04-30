package com.calendar;

/**
 * @author VikramSingh Rajput
 * Calendar class to select date based on month and date.
 * Arguments passed month and date.
 * Logic is to first loop for month and later using for loop to iterate for date.
 * */
import org.openqa.selenium.WebDriver;

import com.utility.DriverBase;
import com.utility.Logger;

public class Calendar extends DriverBase {
	static WebDriver driver = null;

	// Default constructor to initialize driver.
	public Calendar() throws Exception {
		driver = setDriver(objectMap.getData("browserName").toUpperCase());
		driver.get(objectMap.getData("browserURL"));
	}

	/**
	 * @param {month
	 *            , date}
	 */
	public void setCalendar(String month, String date) throws Exception {
		driver.findElement(objectMap.getLocator("depart")).click();
		Logger.debug("Month passed : " + month);
		// Code to iterate for month selection
		while (!driver.findElement(objectMap.getLocator("monthSelection")).getText().contains(month)) {
			driver.findElement(objectMap.getLocator("nextMonth")).click();
		}
		int count = driver.findElements(objectMap.getLocator("dateSelection")).size();
		Logger.debug("Count : " + count);
		// code to iterate for date selection
		for (int i = 0; i < count; i++) {
			String selectDate = driver.findElements(objectMap.getLocator("dateSelection")).get(i).getText();
			if (selectDate.equalsIgnoreCase(date)) {
				driver.findElements(objectMap.getLocator("dateSelection")).get(i).click();
				break;
			}
		}
	}
}
