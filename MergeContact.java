package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");

		// Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.xpath("//a[contains(text(), 'CRM/SFA')]")).click();

		// Click on contacts Button
		driver.findElement(By.xpath("//a[text() = 'Contacts']")).click();

		// Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text() = 'Merge Contacts']")).click();

		// Click on Widget of From Contact
		driver.findElement(By.xpath("//img[@alt = 'Lookup']")).click();
		
		// to handle window using getWindowHandles() and it return set, set remove the duplicate tabs/window
		Set<String> setToUseWindowHandle1 = driver.getWindowHandles();

		// created list to use the get method and passing the set into it
		List<String> listToUseGet1 = new ArrayList<String>(setToUseWindowHandle1);

		// switching to the window
		driver.switchTo().window(listToUseGet1.get(1));

		// Click on First Resulting Contact
		driver.findElement(By.xpath("//a[text()='ca1']")).click();

		// switching back to main window
		driver.switchTo().window(listToUseGet1.get(0));

		// Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@alt = 'Lookup'])[2]")).click();

		// to handle window using getWindowHandles() and it return set, set remove the duplicate tabs/window
		Set<String> setToUseWindowHandle2 = driver.getWindowHandles();

		// created list to use the get method and passing the set into it
		List<String> listToUseGet2 = new ArrayList<String>(setToUseWindowHandle2);

		// switching to the window
		driver.switchTo().window(listToUseGet2.get(1));

		// Click on Second Resulting Contact
		driver.findElement(By.xpath("//a[text()='10841']")).click();

		// switching back to main window
		driver.switchTo().window(listToUseGet2.get(0));

		// Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text() = 'Merge']")).click();

		// Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// Verify the title of the page
		String title = driver.getTitle();

		if (title.contains("View")) {
			System.out.println("Title is correct");
		} else {
			System.out.println("Title is not correct");
		}
	}

}
