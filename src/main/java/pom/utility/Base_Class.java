package pom.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	
	public static WebDriver driver;
	public static Config_Data_Provider Config;
	public static Exel_Data_Provider excel;
	@BeforeSuite
	public void BS() throws Exception {
	Config=new Config_Data_Provider();
	excel=new Exel_Data_Provider();
	}
	@Parameters({"BrowserName"})
	@BeforeMethod
	public void SetUp(String BrowserName) {
		if(BrowserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(BrowserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.get(Config.getQAENV_01());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
