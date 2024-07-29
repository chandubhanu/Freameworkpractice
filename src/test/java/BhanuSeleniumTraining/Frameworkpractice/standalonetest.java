package BhanuSeleniumTraining.Frameworkpractice;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BhanuSeleniumTraining.PageObjects.CartPage;
import BhanuSeleniumTraining.PageObjects.CheckoutPage;
import BhanuSeleniumTraining.PageObjects.LandingPage;
import BhanuSeleniumTraining.PageObjects.ProductCatelouge;
import BhanuSeleniumTraining.tests.Basetest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class standalonetest extends Basetest{
@Test
	public void submitOrder() throws IOException {
		// TODO Auto-generated method stub
		String item="ADIDAS ORIGINAL";
		
ProductCatelouge productcatelouge=landingpage.loginapp("chandubhanu@gmail.com", "Bhanu@03");
productcatelouge.addProductToCart(item);
CartPage cartpage=productcatelouge.goToCartPage();
Boolean Match=cartpage.VerifyProductDisplay(item);
Assert.assertTrue(Match);
CheckoutPage checkoutpage=cartpage.gotTOCheckout();
checkoutpage.selectCountry(item);
checkoutpage.submitOrder();
//String confirmmessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
//	Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}



}
