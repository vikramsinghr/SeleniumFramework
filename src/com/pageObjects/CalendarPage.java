package com.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {

	public CalendarPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@mt-id='departDate']")
	public WebElement depart;
	@FindBy(xpath="//span[@class='ui-datepicker-month']")
	public WebElement monthSelection;
	@FindBy(xpath="//span[@class='ui-icon ui-icon-circle-triangle-e']")
	public WebElement nextMonth;
	@FindBy(xpath="//a[@class='ui-state-default']")
	public List<WebElement> dateSelection;

}
