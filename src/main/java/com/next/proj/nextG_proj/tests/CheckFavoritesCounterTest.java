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
		
		//Step-1 browse to next.co.il landing page
		browseToUrl("https://www.next.co.il/en");
		LandingPage landingPage = new LandingPage(driver);
		
		//Step-2 click on "My Account Button"
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();

		//Step-3 enter Password, Email & click on "Sign In Now" button
		signInToNextPage.writeToemailField(email);
		signInToNextPage.writeToPasswordField(password);
		signInToNextPage.clickTosignInNowButton();

		//Step 4 - click on  "heart favorites" icon 
		FavouritePage favouritePage = landingPage.clickOnFavouriteIcon();

		//Step 5 - 
		int favoritesCountBefore = favouritePage.getTextCounterFavourites();

		//Step 6 - write to searchBox (searchTerm) and click on "search Items" button
		landingPage.writeToSearchBox(searchTerm);
		SearchResultsPage searchResultsPage = landingPage.clickOnseachItemsButton();

		//Step 7 - select favourites heart button in search result and click on favourite icon
		searchResultsPage.clickToAddToFavouritesHeartButton();
		landingPage.clickOnFavouriteIcon();

		//Step 8 - check favourite counter and click on "remove item" button
		int favoriteCountAfter = favouritePage.getTextCounterFavourites();
		
		try {
			Assert.assertTrue(favoriteCountAfter > favoritesCountBefore);
			System.out.println("success message");
		}
		catch(Exception e){
			System.out.println("failure message");
		}
		
		favouritePage.clickOnRemoveItemButton();
	}
}
