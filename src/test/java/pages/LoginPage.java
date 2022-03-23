package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testcases.BaseClass;

public class LoginPage {
	
	WebDriver driver = BaseClass.driver;
	
	@FindBy(id = "user-name")
	WebElement UserName;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(id = "login-button")
	WebElement LoginBtn;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void LoginFunction(String UserNameVal, String PasswordVal) {

		UserName.sendKeys(UserNameVal);
		
		Password.sendKeys(PasswordVal);
				
		LoginBtn.click();

	}


}
