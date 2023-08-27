package automation.pagelocator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InfoPageFactory {
	private WebDriver driver;
    @FindBy (id="txtpassword")
    private WebElement txtPass;
    @FindBy (id="txtnewpass")
    private WebElement txtNewPass;
    @FindBy (id="txtrenewpass")
    private WebElement txtReNewPass;
    @FindBy (xpath="//button[text()='Lưu mật khẩu mới']")
    private WebElement btnSavePass;
 
	public InfoPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SaveNewPassword (String oldPass, String newPass) throws InterruptedException  {
		txtPass.sendKeys(oldPass);
		txtNewPass.sendKeys(newPass);
		txtReNewPass.sendKeys(newPass);
		btnSavePass.click();
		Thread.sleep(4000);
	}
	

}
