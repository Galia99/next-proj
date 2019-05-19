package com.next.proj.nextG_proj.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeAccountDetailsTest {

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
	public void _05_ChangeAccountDetailsTest() {

		driver.get("https://www.next.co.il/en");

		//Open login window.
		WebElement myAccountButton = driver.findElement(By.xpath("//a[@data-link-id='DataLinkId']"));
		myAccountButton.click();

		//Login with old mail & password
		driver.findElement(By.id("EmailOrAccountNumber")).sendKeys("galinaltman@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("galina@22");
		driver.findElement(By.id("SignInNow")).click();

		//Open signIn details windov with "EDIT" button
		WebElement editSignInDetailsButton = driver.findElement(By.xpath("//div[@id='button_Panel_update_signin_details']//a[@id='btnUpdateSigninDetails']"));
		editSignInDetailsButton.click();


		//Confirm that the "show" button is on & password desable. 
		WebElement showButton = driver.findElement(By.xpath("//button[@tabindex='-1']"));
		String showButtonText = showButton.getText();
		Assert.assertEquals(showButtonText, "show"); //????????????(vozmozhnost' dlya "lulat for")????????

		//Change password.
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("galina@22");
		driver.findElement(By.id("btneditSigninDetails")).click();

		//Logout with "Galina's Account" button.
		Actions action = new Actions(driver);
		WebElement galinasAccountButton = driver.findElement(By.xpath("//li[@data-section='myAccount']/a[@data-link-name='DataLinkName']")); 
		galinasAccountButton.click();
        
		//action.moveToElement (navesti myshku na element chtoby otkryt' novoe okno)
		action.moveToElement(galinasAccountButton).build().perform();
		driver.findElement(By.xpath("//a[@class='myAccountsignout']")).click();

		//Login with new password.
		driver.findElement(By.id("Password")).sendKeys("galina@24");
		driver.findElement(By.id("SignInNow")).click();
		
	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
		driver = null;
	}
}
