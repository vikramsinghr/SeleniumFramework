package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {
	 Properties prop = null;
     
	    public ObjectMap (String strPath) {
	         
	        prop = new Properties();
	         
	        try {
	            FileInputStream fis = new FileInputStream(strPath);
	            prop.load(fis);
	            fis.close();
	        }catch (IOException e) {
	            Logger.error(e.getMessage());
	        }

}
		public String getData(String elementName) throws Exception {
			// Read value using the logical name as Key
			String data = prop.getProperty(elementName);
			return data;
		}
		
	    public By getLocator(String locatorElement) throws Exception {
	         
	        // retrieve the specified object from the object list
	        String locator = prop.getProperty(locatorElement);
	         
	        // extract the locator type and value from the object
	        String locatorType = locator.split(":")[0];
	        String locatorValue = locator.split(":")[1];
	         
	        // for testing and debugging purposes
	        Logger.info("Retrieving object of type '" + locatorType + "' and value '" + locatorValue + "' from the object map");
	         
	        // return a instance of the By class based on the type of the locator
	        // this By can be used by the browser object in the actual test
	        if(locatorType.toLowerCase().equals("id"))
	            return By.id(locatorValue);
	        else if(locatorType.toLowerCase().equals("name"))
	            return By.name(locatorValue);
	        else if((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
	            return By.className(locatorValue);
	        else if((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
	            return By.tagName(locatorValue);
	        else if((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
	            return By.linkText(locatorValue);
	        else if(locatorType.toLowerCase().equals("partiallinktext"))
	            return By.partialLinkText(locatorValue);
	        else if((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
	            return By.cssSelector(locatorValue);
	        else if(locatorType.toLowerCase().equals("xpath"))
	            return By.xpath(locatorValue);
	        else
	            throw new Exception("Unknown locator type '" + locatorType + "'");
	    }
}
