package com.next.proj.nextG_proj.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.config.MainConfig;
import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.SearchResultsPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;

public class CheckFavoritesIconTest extends AbstractTest {

	@Test
	public void _006_CheckFavoritesIconTest() throws Exception {

		String searchTerm ="Sunglasses Silver Aviator";

		//Step 1 - Browse to next.co.il landing page, and go to english web site
		report.startLevel("Step-1 - Browse to next.co.il landing page, and go to english web site.");
		browseToUrl(MainConfig.baseUrl);
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goToEnglishWebsite();
		report.endLevel();

		//Step 2 - Click on "My Account button"Click on "My Account" Button, browse to SignIn To Next page
		report.startLevel("Step-2 - Click on \"My Account\" button, browse to SignIn To Next page.");
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();
		report.endLevel();

		//Step 3 - Enter Password, Email & click on "Sign In Now" button
		report.startLevel("Step-3 - Enter Password, Email & click on \"Sign In Now\" button.");
		signInToNextPage.writeToemailField(MainConfig.username);
		signInToNextPage.writeToPasswordField(MainConfig.password);
		signInToNextPage.clickTosignInNowButtonVoidFunction();
		report.endLevel();

		//Step 4 - Check favorites icon notification when it is empty
		report.startLevel("Step 4 - Check favorites icon notification when it is empty.");
		String iconClassTextBefore = landingPage.getFavouriteIconClassText();
		report.endLevel();

		//Step 5 - Send text to search box and click on "seach Items Button", browse to Search Result page
		report.startLevel("Step 5 - Send text to search box and click on \"seach Items\" button, browse to Search Result page.");
		landingPage.writeToSearchBox(searchTerm); 
		SearchResultsPage searchResultsPage = landingPage.clickOnseachItemsButton();
		report.endLevel();

		//Step 6 - Click on "add to favourites heart" button
		report.startLevel("Step 6 - Click to add to favourites heart button.");
		searchResultsPage.clickToAddToFavouritesHeartButton();
		report.endLevel();
		
		//Step 7 - Check favorites icon notification after adding favourite item
		report.startLevel("Step 7 - Check favorites icon notification after adding favourite item.");		 
		String iconClassTextAfter = landingPage.getFavouriteIconMarkedClassText();
		report.endLevel();

		//Step 8 - Assert false: Assert that the notification icon class after adding a favourite item is the same as before adding an item
		report.startLevel("Step 8 - Assert false: Assert that the notification icon class after adding a favourite item is the same as before adding an item .");		 
		Assert.assertFalse(iconClassTextAfter.equals(iconClassTextBefore));
		searchResultsPage.clickToRemoveFromFavouritesHeartButton();
		report.endLevel();
	  }
}
