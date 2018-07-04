package com.demoaut.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstName")
	private WebElement firstName;

	@FindBy(name = "lastName")
	private WebElement lastName;

	@FindBy(id = "userName")
	private WebElement userName;

	@FindBy(name = "phone")
	private WebElement phone;

	@FindBy(name = "address1")
	private WebElement address1;

	@FindBy(name = "address2")
	private WebElement address2;

	@FindBy(name = "city")
	private WebElement city;

	@FindBy(name = "state")
	private WebElement state;

	@FindBy(name = "postalCode")
	private WebElement postalCode;

	@FindBy(name = "country")
	private WebElement country;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(name = "confirmPassword")
	private WebElement confirmPassword;

	@FindBy(name = "register")
	private WebElement submitBtn;

	//function will fill register user page will given info
	public void registerUser(String fname,String lname,String uname,String phone,String add1,String add2,String city,String state,String postal,String email,String pwd,String confirmPwd,String country) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		userName.sendKeys(uname);
		this.phone.sendKeys(phone);
		address1.sendKeys(add1);
		address2.sendKeys(add2);
		this.city.sendKeys(city);
		this.state.sendKeys(state);
		postalCode.sendKeys(postal);
		this.email.sendKeys(email);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(confirmPwd);
		Select countryDrpdown = new Select(this.country);
		countryDrpdown.selectByVisibleText(country);
		submitBtn.click();
	}

}
