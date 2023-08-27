package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DanhSachKhoaHoc {
private WebDriver driver;
@FindBy (xpath = "//div[@id='thongbao' and contains(text(),'Chúc mừng bạn đã đăng ký thành công')]")
public WebElement passMessage;

public DanhSachKhoaHoc(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

}
