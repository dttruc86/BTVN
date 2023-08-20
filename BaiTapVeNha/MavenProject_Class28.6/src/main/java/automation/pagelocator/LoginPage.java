package automation.pagelocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private By txtEmail = By.id("email");
	private By pass = By.id("password");
	private By buttonLogin = By.xpath("//button[text()='Sign in']");
	public By titleSignIn = By.xpath("//h2[text()='Sign in']");
	public By authenFail = By.xpath(" //div[normalize-space()='Authentication failed!' and @role='alert']");
	private WebDriver driver;
	public LoginPage(WebDriver _driver) {	
		this.driver = _driver;
	}
	
	public void LoginFunction(String email, String password){
		WebElement textEmail = driver.findElement(txtEmail);
		if (textEmail.isDisplayed()) {
			textEmail.clear();
			textEmail.sendKeys(email);
		}
		WebElement textPass = driver.findElement(pass);
		if (textPass.isDisplayed()) {
			textPass.clear();
			textPass.sendKeys(password);
		}
		WebElement bttnLogin = driver.findElement(buttonLogin);
		if(bttnLogin.isDisplayed()) {
			bttnLogin.click();
		}
	}
}
