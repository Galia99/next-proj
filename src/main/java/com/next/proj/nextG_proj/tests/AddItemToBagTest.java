package com.next.proj.nextG_proj.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToBagTest {

	private WebDriver driver;

	@BeforeMethod
	public void beforeTest(){

		if (driver == null) {
			System.setProperty("webdriver.chrome,driver", "src/main/resources/chromedriver.exe"); //System.setProperty("what we are looking for...", "where to looking for...");
			driver = new ChromeDriver(); //browser selection
			driver.manage().window().maximize();
		}
	}

	@Test
	public void _06_addItemsToBagTest() throws Exception {

		driver.get("https://www.next.co.il/en");

		//Login to next.com
		WebElement myAccountButton = driver.findElement(By.xpath("//a[@data-link-id='DataLinkId']"));
		myAccountButton.click();

		driver.findElement(By.id("EmailOrAccountNumber")).sendKeys("galinaltman@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("galina@22");
		driver.findElement(By.id("SignInNow")).click();

		//write in search box
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='SearchBox']"));
		searchBox.sendKeys("Sunglasses Silver Aviator");
		searchBox.sendKeys(Keys.ENTER);

		//Open Aviator Style Sunglasses item page.
		WebElement silverAviatorStyleSunglassesTitle = driver.findElement(By.xpath("//h2/a[@title='Ray-Ban® Aviator Sunglasses (437533) | ₪ 483']"));
		silverAviatorStyleSunglassesTitle.click();
		
    	//Add to bag.
		WebElement addToBagButton = driver.findElement(By.xpath("//a[@class='nxbtn primary btn-addtobag addToBagCTA Enabled']"));
		addToBagButton.click();
	}

	/*@AfterMethod
	public void afterTest() {
		driver.quit();
		driver = null;

	}*/
}
