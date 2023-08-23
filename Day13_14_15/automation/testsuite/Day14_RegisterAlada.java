package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pagelocator.DanhSachKhoaHoc;
import automation.pagelocator.HomeAlada;
import automation.pagelocator.InfoPageFactory;
import automation.pagelocator.LogInAladaFactory;
import automation.pagelocator.RegisterAladaPageFactory;

public class Day14_RegisterAlada extends CommonBase{
	@BeforeMethod
	public void openPage() {
		driver = initChromeDriver(AccountConstant.webURLAlada);
	}
	
	@Test
	public void registerAladaSuccessfuly() {
		RegisterAladaPageFactory page = new RegisterAladaPageFactory(driver);
		LocalDateTime myObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		String email = myObj.format(myFormatObj)+"@test.com";
	    page.RegisterAladaFactory("Thanh Hoa", email, "12345678", "09012345678");
	    pause(4000);
	    DanhSachKhoaHoc danhSachPage = new DanhSachKhoaHoc(driver);
	    WebElement expectfield = danhSachPage.passMessage;
	    assertTrue(expectfield.isDisplayed());
	};
	
	@Test
	public void editPassword() throws InterruptedException {
		RegisterAladaPageFactory page = new RegisterAladaPageFactory(driver);
		page.btnDangNhap.click();
		LogInAladaFactory logInAladaPage = new LogInAladaFactory(driver);
		logInAladaPage.LogInAlada("23082023122558@test.com", "12345678");
		pause(4000);
		HomeAlada aladaPage = new HomeAlada(driver);
		aladaPage.acsessInfoPage();
		InfoPageFactory infoPage = new InfoPageFactory(driver);
		infoPage.SaveNewPassword("12345678", "87654321");
		Alert al= driver.switchTo().alert();
		String msg = al.getText();
		al.accept();
		assertEquals(msg, "Cập nhật mật khẩu mới thành công!");
		
	}
	
	@AfterMethod
	public void closeBrowserTest() {
		 quitDriver(driver);
	}
	

}
