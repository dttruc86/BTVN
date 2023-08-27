package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInAladaFactory {
	private WebDriver driver;
	@FindBy (id="txtLoginUsername")
	private WebElement txtUsername;
	@FindBy (id="txtLoginPassword")
	private WebElement txtPass;
	@FindBy (xpath="//button[@type='submit']")
	private WebElement btnSUbmit;

	public LogInAladaFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void LogInAlada(String name, String pass) {
		txtUsername.sendKeys(name);
		txtPass.sendKeys(pass);
		btnSUbmit.click();	
	}
	

}
