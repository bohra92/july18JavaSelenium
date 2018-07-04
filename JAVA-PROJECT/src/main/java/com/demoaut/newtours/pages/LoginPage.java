package com.demoaut.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "userName")
	private WebElement userName;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(name = "login")
	private WebElement login;

	//function will login with given creds
	public void loginUser(String user, String pwd) {
		userName.clear();
		password.clear();
		userName.sendKeys(user);
		password.sendKeys(pwd);
		login.click();
	}

}
