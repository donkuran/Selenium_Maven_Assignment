package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass{
	
	@Test
	public void LoginSuccessTest() {
		
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
		
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal, PasswordVal);
		
		WebElement ProductsTitle = driver.findElement(By.xpath ("//*[contains(text(),'Products')]"));
		
		String ActualMsg = ProductsTitle.getText();
		String ExpMsg = "PRODUCTS";
		
		Assert.assertEquals(ActualMsg, ExpMsg);
		
	}	
	
	@Test
	public void LoginFailureTest() {
		
		String UserNameVal = sheet.getRow(2).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(2).getCell(1).getStringCellValue();
		
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal, PasswordVal);
		
		WebElement ErrorMsg = driver.findElement(By.xpath("//div[@id='login_button_container']//h3"));
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "Epic sadface: Username and password do not match any user in this service";
		
		Assert.assertEquals(ActualMsg, ExpMsg);
		
	}	
	
}
