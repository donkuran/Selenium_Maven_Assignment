package testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;

public class BaseClass {
	
	public static WebDriver driver;
	
	XSSFWorkbook wbook;
    XSSFSheet sheet;
    
    public static ExtentReports report;
    
    @BeforeTest
    public void DataSetUp() throws IOException {
    	
    	FileInputStream fis = new FileInputStream("userdata.xlsx");
    	
    	wbook = new XSSFWorkbook(fis);
    	sheet = wbook.getSheet("credentials");
    	
    	report = new ExtentReports("ExtentReport.html");
    }
    
    @AfterTest
    public void DataTeardown() throws IOException {
    	
    	wbook.close();
    	report.flush();
    	report.close();
    }

	@BeforeMethod
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();

		driver.get("https://www.saucedemo.com/");	
		
		//Maximize window
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	
}
