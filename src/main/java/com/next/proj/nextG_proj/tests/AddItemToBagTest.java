package com.next.proj.nextG_proj.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.pages.ItemsInBagPage;
import com.next.proj.nextG_proj.infra.pages.NextLandingPage;
import com.next.proj.nextG_proj.infra.pages.NextProductPage;
import com.next.proj.nextG_proj.infra.pages.NextSearchResultsPage;

public class AddItemToBagTest extends AbstractTest{

	@Test
	public void _06_addItemsToBagTest() throws Exception {

		// Step 1 - Browse to next.co.il landing page
		driver.get("https://www.next.co.il/en");

		WebElement myAccountButton = driver.findElement(By.xpath("//a[@data-link-id='DataLinkId']"));
		myAccountButton.click();

		driver.findElement(By.id("EmailOrAccountNumber")).sendKeys("galinaltman@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("galina@22");
		driver.findElement(By.id("SignInNow")).click();

		NextLandingPage nextLandingPage = new NextLandingPage(driver);
		
		// Step 2 - Write a random search term in the top search bar and click the "search items button"
		String randomSearchTerm = generateRandomSearchTerm();
		nextLandingPage.writeToSearchBox(randomSearchTerm);
		NextSearchResultsPage nextSearchResultsPage = nextLandingPage.clickOnseachItemsButton();
		
		//Step 3 - Click the title of the first item in the list of search results
		NextProductPage nextProductPage = nextSearchResultsPage.clickOnsilverAviatorStyleSunglasses();
	
	    //Step-4 Click "Add To Bag" button
	    nextProductPage.clickOnaddToBagButton();
	    
	    //Step-5 Click on "view Edit Bag" Button from "Items in bag" page
	    nextProductPage.clickOnviewEditBagButton();
	 

	}
	private String generateRandomSearchTerm() {
		
		return "Sunglasses Silver Aviator";
	}
		
		
		
		
		
		
		
		
		// Step 2 - Write a random search term in the top search bar and click the "search items button"
	//	nextLandingPage.writeToSearchBoxwordRequest(wordRequestSunglassesSilverAviator);
	//	nextLandingPage.clickOnseachItemsButton();
		
		//Step 3 - Click the title of the first item in the list of search results
	//	driver.findElement(By.xpath(("//article[@id='i1']"))).click();	

		//Step 4 - Click "Add to Bag" button
	//	ProductPage productPage = new ProductPage(driver);
	//	productPage.clickOnaddToBagButton();
		//WebElement addToBagButton = driver.findElement(By.xpath("//div[@class='AddToBag']/a[@class='nxbtn primary btn-addtobag addToBagCTA Enabled']"));
		//addToBagButton.click();

		//Step 5 - Verify the "Cart" icon on the top right of the page shows the correct number of products added to the cart.

		//Click on "shopping Bag Button".
		//driver.findElement(By.xpath(("//div[@class='Icon active']"))).click();	
	}

