package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Window.html");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//button[text() = 'Open Home Page']")).click();

		// to handle window using getWindowHandles() and it return set, set remove the
		// duplicate tabs/window
		Set<String> handleTheNewWindow = driver.getWindowHandles();

		// created list to use the get method and passing the set into it
		List<String> storeTheSet = new ArrayList<String>(handleTheNewWindow);

		// switching to the window
		driver.switchTo().window(storeTheSet.get(1));

		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//img[@class = 'wp-categories-icon svg-image'])[11]")).click();

		// to handle window using getWindowHandles() and it return set, set remove the
		// duplicate tabs/window
		Set<String> handleTheNewWindow1 = driver.getWindowHandles();

		// created list to use the get method and passing the set into it
		List<String> storeTheSet1 = new ArrayList<String>(handleTheNewWindow1);

		// switching to the window
		driver.switchTo().window(storeTheSet1.get(1));

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();

		// to handle window using getWindowHandles() and it return set, set remove the
		// duplicate tabs/window
		Set<String> handleTheNewWindow2 = driver.getWindowHandles();

		// created list to use the get method and passing the set into it
		List<String> storeTheSet2 = new ArrayList<String>(handleTheNewWindow2);

		// switching to the window
		driver.switchTo().window(storeTheSet2.get(2));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[text()='Go to Home Page']")).click();

		// closing all the opened windows
		driver.quit();
	}
}
