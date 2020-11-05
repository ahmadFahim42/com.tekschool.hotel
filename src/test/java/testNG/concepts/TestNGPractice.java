package testNG.concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

//1.      Create a Java class in TestNG.Concept package and name it TestNGPractice
//2.      In before Method block of code write a code to open chrome browser
//3.      in Test method navigate to http://tek-school.com/retail/
//4.      print out page title
//5.      in After method block of code write a code to quite the browser.

public class TestNGPractice {
	
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeTest
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	
	@Test
	
	public void navigateToURL() {
		
		driver.get("http://tek-school.com/retail/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "TEK SCHOOL";
		
	
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertAll();
		
		
	}
	
	@Test (dependsOnMethods = "navigateToURL")
	
	public void VerifyMyAccount() {
		driver.findElement(By.xpath("//span[contains(text(), 'My Account')]"));
		softAssert.assertTrue(myAccount.isDisplayed());
		
		
		
		
	}
	
	@AfterTest
	public void afterMethod() {
		
		driver.quit();
		
	}

}
