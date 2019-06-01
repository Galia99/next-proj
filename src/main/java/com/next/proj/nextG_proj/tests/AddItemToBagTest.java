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
		
		//Step-1 browse to next.co.il landing page
		browseToUrl("https://www.next.co.il/en");
		LandingPage landingPage = new LandingPage(driver);
		
		//Step-2 click on "My Account Button"
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();

		//Step-3 enter Password, Email & click on "Sign In Now" button
		signInToNextPage.writeToemailField(email);
		signInToNextPage.writeToPasswordField(password);
		signInToNextPage.clickTosignInNowButton();

		//Step-4  write a random search term in the top search bar and click the "search items button"
	
		landingPage.writeToSearchBoxRandom();
		SearchResultsPage searchResultsPage = landingPage.clickOnseachItemsButton();
		
		//Step-5 click the title of the first item in the list of search results
		ProductPage productPage = searchResultsPage.clickOnsilverAviatorStyleSunglasses();
	
	    //Step-6 Click "Add To Bag" button
		productPage.clickOnaddToBagButton();
	    
	    //Step-7 Click on "view Edit Bag" Button from "Items in bag" page
	    ShoppingBagPage shoppingBagPage = productPage.clickOnviewEditBagButton();
	    
	    //Step-8 Click on "view Edit Bag" Button from "Items in bag" page
	    Assert.assertEquals(shoppingBagPage.getBagCounterConteiner(), 1, "Wrong number of items in bag!");
	    
	    //Step-9 remove items from bag (click to "remove this item" button)
	    shoppingBagPage.clickOnRemoveThisItemButton();
	}
	
}		
	

