package automation.pagelocator;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	@FindBy(id="email")
	private WebElement txtemail;
	
	@FindBy(id="password")
	private WebElement txtpassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnLogin;
	private WebDriver driver;
	public LoginPageFactory(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}
	public void LoginFunction(String email, String password) {
		txtemail.clear();
		txtemail.sendKeys(email);
		txtpassword.clear();
		txtpassword.sendKeys(password);
		btnLogin.click();
	}
	
	
	
}
