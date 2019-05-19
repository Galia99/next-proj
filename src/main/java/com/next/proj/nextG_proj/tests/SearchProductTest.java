package com.next.proj.nextG_proj.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.pages.NextLandingPage;


public class SearchProductTest {
	
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
	public void _04_searchProductsTest() throws Exception {

		String wordRequest ="Sunglasses Silver Aviator";
		
		driver.get("https://www.next.co.il/en");

		//Login to next.com
		WebElement myAccountButton = driver.findElement(By.xpath("//a[@data-link-id='DataLinkId']"));
		myAccountButton.click();

		driver.findElement(By.id("EmailOrAccountNumber")).sendKeys("galinaltman@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("galina@22");
		driver.findElement(By.id("SignInNow")).click();

		//write in search box
		NextLandingPage nextLandingPage = new NextLandingPage(driver);
		nextLandingPage.writeToSearchBoxwordRequest(wordRequest);
		nextLandingPage.clickOnseachItemsButton();
		/*WebElement searchBox = driver.findElement(By.xpath("//input[@class='SearchBox']"));
		searchBox.sendKeys("Sunglasses Silver Aviator");
		WebElement seachItemsButton = driver.findElement(By.xpath("//input[@class='SearchButton']"));
		searchBox.sendKeys(Keys.ENTER);
		*/
		//Open item page.
		driver.findElement(By.xpath(("//article[@id='i1']"))).click();		
	}
	
	@AfterMethod
	public void afterTest() {
		driver.quit();
		driver = null;
	}

}