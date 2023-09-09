package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pagelocator.DashboardPage;
import automation.pagelocator.LoginPageFactory;

public class LoginTestFactory extends CommonBase{

	@BeforeTest
	@Parameters("testNGBrowser")
	public void openApplication(String browser)
	{
		setupDriver(browser);
		driver.get(AccountConstant.webURL);
	}
	
	
	@Test
	public void loginSuccessfully() {
		LoginPageFactory factory = new LoginPageFactory(driver);
		factory.LoginFunctionFactory("admin@demo.com", "riseDemo");
		DashboardPage dashboard = new DashboardPage(driver);
		WebElement expectfield = driver.findElement(dashboard.dashBoardTest);
	    assertTrue(expectfield.isDisplayed());
	}
}
