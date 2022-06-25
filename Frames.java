package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Entering into frame 1
		WebElement switchToFrame1 = driver.findElement(By.xpath("//iframe[@id = 'frame1']"));
		// Switch to frame
		driver.switchTo().frame(switchToFrame1);
		// entering the Selenium - frames in Topic textbox
		driver.findElement(By.tagName("input")).sendKeys("Selenium - Frames");

		// Entering into frame 2
		WebElement switchToFrame2 = driver.findElement(By.xpath("//iframe[@id = 'frame3']"));
		// Switch to frame
		driver.switchTo().frame(switchToFrame2);
		// Selecting the checkbox
		driver.findElement(By.xpath("//input[@id = 'a']")).click();

		// Coming out from the parent window
		driver.switchTo().defaultContent();

		//// Entering into frame 3
		WebElement switchToFrame3 = driver.findElement(By.id("frame2"));
		// Switch to frame
		driver.switchTo().frame(switchToFrame3);
		// Selecting animals from the dropdown
		WebElement dropDown = driver.findElement(By.id("animals"));
		Select selectOption = new Select(dropDown);
		selectOption.selectByVisibleText("Baby Cat");
	}

}
