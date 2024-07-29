package BhanuSeleniumTraining.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import BhanuSeleniumTraining.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
public WebDriver driver;
public LandingPage landingpage;
	public WebDriver intializeDriver() throws IOException {
		
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\BhanuSeleniumTraining\\resources\\Globaldata.properties");
		prop.load(fis);
		String BrowserName=prop.getProperty("browser");
		if(BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			
		}
		else if(BrowserName.equalsIgnoreCase("edge")){
		WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
		
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		driver=intializeDriver();
		 landingpage=new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
	@AfterMethod
	public void quit() {
		driver.close();
	}
}
