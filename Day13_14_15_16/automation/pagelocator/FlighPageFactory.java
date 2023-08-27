package automation.pagelocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlighPageFactory {
	private WebDriver driver;
	@FindBy(xpath="//div[contains(@class,'active')]//div[contains(@class,'active')]//label[text()='Flying from']/following-sibling::div/input")
	private WebElement from;
	@FindBy(xpath="//div[contains(@class,'active')]//div[contains(@class,'active')]//label[text()='Flying to']/following-sibling::div/input")
	private WebElement to;
	@FindBy (xpath="//div[contains(@class,'active')]//div[contains(@class,'active')]//label[contains(text(),'Departing')]/following-sibling::div/input")
	private WebElement departing;
	@FindBy (xpath="//div[contains(@class,'active')]//div[contains(@class,'active')]//label[text()='Passengers']/following-sibling::div//span")
	private WebElement passengers;
	@FindBy (xpath="//div[contains(@class,'active')]//div[contains(@class,'active')]//label[text()='Adults']/following-sibling::div/input")
	private WebElement adults;
	@FindBy (xpath="//div[contains(@class,'active')]//div[contains(@class,'active')]//label[text()='Adults']/following-sibling::div//i[@class='la la-minus']")
	private WebElement adultsMinus;
	@FindBy (xpath="//div[contains(@class,'active')]//div[contains(@class,'active')]//label[text()='Children']/following-sibling::div//i[@class='la la-plus']")
	private WebElement childrenPlus;
	@FindBy (xpath="//div[contains(@class,'active')]//div[contains(@class,'active')]//button[@title='Economy']")
	private WebElement coach;
	@FindBy (xpath="//div[contains(@class,'active')]//div[contains(@class,'active')]//a/span[text()='Business']")
	private WebElement coachBusiness;
	
	@FindBy (xpath="//div[contains(@class,'active')]//div[contains(@class,'active')]//a[text()='Search Now']")
	private WebElement searchNow;

	public FlighPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
public void SearchOneWayFlight(String fromLocation,String toLocation, String departion, String numAdult) throws InterruptedException {
	from.sendKeys(fromLocation);
	to.sendKeys(toLocation);
	Thread.sleep(4000);
	((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly');",departing);
	departing.clear();
	departing.sendKeys(departion);
	passengers.click();
	adults.sendKeys(numAdult);
	adultsMinus.click();
	childrenPlus.click();
	coach.click();
	coachBusiness.click();	
	searchNow.click();
		
	}
	
	

}
