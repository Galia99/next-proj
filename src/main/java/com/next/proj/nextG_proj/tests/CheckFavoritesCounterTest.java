package com.next.proj.nextG_proj.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.pages.FavouritePage;
import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.SearchResultsPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;

public class CheckFavoritesCounterTest extends AbstractTest{

	@Test
	public void _09_CheckFavoritesCounterTest() throws Exception {

		String searchTerm ="Sunglasses Silver Aviator";
		String email = "galinaltman@gmail.com";
		String password = "galina@40";
		
		//Step-1 Browse to next.co.il landing page
		report.startLevel("Step 1 - Browse to next.co.il landing page.");
		browseToUrl("https://www.next.co.il/en");
		LandingPage landingPage = new LandingPage(driver);
		report.endLevel();
		
		//Step-2 click on "My Account Button"
		report.startLevel("Step 2 - Click on \"My Account\" button, browse to Sign In To page.");
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();
		report.endLevel();
		
		//Step-3 enter Password, Email & click on "Sign In Now" button
		report.startLevel("Step 3 - Enter Password, Email & click on \"Sign In Now\" button.");
		signInToNextPage.writeToemailField(email);
		signInToNextPage.writeToPasswordField(password);
		signInToNextPage.clickTosignInNowButton();
		report.endLevel();
		
		//Step 4 - click on  "heart favorites" icon 
		report.startLevel("Step 4 - Click on  \"heart favorites\" icon, browse to Favourite page.");
		FavouritePage favouritePage = landingPage.clickOnFavouriteIcon();
		report.endLevel();
		
		//Step 5 - 
		report.startLevel("Step 5 - .");
		int favoritesCountBefore = favouritePage.getTextCounterFavourites();
		report.endLevel();
		
		//Step 6 - write to searchBox (searchTerm) and click on "search Items" button
		report.startLevel("Step 6 -  Write to searchBox (searchTerm) and click on \"search Items\" button, browse to Search Results page.");
		landingPage.writeToSearchBox(searchTerm);
		SearchResultsPage searchResultsPage = landingPage.clickOnseachItemsButton();
		report.endLevel();
		
		//Step 7 - select favourites heart button in search result and click on favourite icon
		report.startLevel("Step 7 - Select \"favourites heart\" button and click on favourite icon.");
		searchResultsPage.clickToAddToFavouritesHeartButton();
		landingPage.clickOnFavouriteIcon();
		report.endLevel();
		
		//Step 8 - check favourite counter and click on "remove item" button
		report.startLevel("Step 8 - Check favourite counter and click on \"remove item\" button.");
		int favoriteCountAfter = favouritePage.getTextCounterFavourites();
		
		try {
			Assert.assertTrue(favoriteCountAfter > favoritesCountBefore);
			System.out.println("success message");
		}
		catch(Exception e){
			System.out.println("failure message");
		}
		
		favouritePage.clickOnRemoveItemButton();
		report.endLevel();
	}
}
