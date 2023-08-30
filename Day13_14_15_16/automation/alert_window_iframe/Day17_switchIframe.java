package alert_window_iframe;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day17_switchIframe extends CommonBase{
	@BeforeTest
	public void openPage() {
		driver = initChromeDriver ("https://codestar.vn");
	}
	@Test
	public void openMessaenger() {
		//pause(10000);
		//driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='fb-root']//div[contains(@class,'fb_iframe_widget')]//iframe")));
		driver.switchTo().frame(getElementPresentDOM(By.xpath("//div[@id='fb-root']//div[contains(@class,'fb_iframe_widget')]//iframe")));
		click(By.xpath("//span[text()='Bắt đầu chat']/.."));
		click(By.xpath("//span[text()='Sử dụng Messenger']/.."));
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			System.out.println(window);
			if (!mainWindow.equals(window)) {
				driver.switchTo().window(window);
				WebElement expectfield = driver.findElement(By.xpath("//div[contains(text(),'Chat with CodeStar Academy')]"));
			    assertTrue(expectfield.isDisplayed());
			    driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		driver.switchTo().defaultContent();
		
	}
	@Test
	public void registerDocument() {
		driver.switchTo().frame(getElementPresentDOM(By.xpath("//h2[contains(normalize-space(),'Kỹ thuật lập trình sạch và đẹp')]/ancestor::div[@class='wpb_wrapper']//iframe")));
		type(By.name("account_name"),"test user");
		type(By.id("account_phone"),"09012345678");
		click(By.xpath("//button[text()='Đăng ký ngay']"));
		//WebElement expectfield = driver.findElement(By.xpath("//button[text()='Đăng ký ngay']"));
	    assertTrue(isElementPresent(By.xpath("//button[text()='Đăng ký ngay']")));
	    driver.switchTo().defaultContent();
	    driver.close();
	}
}
