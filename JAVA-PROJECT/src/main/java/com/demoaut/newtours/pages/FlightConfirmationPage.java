package com.demoaut.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightConfirmationPage {
	WebDriver driver;

	public FlightConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[contains(@src,'backtoflights')]")
	private WebElement continueBtn;

	//This function will verify the title on the confirmation page
	public boolean verifyConfirmationMsg(String confirmMsg) {
		return driver.getPageSource().contains(confirmMsg);
	}

	//This function will verify the name of departure flight
	public boolean verifyDepartFlight(String deptFlight) {
		return driver.getPageSource().contains(deptFlight);
	}

	//This function will click on back to flight button.
	public void getBackToFlightPage() {
		continueBtn.click();
	}
}
