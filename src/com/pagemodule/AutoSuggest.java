package com.pagemodule;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.utility.DriverBase;
import com.utility.Logger;

/**
 * @author VikramSingh Rajput
 */
public class AutoSuggest extends DriverBase {

	protected JavascriptExecutor js = null;

	public AutoSuggest() {
		super();
	}

	/**
	 * @throws Exception
	 * @param{searchKeayword,destination}
	 */
	public void enterDestination(String searchKeyword, String destination) throws Exception {
		// code to enter search keyword of destination
		driver.findElement(objectMap.getLocator("searchBox")).sendKeys(searchKeyword);
		// code to press down arrow
		driver.findElement(objectMap.getLocator("searchBox")).sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		// code to use javascript executator in order to extract hidden properties.
		js = (JavascriptExecutor) driver;
		// Script that need to be execute.
		String scriptToExtractHiddenValue = "return document.getElementById(\"fromPlaceName\").value;";
		// String after extracting value from hidden text box
		String expectedDestinationValue = (String) js.executeScript(scriptToExtractHiddenValue);
		int tempCount = 0;
		while (!expectedDestinationValue.equalsIgnoreCase(destination)) {
			tempCount++;
			driver.findElement(objectMap.getLocator("searchBox")).sendKeys(Keys.DOWN);
			expectedDestinationValue = (String) js.executeScript(scriptToExtractHiddenValue);
			Logger.info("Expected destiantion : " + expectedDestinationValue);
			if (tempCount > 10) break;
		}
		if (tempCount > 10) Logger.info("Expected destination not found");
	}

}
