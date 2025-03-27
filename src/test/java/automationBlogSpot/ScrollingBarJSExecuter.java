package automationBlogSpot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollingBarJSExecuter {
	WebDriver driver;
	
	JavascriptExecutor jse;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		// Initiate JavaScrip Executer
		jse = (JavascriptExecutor) driver;
	}

	@Test(priority = 1)
	public void scrollOnPixelSize() {
		jse.executeScript("window.scrollBy(0,500)", "");
		System.out.println("Location of Bar : " + jse.executeScript("return window.pageYOffset")); // Location of Bar : 500
	}

	@Test(priority = 2)
	public void scrollUntilElementFound() {
		WebElement tab_title = driver.findElement(By.xpath("//h2[normalize-space()='Pagination Web Table']"));
		jse.executeScript("arguments[0].scrollIntoView();", tab_title);
		System.out.println("Current Location of Bar : " + jse.executeScript("return window.pageYOffset"));	// Current Location of Bar : 2712.857177734375
	}

	@Test(priority = 3)
	public void scrollEndOfPage() throws Exception {
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println("Cuurent Location of Bar : "+jse.executeScript("return window.pageYOffset"));  // Cuurent Location of Bar : 3323.571533203125
		Thread.sleep(3000);
	}
	
	@Test(priority = 4)
	public void scrollEndReturnToStart() throws Exception {
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println("Cuurent Location of Bar : "+jse.executeScript("return window.pageYOffset"));  // Cuurent Location of Bar : 3323.571533203125
		Thread.sleep(3000);
		
		//return to the Initial place
		jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println("Current Location of Bar : "+jse.executeScript("return window.pageYOffset"));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
