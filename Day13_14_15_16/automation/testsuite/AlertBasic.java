package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class AlertBasic extends CommonBase {
	@BeforeMethod
	public void openPage() {
		driver = initChromeDriver("https://demo.guru99.com/test/delete_customer.php");
	}
		
	@Test
	public void TestAlert() {
		driver.findElement(By.name("cusid")).sendKeys("123456");
		driver.findElement(By.name("submit")).click();
		pause(2000);
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		assertEquals(alertMessage, "Do you really want to delete this Customer?");
		alert.accept();
		pause(4000);
		alert = driver.switchTo().alert();
		alertMessage = alert.getText();
		assertEquals(alertMessage, "Customer Successfully Delete!");
		alert.accept();
	}
}
