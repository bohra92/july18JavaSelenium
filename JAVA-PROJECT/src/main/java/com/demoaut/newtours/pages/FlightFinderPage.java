package com.demoaut.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPage {

	WebDriver driver;

	public FlightFinderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='roundtrip']")
	private WebElement roundTripRadio;

	@FindBy(xpath = "//input[@value='oneway']")
	private WebElement oneWayRadio;

	@FindBy(name = "fromPort")
	private WebElement selectFromPort;

	@FindBy(name = "fromMonth")
	private WebElement selectFromMonth;

	@FindBy(name = "fromDay")
	private WebElement selectFromDay;

	@FindBy(name = "toPort")
	private WebElement selectToPort;

	@FindBy(name = "toMonth")
	private WebElement selectToMonth;

	@FindBy(name = "toDay")
	private WebElement selectToDay;

	@FindBy(xpath = "//input[@value='Coach']")
	private WebElement economySeatRadio;

	@FindBy(xpath = "//input[@value='Business']")
	private WebElement businessSeatRadio;

	@FindBy(xpath = "//input[@value='First']")
	private WebElement firstClassSeatRadio;

	@FindBy(name = "airline")
	private WebElement selectairline;

	@FindBy(name = "findFlights")
	private WebElement continueBtn;

	//This function will fill Flight finder page 
	public void fillFlightFinderPage(String flightType1, String flightType2, String deptLoc, String deptMonth,
			String deptDate, String arrLoc, String arrMonth, String arrDate, String servClass, String airline) {
		WebElement action = flightType1.equals("one way") ? oneWayRadio : roundTripRadio;
		action.click();
		continueBtn.click();
		driver.navigate().back();
		//appropriate action will be checked and performed 
		action = flightType2.equals("one way") ? oneWayRadio : roundTripRadio;
		action.click();
		Select depLoc = new Select(selectFromPort);
		depLoc.selectByVisibleText(deptLoc);
		Select depMonth = new Select(selectFromMonth);
		depMonth.selectByVisibleText(deptMonth);
		Select depDate = new Select(selectFromDay);
		depDate.selectByValue(deptDate);

		Select arvLoc = new Select(selectToPort);
		arvLoc.selectByVisibleText(arrLoc);
		Select arvMonth = new Select(selectToMonth);
		arvMonth.selectByVisibleText(arrMonth);
		Select arvDate = new Select(selectToDay);
		arvDate.selectByValue(arrDate);

		//logic for filling service class radio
		switch (servClass) {
		case "First class":
			firstClassSeatRadio.click();
			break;
		case "Economy":
			economySeatRadio.click();
			break;
		case "Business":
			businessSeatRadio.click();
			break;
		default:
			break;
		}

		Select selAirline = new Select(selectairline);
		selAirline.selectByVisibleText("Unified Airlines");
		continueBtn.click();

	}

}
