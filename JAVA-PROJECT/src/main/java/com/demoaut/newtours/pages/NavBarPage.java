package com.demoaut.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBarPage {
	WebDriver driver;

	public NavBarPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//below are the common link of the newtours which are made public and can be use directly
	@FindBy(linkText = "SIGN-ON")
	public WebElement signOnLink;

	@FindBy(linkText = "REGISTER")
	public WebElement registerLink;

	@FindBy(linkText = "SUPPORT")
	public WebElement supportLink;

	@FindBy(linkText = "CONTACT")
	public WebElement contactLink;

	@FindBy(linkText = "SIGN-OFF")
	public WebElement signOffLink;

	@FindBy(linkText = "ITINERARY")
	public WebElement itineraryLink;

	@FindBy(linkText = "PROFILE")
	public WebElement profileLink;

}
