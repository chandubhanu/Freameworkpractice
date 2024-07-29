package BhanuSeleniumTraining.PageObjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrderPage extends abstractcomponents{
	WebDriver driver;
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 }

	
@FindBy(css=".cartSection h3")
List<WebElement> cartProducts;
@FindBy(css=".totalRow button")
WebElement checkoutele;

public Boolean VerifyOrderDisplay(String productName) {
	Boolean match=cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
	return match;
}


}

