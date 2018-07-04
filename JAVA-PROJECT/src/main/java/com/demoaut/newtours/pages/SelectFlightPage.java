package com.demoaut.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlightPage {

	WebDriver driver;

	public SelectFlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[contains(@value,'Unified Airlines') and (@name='outFlight')]")
	private WebElement depunifiedAirlineRadio;

	@FindBy(xpath = "//input[contains(@value,'Blue Skies Airlines$760') and (@name='outFlight')]")
	private WebElement depblueSkies760Radio;

	@FindBy(xpath = "//input[contains(@value,'Blue Skies Airlines$761') and (@name='outFlight')]")
	private WebElement depblueSkies761Radio;

	@FindBy(xpath = "//input[contains(@value,'Pangea') and (@name='outFlight')]")
	private WebElement depPangeaAirlineRadio;

	@FindBy(xpath = "//input[contains(@value,'Unified Airlines') and (@name='inFlight')]")
	private WebElement retunifiedAirlineRadio;

	@FindBy(xpath = "//input[contains(@value,'Blue Skies Airlines$630') and (@name='inFlight')]")
	private WebElement retblueSkies760Radio;

	@FindBy(xpath = "//input[contains(@value,'Blue Skies Airlines$631') and (@name='inFlight')]")
	private WebElement retblueSkies761Radio;

	@FindBy(xpath = "//input[contains(@value,'Pangea') and (@name='inFlight')]")
	private WebElement retPangeaAirlineRadio;

	@FindBy(name = "reserveFlights")
	private WebElement continueBtn;

	//function will select appropriate departure and return flight
	public void fillSelectFlightPage(String depFlightName, String retFlightName) {

		//logic for filling departure flight radio
		switch (depFlightName) {
		case "Unified Airline":
			depunifiedAirlineRadio.click();
			break;
		case "Blue Skies 760":
			depblueSkies760Radio.click();
			break;
		case "Blue Skies 761":
			depblueSkies761Radio.click();
			break;
		case "Pangea Airline":
			depPangeaAirlineRadio.click();
			break;

		default:
			System.out.println(depFlightName + "flight not present");
			break;
		}

		//logic for filling return flight radio
		switch (retFlightName) {
		case "Unified Airline":
			retunifiedAirlineRadio.click();
			break;
		case "Blue Skies 630":
			retblueSkies760Radio.click();
			break;
		case "Blue Skies 631":
			retblueSkies761Radio.click();
			break;
		case "Pangea Airline":
			retPangeaAirlineRadio.click();
			break;

		default:
			System.out.println(retFlightName + "flight not present");
			break;
		}

		continueBtn.click();
	}
}
