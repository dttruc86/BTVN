package automation.pagelocator;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPageFactory {
	private WebDriver driver;
	@FindBy(xpath="//a[@title='Add client']")
	private WebElement btnAddClient;
	
	@FindBy(xpath="//label[text()='Person']")
	private WebElement checkBoxPerson;
	@FindBy(xpath="//input[@name='company_name']")
	private WebElement inputCompany;
	
	//xpath của Owner dropdownlist
	@FindBy(xpath="//div[@id='s2id_created_by']")
	private WebElement checkboxOwner;
	// Giá trị của từng Owner trong màn Add Client
	@FindBy(xpath="//div[text()='Richard Gray']")
	private WebElement ownerValue4;//Richard Gray
	@FindBy(id="address")
	private WebElement txtareaAddress;
	@FindBy(xpath="//label[text()='Client groups']/following-sibling::div")
	private WebElement clientGroups;
	@FindBy(xpath="(//li[@role='presentation'])[1]")
	private WebElement firstOption;
	@FindBy(xpath="(//li[@role='presentation'])[2]")
	private WebElement secondOption;
	@FindBy(xpath="//label[text()='Currency']/following-sibling::div")
	private WebElement selectCurrency;
	@FindBy(xpath="//label[text()='Labels']/following-sibling::div")
	private WebElement selectLabel;
	@FindBy(xpath="//input[@name='disable_online_payment']")
	private WebElement disableOnlinePayment;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement bttnSave;
	@FindBy(xpath="//a[text()='Clients']")
	private WebElement tabClients;
	@FindBy(xpath="//input[@placeholder='Search' and @type='search']")
	private WebElement inputSearch;
	@FindBy(xpath="//a[text()='New Company 20.8']")
	private WebElement resultSearch;
	
	
	
	public ClientPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void AddClient(String companyName, String companyAddress)throws InterruptedException {
		DashboardPage dashboard = new DashboardPage(driver);
		driver.findElement(dashboard.clientLink).click();
		btnAddClient.click();
		Thread.sleep(4000);
		inputCompany.sendKeys(companyName);
		checkboxOwner.click();
		Thread.sleep(4000);
		ownerValue4.click();
		Thread.sleep(4000);
		txtareaAddress.sendKeys(companyAddress);
		Thread.sleep(4000);
		clientGroups.click();
		Thread.sleep(4000);
		firstOption.click();
		Thread.sleep(4000);
		clientGroups.click();
		Thread.sleep(4000);
		secondOption.click();
		Thread.sleep(4000);
		selectCurrency.click();
		Thread.sleep(4000);
		firstOption.click();
		Thread.sleep(4000);
		selectLabel.click();
		Thread.sleep(4000);
		firstOption.click();
		Thread.sleep(4000);
		disableOnlinePayment.click();
		Thread.sleep(4000);
		bttnSave.click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabClients);
		Thread.sleep(4000);
		inputSearch.sendKeys(companyName);
		Thread.sleep(4000);
		assertTrue(resultSearch.isDisplayed());
		
		
	}
	
	
}
