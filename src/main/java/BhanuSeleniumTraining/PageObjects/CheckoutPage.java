package BhanuSeleniumTraining.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage extends abstractcomponents{
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 }
	@FindBy(css=".action__submit")
	WebElement submit;
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement selectIndia;
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	By results=By.cssSelector(".ta-item");
	public void selectCountry(String countryName) {
		Actions a=new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitForElemetnToAppear(results);
		selectIndia.click();
	}
	
	public void submitOrder() {
		submit.getText();
	}
	
}
