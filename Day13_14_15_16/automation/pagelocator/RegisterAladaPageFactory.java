package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAladaPageFactory {
	@FindBy(id="txtFirstname")
	private WebElement txtName;
	@FindBy(id="txtEmail")
	private WebElement txtMail;
	@FindBy(id="txtCEmail")
	private WebElement txtCmail;
	@FindBy(id="txtPassword")
	private WebElement txtPass;
	@FindBy(id="txtCPassword")
	private WebElement txtCPass;
	@FindBy(id="txtPhone")
	private WebElement txtPhone;
	@FindBy (xpath="//button[@type='submit']")
	private WebElement btnLogin;
	@FindBy (xpath="//a[text()='Đăng Nhập']/..")
	public WebElement btnDangNhap;
	
	private WebDriver driver;

	public RegisterAladaPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void RegisterAladaFactory(String name, String mail, String password, String phone) {
		txtName.sendKeys(name);
		txtMail.sendKeys(mail);
		txtCmail.sendKeys(mail);
		txtPass.sendKeys(password);
		txtCPass.sendKeys(password);
		txtPhone.sendKeys(phone);
		btnLogin.click();
	}
}
