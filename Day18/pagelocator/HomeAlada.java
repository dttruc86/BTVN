package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeAlada {	
	private WebDriver driver;
	@FindBy (xpath = "//div[@class='avatar2']/img")
	public WebElement imgAvatar;
	@FindBy (xpath = "//a[text()='Chỉnh sửa thông tin']")
	private WebElement editInfo;
	@FindBy (xpath = "//a[text()='Thoát']")
	private WebElement singOut;
	
	
	public HomeAlada(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void acsessInfoPage() {
		imgAvatar.click();
		editInfo.click();
	}
	
	public void signOut() {
		imgAvatar.click();
		singOut.click();
	}
	

}
