package com.next.proj.nextG_proj.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.ProductPage;
import com.next.proj.nextG_proj.infra.pages.SearchResultsPage;
import com.next.proj.nextG_proj.infra.pages.ShoppingBagPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;

public class AddItemToBagTest extends AbstractTest{

	@Test
	public void _06_addItemsToBagTest() throws Exception {

		String email = "galinaltman@gmail.com";
		String password = "galina@40";
		
		//Step 1 - Browse to next.co.il landing page
		report.startLevel("Step 1 - Browse to next.co.il landing page.");
		browseToUrl("https://www.next.co.il/en");
		LandingPage landingPage = new LandingPage(driver);
		report.endLevel();
		
		//Step-2 click on "My Account Button"
		report.startLevel("Step 2 - Click on \"My Account\" button, browse to Sign In To page");
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();
		report.endLevel();
		
		//Step-3 enter Password, Email & click on "Sign In Now" button
		report.startLevel("Step 3 - Enter password, email and click on \"Sign In Now\" button.");
		signInToNextPage.writeToemailField(email);
		signInToNextPage.writeToPasswordField(password);
		signInToNextPage.clickTosignInNowButton();
		report.endLevel();
		
		//Step-4  write a random search term in the top search bar and click the "search items" button
		report.startLevel("Step 4 - Write a random search term in the top search bar and click on \"search items\" button, browse to Search Results page.");
		landingPage.writeToSearchBoxRandom();
		SearchResultsPage searchResultsPage = landingPage.clickOnseachItemsButton();
		report.endLevel();
		
		//Step-5 click the title of the first item in the list of search results
		report.startLevel("Step 5 - Click on title of the first item in the list of search results, browse to Product page.");
		ProductPage productPage = searchResultsPage.clickOnsilverAviatorStyleSunglasses();
		report.endLevel();
	
	    //Step-6 Click "Add To Bag" button
		report.startLevel("Step 6 - Click on \"Add To Bag\" button.");
		productPage.clickOnaddToBagButton();
		report.endLevel();
		
	    //Step-7 Click on "view Edit Bag" Button from "Items in bag" page
		report.startLevel("Step 7 - Click on \"View Edit Bag\" button, browse to Shopping Bag page .");
	    ShoppingBagPage shoppingBagPage = productPage.clickOnviewEditBagButton();
	    report.endLevel();
	    
	    //Step-8 Check the number of  items added to bag  
		report.startLevel("Step 8 - Verify the number of items added to bag.");
	    Assert.assertEquals(shoppingBagPage.getBagCounterConteiner(), 1, "Wrong number of items in bag!");
	    report.endLevel();
	    
	    //Step-9 remove items from bag with click to "remove this item" button
		report.startLevel("Step 9 - Remove items from \"ShoppingBagPage\" with click to \"remove this item\" button.");
	    shoppingBagPage.clickOnRemoveThisItemButton();
	    report.endLevel();
	}
	
}		
	

