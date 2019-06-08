package com.next.proj.nextG_proj.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.config.MainConfig;
import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.SearchResultsPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;

public class CheckFavoritesIconTest extends AbstractTest {

	@Test
	public void _008_CheckFavoritesIconTest() throws Exception {

		String searchTerm ="Sunglasses Silver Aviator";

		//Step-1 browse to next.co.il landing page
		report.startLevel("Step-1 - Browse to next.co.il landing page.");
		browseToUrl(MainConfig.baseUrl);
		LandingPage landingPage = new LandingPage(driver);
		report.endLevel();

		//Step-2 click on "My Account Button"
		report.startLevel("Step-2 - Click on \"My Account Button\".");
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();
		report.endLevel();

		//Step-3 enter Password, Email & click on "Sign In Now" button
		report.startLevel("Step-3 - Enter Password, Email & click on \"Sign In Now\" button.");
		signInToNextPage.writeToemailField(MainConfig.username);
		signInToNextPage.writeToPasswordField(MainConfig.password);
		signInToNextPage.clickTosignInNowButtonVoidFunction();
		report.endLevel();

		//Step 4 - check favorites icon notification when it is empty
		report.startLevel("Step 4 - Check favorites icon notification when it is empty.");
		String iconClassTextBefore = landingPage.getFavouriteIconClassText();
		report.endLevel();

		//Step 5 - send text to search box and click on "seach Items Button"
		report.startLevel("Step 5 - Send text to search box and click on \"seach Items Button\".");
		landingPage.writeToSearchBox(searchTerm); 
		SearchResultsPage searchResultsPage = landingPage.clickOnseachItemsButton();
		report.endLevel();

		//Step 6 - click on "add to favourites heart button"
		report.startLevel("Step 6 - ClickToAddToFavouritesHeartButton.");
		searchResultsPage.clickToAddToFavouritesHeartButton();
		report.endLevel();
		
		report.startLevel("Step 7 - Check favorites icon notification after adding favourite item.");		 
		String iconClassTextAfter = landingPage.getFavouriteIconMarkedClassText();
		System.out.println("====================Icon class is: " + iconClassTextAfter);
		report.endLevel();

		report.startLevel("Step 8 - Assert false: Assert that the notification icon class after adding a favourite item is the same as before adding an item .");		 
		Assert.assertFalse(iconClassTextAfter.equals(iconClassTextBefore));
		searchResultsPage.clickToRemoveFromFavouritesHeartButton();
		report.endLevel();
	  }
}
