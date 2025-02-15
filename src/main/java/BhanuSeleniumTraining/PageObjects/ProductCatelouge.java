package BhanuSeleniumTraining.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatelouge extends abstractcomponents{
	
		WebDriver driver;
		public ProductCatelouge(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
			 }
		
		@FindBy(css=".mb-3")
		List<WebElement> products;
		
		@FindBy(css=".ng-animating")
		WebElement spinner;
By productsby=By.cssSelector(".mb-3");
By addToCart=By.cssSelector(".card-body button:last-of-type");
By toastmessage=By.cssSelector("#toast-container");	
		public List<WebElement> getProductList()
		{
			
			waitForElemetnToAppear(productsby);
			return products;
		}
		
		public WebElement getProductByName(String ProductName) {
			WebElement prod= getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
			
return prod;
		}

		public void addProductToCart(String ProductName) {
			WebElement prod=getProductByName(ProductName);
			prod.findElement(addToCart).click();
			waitForElemetnToAppear(toastmessage);
			waitForElementToDisappear(spinner);
			
		}
}
