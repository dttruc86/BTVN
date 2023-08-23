package automation.pagelocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
	public static By dashBoardTest =By.xpath("//*[text()='Dashboard']");
	private By userName = By.xpath("//span[@class='user-name ml10']");
	private By signOut = By.xpath("//a[text()=' Sign Out']");
	public By clientLink = By.xpath("//span[text()='Clients']");
	private WebDriver driver;
	public DashboardPage(WebDriver _driver) {
		this.driver = _driver;
	}
	public void LogoutFunction() {
		
		WebElement spanUserName = driver.findElement(userName);
		if (spanUserName.isDisplayed()) {
			spanUserName.click();
		}
		WebElement lnkSignOut = driver.findElement(signOut);
		if (lnkSignOut.isDisplayed()) {
			lnkSignOut.click();	
		}

			
	}
}
