package automationBlogSpot;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingJSExecuter {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void handlingInputBox() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement inputBox = driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"));
		jse.executeScript("arguments[0].setAttribute('value','Selenium')", inputBox);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		List<WebElement> SearchResults = driver
				.findElements(By.xpath("//div[@class=\"wikipedia-search-results\"]//div"));
		for (WebElement sr : SearchResults) {
			System.out.println(sr.getText());
		}
	}

	@Test
	public void radioButton() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement radioBtn = driver.findElement(By.xpath("//input[@id='male']"));
		jse.executeScript("arguments[0].click()", radioBtn);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
