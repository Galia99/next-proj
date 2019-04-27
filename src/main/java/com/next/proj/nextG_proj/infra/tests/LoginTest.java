package com.next.proj.nextG_proj.infra.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	private WebDriver driver;

	@BeforeMethod
	public void beforeTest() {
		
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}
	
	
	@Test
	public void _002_loginToAmazon() {
		
		driver.get("http://amazon.com");
		
		Actions action = new Actions(driver);
		WebElement helloSignInLink = driver.findElement(By.id("nav-link-accountList"));
		
		action.moveToElement(helloSignInLink).build().perform();
		
		driver.findElement(By.xpath("//div[@id='nav-al-signin']//span[text()='Sign in']")).click();
		driver.findElement(By.id("ap_email")).sendKeys("aa@bb.com");
		driver.findElement(By.id("ap_password")).sendKeys("123456");
		driver.findElement(By.id("signInSubmit")).click();
		
		WebElement warningMessageTitle = driver.findElement(By.xpath("//div[@id='auth-warning-message-box']//h4"));
		String warningMessageTitleText = warningMessageTitle.getText();
}
}
