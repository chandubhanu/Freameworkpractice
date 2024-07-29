package BhanuSeleniumTraining.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abstractcomponents {
	WebDriver driver;
	
	public abstractcomponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(css="[routerlink*='cart']")
WebElement cart;
@FindBy(css="[routerlink*='MyOrders']")
WebElement Orders;

	public void waitForElemetnToAppear(By findBy) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForElementToBeClicked(WebElement cart) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(cart));
	} 
	public OrderPage goToOrdersPage() {
		waitForElementToBeClicked(Orders);
		Orders.click();
		OrderPage orderpage=new OrderPage(driver);
	return orderpage;
	}
	 
	public CartPage goToCartPage() {
		waitForElementToBeClicked(cart);
		cart.click();
		CartPage cartpage=new CartPage(driver);
	return cartpage;
	}
	
	public void waitForElementToDisappear(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
}


