package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pagelocator.ClientPageFactory;
import automation.pagelocator.DashboardPage;
import automation.pagelocator.LoginPage;
import automation.pagelocator.LoginPageFactory;

public class Day15_ClientTestFactory extends CommonBase{
	@BeforeTest
	public void openApplication() {
		driver = initChromeDriver(AccountConstant.webURL);
	}
	@Test
	public void addClientSuccessfuly()throws InterruptedException {
		LoginPageFactory login = new LoginPageFactory(driver);
	    login.LoginFunctionFactory("admin@demo.com", "riseDemo");
	    DashboardPage dashboard =new DashboardPage(driver);
	    pause(4000);
	    WebElement expectfield = driver.findElement(dashboard.dashBoardTest);
	    assertTrue(expectfield.isDisplayed());
	    ClientPageFactory client = new ClientPageFactory(driver);
	    client.AddClient("New Company 20.8", "20.8 Street");
	};

}
