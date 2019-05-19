package com.next.proj.nextG_proj.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginInvalidMailTest {

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
	public void _02_loginWithInvalidMailTest() {

		driver.get("https://www.next.co.il/en");

		//Open login window.
		WebElement myAccountButton = driver.findElement(By.xpath("//a[@data-link-id='DataLinkId']"));
		myAccountButton.click();

		//Login with invalid email adress.
		driver.findElement(By.id("EmailOrAccountNumber")).sendKeys("galinaAltman@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("galina@22");
		driver.findElement(By.id("SignInNow")).click();

		//Warnig message (send text) from wrong login page.
		WebElement warningMessageTitel = driver.findElement(By.xpath("//span[@class='msgboxTitle']"));
		String warningMessageTitelText = warningMessageTitel.getText();
		Assert.assertEquals(warningMessageTitelText, "Sorry, we have been unable to sign you in.", "Wrong Warning Message"); 
		
		System.out.println("Warning Message: " + warningMessageTitelText);

		//Clear fields and Login with valid email.
		driver.findElement(By.id("EmailOrAccountNumber")).clear();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("EmailOrAccountNumber")).sendKeys("galinaltman@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("galina@22");
		driver.findElement(By.id("SignInNow")).click();

	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
		driver = null;

	}
}
