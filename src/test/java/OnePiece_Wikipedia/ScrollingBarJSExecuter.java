package OnePiece_Wikipedia;

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
		driver.get("https://en.wikipedia.org/wiki/One_Piece");
		driver.manage().window().maximize();
		// Initiate JavaScrip Executer
		jse = (JavascriptExecutor) driver;
	}

	@Test(priority = 1)
	public void scrollOnPixelSize()throws Exception {
		jse.executeScript("window.scrollBy(0,600)", "");
		System.out.println("Location of Bar : " + jse.executeScript("return window.pageYOffset"));	// Location of Bar : 600
		Thread.sleep(3000);	// To verify scroll bar.
	}

//	@Test(priority = 2)
	public void scrollUntilElementFound() {

	}

//	@Test(priority = 3)
	public void scrollEndOfPage() {

	}

//	@Test(priority = 4)
	public void scrollEndReturnToStart() {

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
