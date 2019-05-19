package com.next.proj.nextG_proj.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.pages.NextLandingPage;
import com.next.proj.nextG_proj.infra.pages.NextSearchResultsPage;


public class SearchProductNegativeTest {

	private WebDriver driver;

	@BeforeMethod
	public void beforeTest(){

		if (driver == null) {
			System.setProperty("webdriver.chrome,driver", "src/main/resources/chromedriver.exe"); //System.setProperty("what we are looking for...", "where to looking for...");
			driver = new ChromeDriver(); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//Implicitly Wait (TimeOut) If Element not found.
			driver.manage().window().maximize();
		}
	}

	@Test
	public void _003_searchProductNegativeTest() throws Exception {

		//Search and compare data.
		String searchTerm = "Shoes";
		String expectedWordInResult ="Sunglasses";  

		driver.get("https://www.next.co.il/en");

		//Open logIn window.
		WebElement myAccountButton = driver.findElement(By.xpath("//a[@data-link-id='DataLinkId']"));
		myAccountButton.click();

		//LogIn.
		driver.findElement(By.id("EmailOrAccountNumber")).sendKeys("galinaltman@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("galina@22");
		driver.findElement(By.id("SignInNow")).click();

		//Write search box.
		NextLandingPage nextLandingPage = new NextLandingPage(driver);
		nextLandingPage.writeToSearchBox(searchTerm);

		//Click on "Item Button".
		NextSearchResultsPage nextSearchResultsPage = nextLandingPage.clickOnseachItemsButton();
		
		//????????????
		String sandalsSearchTitle = nextSearchResultsPage.getSandalsSearchTitle();  	

		//Check search result.
		Assert.assertTrue(sandalsSearchTitle.contains(expectedWordInResult), "The result found does not match the query! " + expectedWordInResult + "'");
	}

/*	@AfterMethod
	public void afterTest() {
		driver.quit();
		driver = null;
	}*/
}
