package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightResultPageFactory {
	private WebDriver driver;
	@FindBy (xpath = "//h2[text()='Flight Search Result']")
	public WebElement titleResult;
	public FlightResultPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

}
