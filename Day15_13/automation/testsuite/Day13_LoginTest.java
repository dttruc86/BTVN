package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pagelocator.DashboardPage;
import automation.pagelocator.LoginPage;

public class Day13_LoginTest extends CommonBase{
	@BeforeMethod
	public void openPage() {
		driver = initChromeDriver(AccountConstant.webURL);
	}
	
	@Test
	public void loginSuccessfuly() {
		LoginPage page = new LoginPage(driver);
	    page.LoginFunction("admin@demo.com", "riseDemo");
	    DashboardPage dashboard =new DashboardPage(driver);
	    WebElement expectfield = driver.findElement(dashboard.dashBoardTest);
	    assertTrue(expectfield.isDisplayed());
	};
	
	@Test
	public void loginFailErrorEmail() {
		LoginPage page = new LoginPage(driver);
	    page.LoginFunction("admin1@demo.com", "riseDemo");
	    WebElement expectfield = driver.findElement(page.authenFail);
	    assertTrue(expectfield.isDisplayed());
	};
	
	@Test
	public void loginFailErrorPassword() {
		LoginPage page = new LoginPage(driver);
	    page.LoginFunction("admin@demo.com", "risingDemo");
	    WebElement expectfield = driver.findElement(page.authenFail);
	    assertTrue(expectfield.isDisplayed());
	};
	
	@Test
	public void loginFailErrorEmail_Password() {
		LoginPage page = new LoginPage(driver);
	    page.LoginFunction("admin1@demo.com", "risingDemo");
	    WebElement expectfield = driver.findElement(page.authenFail);
	    assertTrue(expectfield.isDisplayed());
	};
	//Log out chay rieng 1 case thi pass, chay chung voi cac case login thi chi bi fail
	@Test
	public void logoutSuccessfuly() {
		LoginPage page = new LoginPage(driver);
	    page.LoginFunction("admin@demo.com", "riseDemo");
	    DashboardPage dashboard =new DashboardPage(driver);
	    WebElement expectfield = driver.findElement(dashboard.dashBoardTest);
	    assertTrue(expectfield.isDisplayed());
	    dashboard.LogoutFunction();
	    expectfield = driver.findElement(page.titleSignIn);
	    assertTrue(expectfield.isDisplayed());
	};
	//Chi chua close duoc Browser cho moi lan test
	//Open page slowly, chi phai set timeout 20s neu chay case rieng, 
	//timeout 60s de chay chung cac case la co binh thuong khong?
	@AfterMethod
	public void closeBrowserTest() {
		 quitDriver(driver);
	}
	

}
