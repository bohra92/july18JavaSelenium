package com.demoaut.newtours.tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.demoaut.newtours.pages.LoginPage;
import com.demoaut.newtours.pages.NavBarPage;
import com.demoaut.newtours.pages.RegisterPage;
import com.demoaut.newtours.reporter.JyperionListener;
import com.demoaut.newtours.utility.ReadExcel;

@Listeners(JyperionListener.class)
public class RegisterUserTest extends BaseTest {
	

	@Test
	public void registerUserWithCorrectCreds() throws IOException {
		//read excel to fetch register data and login creds
		ReadExcel read = new ReadExcel();
		String userData[][]  = read.getLoginOrRegisterUserData();
		NavBarPage nav = new NavBarPage(driver);
		RegisterPage register = new RegisterPage(driver);
		LoginPage login = new LoginPage(driver);
		
		//filling register data
		nav.registerLink.click();
		register.registerUser(userData[1][1],userData[2][1],userData[3][1],userData[4][1],userData[5][1],userData[6][1],userData[7][1],userData[8][1],userData[9][1],userData[10][1],userData[11][1],userData[12][1],userData[13][1]);
		nav.signOffLink.click();
		
		//verify with right login creds 
		login.loginUser(userData[10][1], userData[11][1]);
		assertTrue(nav.signOffLink.isDisplayed());
	}

	@Test
	public void registerUserWithIncorrectCreds() throws IOException {
		ReadExcel read = new ReadExcel();
		String userData[][]  = read.getLoginOrRegisterUserData();
		NavBarPage nav = new NavBarPage(driver);
		LoginPage login = new LoginPage(driver);
		driver.get("http://newtours.demoaut.com");
		
		//verify with wrong login creds 
		login.loginUser(userData[16][0], userData[16][1]);
		assertTrue(nav.signOnLink.isDisplayed());
	}

}
