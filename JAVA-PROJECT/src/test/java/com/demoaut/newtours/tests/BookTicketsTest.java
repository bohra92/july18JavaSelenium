package com.demoaut.newtours.tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoaut.newtours.pages.BookFlight;
import com.demoaut.newtours.pages.FlightConfirmationPage;
import com.demoaut.newtours.pages.FlightFinderPage;
import com.demoaut.newtours.pages.LoginPage;
import com.demoaut.newtours.pages.SelectFlightPage;
import com.demoaut.newtours.reporter.JyperionListener;
import com.demoaut.newtours.utility.ReadExcel;

@Listeners(JyperionListener.class)
public class BookTicketsTest extends BaseTest {

	@Test
	public void registerUserWithCorrectCreds() throws IOException {
		//reading excel for getting login cred and flight data
		ReadExcel read = new ReadExcel();
		String userData[][] = read.getLoginOrRegisterUserData();
		String flightData[][] = read.getFlightData();
		
		//Login with right creds
		LoginPage login = new LoginPage(driver);
		login.loginUser(userData[10][1], userData[11][1]);
		
		//filling flight finder page will excel data
		FlightFinderPage flightFinderPage = new FlightFinderPage(driver);
		flightFinderPage.fillFlightFinderPage(flightData[1][1], flightData[4][1], flightData[5][1], flightData[6][1],
				flightData[7][1], flightData[8][1], flightData[9][1], flightData[10][1], flightData[11][1],
				flightData[12][1]);
		
		//filling select flight page
		SelectFlightPage selectFlightPage = new SelectFlightPage(driver);
		selectFlightPage.fillSelectFlightPage(flightData[15][1], flightData[16][1]);

		//filling book a flight
		BookFlight bookFlight = new BookFlight(driver);
		//verifying pop up message
		assertTrue(bookFlight.fillBookFlightAndVerifyPopUp(flightData[20][1], flightData[21][1], flightData[22][1], flightData[23][1], flightData[24][1], flightData[25][1], flightData[27][1] , flightData[28][1]));
		
		//filling flight confirmation page
		FlightConfirmationPage confirm = new FlightConfirmationPage(driver);
		//verifying sub-title of flight confirmation page
		assertTrue(confirm.verifyConfirmationMsg(flightData[31][1].trim()));
		//verifying departure flight
		assertTrue(confirm.verifyDepartFlight(flightData[32][1]));
		confirm.getBackToFlightPage();
	}

}