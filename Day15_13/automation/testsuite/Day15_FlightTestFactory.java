package automation.testsuite;

import static org.testng.Assert.assertTrue;


import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pagelocator.FlighPageFactory;
import automation.pagelocator.FlightResultPageFactory;

public class Day15_FlightTestFactory  extends CommonBase {
	@BeforeMethod
	public void openApplication() {
		driver = initChromeDriver(AccountConstant.webURLFlight);
	}
	
	@Test
	public void searchFlightSuccessfuly()throws InterruptedException {
		FlighPageFactory flight = new FlighPageFactory(driver);
	    flight.SearchOneWayFlight("Ho Chi Minh", "Da Lat", "01092024", "5");
	    FlightResultPageFactory resultPage = new FlightResultPageFactory(driver);
	    WebElement expectfield = resultPage.titleResult;
	    assertTrue(expectfield.isDisplayed());
	};
	@AfterMethod
	public void closeBrowserTest() {
		 quitDriver(driver);
	}
}
