package com.next.proj.nextG_proj.tests;

import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.config.MainConfig;
import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.ProductPage;
import com.next.proj.nextG_proj.infra.pages.SearchResultsPage;
import com.next.proj.nextG_proj.infra.pages.ShoppingBagPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;
import com.next.proj.nextG_proj.infra.utils.AssertUtils;

public class AddItemToBagTest extends AbstractTest{

	@Test
	public void _004_addItemsToBagTest() throws Exception {
		
		//Step 1 - Browse to next.co.il landing page, and go to english web site
		report.startLevel("Step 1 - Browse to next.co.il landing page, and go to english web site.");
		browseToUrl(MainConfig.baseUrl);
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goToEnglishWebsite();
		report.endLevel();
		
		//Step 2 - Click on "My Account Button", browse to Sign In To page
		report.startLevel("Step 2 - Click on \"My Account\" button, browse to Sign In To page");
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();
		report.endLevel();
		
		//Step 3 - Enter Password, Email & click on "Sign In Now" button
		report.startLevel("Step 3 - Enter password, email and click on \"Sign In Now\" button.");
		signInToNextPage.writeToemailField(MainConfig.username);
		signInToNextPage.writeToPasswordField(MainConfig.password);
		signInToNextPage.clickTosignInNowButtonVoidFunction();
		report.endLevel();
		
		//Step 4 - write a random search term in the top search bar and click the "search items" button
		report.startLevel("Step 4 - Write a random search term in the top search bar and click on \"search items\" button, browse to Search Results page.");
		landingPage.writeToSearchBoxRandom();
		SearchResultsPage searchResultsPage = landingPage.clickOnseachItemsButton();
		report.endLevel();
		
		//Step 5 - click the title of the first item in the list of search results
		report.startLevel("Step 5 - Click on title of the first item in the list of search results, browse to Product page.");
		ProductPage productPage = searchResultsPage.clickSearchFirstResultTitle();
		report.endLevel();
	
	    //Step 6 - Click "Add To Bag" button
		report.startLevel("Step 6 - Add item to bag by clicking on \"Add To Bag\" button.");
		productPage.clickOnaddToBagButton();
		report.endLevel();
		
	    //Step 7 - Click on "view Edit Bag" Button from "Items in bag" page
		report.startLevel("Step 7 - Click on \"View Edit Bag\" button, browse to Shopping Bag page .");
	    ShoppingBagPage shoppingBagPage = productPage.clickOnviewEditBagButton();
	    report.endLevel();
	    
	    //Step 8 - Check the number of  items added to bag  
		report.startLevel("Step 8 - Verify with AssertEquals function, number of items added to bag.");
		AssertUtils.assertEquals(shoppingBagPage.getBagCounterConteiner(), 1, "Number of items in bag should be 1");
	    report.endLevel();
	    
	    //Step 9 - remove items from bag with click to "remove this item" button
		report.startLevel("Step 9 - Remove items from Shopping Bag page, with click to \"remove this item\" button.");
	    shoppingBagPage.clickOnRemoveThisItemButton();
	    report.endLevel();
	    
	    //Step 10 - Log Out from Next, click on "My Account" button, click on sign out button
	    report.startLevel("Step 10 - Log Out from Next, click on \"My Account\" button, then click on sign out button.");
		landingPage.clickOnmyAccountButton();
		landingPage.clickOnmyAccountSignOut();
		report.endLevel();
	}
}		


