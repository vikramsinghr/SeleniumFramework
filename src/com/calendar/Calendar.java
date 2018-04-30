package com.calendar;

import com.utility.DriverBase;
import com.utility.Logger;

public class Calendar extends DriverBase {

	// Default constructor to initialize driver.
	public Calendar(){
		super();
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
