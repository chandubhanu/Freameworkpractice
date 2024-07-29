package BhanuSeleniumTraining.Frameworkpractice;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BhanuSeleniumTraining.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Submitorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String item = "ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
//LandingPage landingpage=new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("chandubhanu@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Bhanu@03");
		driver.findElement(By.id("login")).click();
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='card-body']"));
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.tagName("h5")).getText().equals("ADIDAS ORIGINAL"))
				.findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		// div[@aria-label='Product Added To Cart']

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		try {
		    // Wait for overlay to disappear
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));

		    // Scroll to the button
		    WebElement cartButton = driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButton);

		    // Wait for the button to be clickable
		    wait.until(ExpectedConditions.elementToBeClickable(cartButton));

		    // Click the button
		    cartButton.click();
		} catch (Exception e) {
		    System.out.println("The Exception Message is" + e.getMessage());
		}

		List<WebElement> order = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean orderitem = order.stream().anyMatch(s -> s.getText().equalsIgnoreCase(item));
		Assert.assertTrue(orderitem);
		driver.findElement(By.cssSelector(".totalRow button")).click();
//Actions a=new Actions(driver);
//a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("India");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));
//System.out.println(addButton.getText());
		addButton.click();
		String confirmmessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

}
