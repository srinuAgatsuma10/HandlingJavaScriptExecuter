package OnePiece_Wikipedia;

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
	public void handlingInputBox() {
		WebElement inputBox = driver.findElement(By.xpath("//input[@title='Search Wikipedia [alt-shift-f]']"));
		jse.executeScript("arguments[0].setAttribute('value','Selenium')", inputBox);
		driver.findElement(By.xpath("//form[@id='searchform']//button")).click();
		driver.navigate().back();
	}

	@Test(priority = 2)
	public void radioButton() {
		WebElement radioButton = driver.findElement(By.xpath("//input[@id='skin-client-pref-vector-feature-custom-font-size-value-0']"));
		jse.executeScript("arguments[0].click()", radioButton);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
