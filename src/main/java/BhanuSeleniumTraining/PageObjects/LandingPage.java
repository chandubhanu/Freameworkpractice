package BhanuSeleniumTraining.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends abstractcomponents{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 }
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement passwordEle;
	@FindBy(name="login")
	WebElement submit;
	

	public ProductCatelouge loginapp(String email,String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatelouge productcatelouge=new ProductCatelouge(driver);
		return productcatelouge;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
}

