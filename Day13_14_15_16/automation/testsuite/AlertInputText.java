package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class AlertInputText extends CommonBase {
	@BeforeMethod
	public void openPage() {
		driver = initChromeDriver("https://demo.automationtesting.in/Alerts.html");
	}
		
	@Test
	public void TestAlert() {
		driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
		pause(2000);
		driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']")).click();
		pause(2000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Automation test");
		alert.accept();
		WebElement element = getElementPresentDOM(By.id("demo1"));
		String actualText = element.getText();
		assertEquals(actualText, "Hello Automation test How are you today");
	}
}
