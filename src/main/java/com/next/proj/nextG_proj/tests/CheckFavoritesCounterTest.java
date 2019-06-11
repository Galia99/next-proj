package com.next.proj.nextG_proj.tests;

import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.config.MainConfig;
import com.next.proj.nextG_proj.infra.pages.FavouritePage;
import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.SearchResultsPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;
import com.next.proj.nextG_proj.infra.utils.AssertUtils;

public class CheckFavoritesCounterTest extends AbstractTest{

	@Test
	public void _005_CheckFavoritesCounterTest() throws Exception {

		String searchTerm ="Sunglasses Silver Aviator";
		
		//Step-1 Browse to next.co.il landing page, and go to english web site.
		report.startLevel("Step 1 - Browse to next.co.il landing page, and go to english web site.");
		browseToUrl(MainConfig.baseUrl);
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goToEnglishWebsite();
		report.endLevel();
		
		//Step-2 Click on "My Account" button, browse to Sign In To page.
		report.startLevel("Step 2 - Click on \"My Account\" button, browse to Sign In To page.");
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();
		report.endLevel();
		
		//Step-3 Enter Password, Email and click on "Sign In Now" button
		report.startLevel("Step 3 - Enter Password, Email and click on \"Sign In Now\" button.");
		signInToNextPage.writeToemailField(MainConfig.username);
		signInToNextPage.writeToPasswordField(MainConfig.password);
		signInToNextPage.clickTosignInNowButtonVoidFunction();
		report.endLevel();
		
		//Step 4 - Click on  "heart favorites" icon, browse to Favourite page.
		report.startLevel("Step 4 - Click on  \"heart favorites\" icon, browse to Favourite page.");
		FavouritePage favouritePage = landingPage.clickOnFavouriteIcon();
		report.endLevel();
		
		//Step 5 - Check counter, before adding favorite items.
		report.startLevel("Step 5 - Check counter, before adding favorite items.");
		int favoritesCountBefore = favouritePage.getTextCounterFavourites();
		report.endLevel();
		
		//Step 6 - Write to searchBox (searchTerm) and click on "search Items" button
		report.startLevel("Step 6 -  Write to searchBox (searchTerm) and click on \"search Items\" button, browse to Search Results page.");
		landingPage.writeToSearchBox(searchTerm);
		SearchResultsPage searchResultsPage = landingPage.clickOnseachItemsButton();
		report.endLevel();
		
		//Step 7 - Celect favourites heart button in search result and click on favourite icon
		report.startLevel("Step 7 - Select \"favourites heart\" button and click on favourite icon.");
		searchResultsPage.clickToAddToFavouritesHeartButton();
		landingPage.clickOnFavouriteIcon();
		report.endLevel();
		
		//Step 8 - Check favourite counter and click on "remove item" button
		report.startLevel("Step 8 - Check favourite counter and click on \"remove item\" button.");
		int favoriteCountAfter = favouritePage.getTextCounterFavourites();
		
		try {
			AssertUtils.assertTrue(favoriteCountAfter > favoritesCountBefore,"Item has not been added to the bag");
			System.out.println("success message");
		}
		catch(Exception e){
			System.out.println("failure message");
		}
		
		favouritePage.clickOnRemoveItemButton();
		report.endLevel();
		
		//Step 9 - Log Out from Next, click on "My Account" button, then click on sign out button.
		report.startLevel("step 9 - Log Out from Next, click on \"My Account\" button, then click on sign out button.");
		landingPage.clickOnmyAccountButton();
		landingPage.clickOnmyAccountSignOut();
		report.endLevel();
		
	}
}
