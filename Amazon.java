package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Load the URL https://www.amazon.in/
		driver.get("https://www.amazon.in/");

		// search as oneplus 9 pro
		driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

		// Get the price of the first product
		String priceOfTheFirstProduct = driver.findElement(By.xpath("//span[@class = 'a-price-whole']")).getText();
		System.out.println("Price: " + priceOfTheFirstProduct);

		// Print the number of customer ratings for the first displayed product
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom'])[1]"))
				.click();
		String customerRating = driver
				.findElement(By.xpath("//span[@class='a-size-base a-color-secondary totalRatingCount']")).getText();
		System.out.println(customerRating);

		// Click the first text link of the first image
		driver.findElement(By.xpath("//span[@class = 'a-size-medium a-color-base a-text-normal']")).click();
		Set<String> setToHandleWindow = driver.getWindowHandles();
		List<String> listToStoreSet = new ArrayList<String>(setToHandleWindow);
		driver.switchTo().window(listToStoreSet.get(1));

		// Take a screen shot of the product displayed
		File takeScreenshot = driver.getScreenshotAs(OutputType.FILE);
		File folderAndName = new File("./Amazon.png");
		FileUtils.copyFile(takeScreenshot, folderAndName);

		// Click 'Add to Cart' button
		driver.findElement(By.xpath("//input[@title = 'Add to Shopping Cart']")).click();

		// Get the cart subtotal and verify if it is correct
		driver.findElement(By.xpath(
				"//span[@class='a-button-inner']/input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']"))
				.click();
		String subtotalOfCart = driver
				.findElement(By.xpath("//span[@class = 'a-size-medium a-color-base sc-price sc-white-space-nowrap']"))
				.getText();
		System.out.println("Subtotal:" + subtotalOfCart);

		// close the browser
		driver.quit();
	}

}
