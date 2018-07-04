package com.demoaut.newtours.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookFlight {

	WebDriver driver;

	public BookFlight(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "passFirst0")
	private WebElement firstName;

	@FindBy(name = "passLast0")
	private WebElement lastName;

	@FindBy(name = "pass.0.meal")
	private WebElement selectMeal;

	@FindBy(name = "creditCard")
	private WebElement selectCreditCard;

	@FindBy(name = "cc_exp_dt_mn")
	private WebElement selectCCMonth;

	@FindBy(name = "cc_exp_dt_yr")
	private WebElement selectCCYear;

	@FindBy(name = "ticketLess")
	private WebElement checkTicketless;

	@FindBy(name = "delCountry")
	private WebElement selectDeliveryCountry;

	@FindBy(name = "buyFlights")
	private WebElement continueBtn;

	@FindBy(name = "@/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[3]/font")
	private WebElement depFlightPrice;

	// This function will fill book flight page form and will verify pop up
	// message
	public boolean fillBookFlightAndVerifyPopUp(String firstName, String lastName, String meal, String cc,
			String ccMonth, String ccYear, String country, String popUpMsg) {
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		Select mealSelect = new Select(selectMeal);
		mealSelect.selectByVisibleText(meal);
		Select CC = new Select(selectCreditCard);
		CC.selectByVisibleText(cc);
		Select month = new Select(selectCCMonth);
		month.selectByVisibleText(ccMonth);
		Select year = new Select(selectCCYear);
		year.selectByVisibleText(ccYear);
		checkTicketless.click();
		Select billCountry = new Select(selectDeliveryCountry);
		billCountry.selectByVisibleText(country);

		// checking for alert message
		Alert alertMsg = driver.switchTo().alert();
		String msg = alertMsg.getText();
		alertMsg.accept();
		continueBtn.click();
		return popUpMsg.equals(msg);
	}

	// This function will verify departure flight price
	public boolean verifyFlightPrice(String price) {
		return depFlightPrice.getText().equals(price);
	}
}
