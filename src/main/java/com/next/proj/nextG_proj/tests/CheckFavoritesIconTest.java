package com.next.proj.nextG_proj.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.SearchResultsPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;

public class CheckFavoritesIconTest extends AbstractTest {


	@Test
	public void _08_CheckFavoritesIconTest() throws Exception {

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


		//Step 4 - check favorites icon notification when it is empty
		landingPage.getFavouriteIcon();

		//Step 5 - send text to search box and click on "seach Items Button"
		landingPage.writeToSearchBox(searchTerm);
		SearchResultsPage searchResultsPage = landingPage.clickOnseachItemsButton();

		//Step 6 - click on "add to favourites heart button"
		searchResultsPage.clickToAddToFavouritesHeartButton();

		//get favorite icon again, verify that icon's class has changed to "notification" i.e-shows notification
		landingPage.getFavouriteIcon();
		Assert.assertEquals(actual, expected, message);


		/*String string1="apple";
	String string2="orange";
	public void assertFalseStrings() {
		//This function is supposed to return TRUE because the strings are NOT equal
		//for example you had one title, you changed the title, and then you can assert that the new title
		//is NOT EQUAL to the old title
		Assert.assertFalse(string1.equals(string2));
	}

	public void assertPlusOne() {
		//get number of favorites from website
		String oldNumberofFavorites="0";
		int oldNumF=Integer.parseInt(oldNumberofFavorites);

		//add one more favorite item
		//get current number of favorites from website
		String actualNumberofFavorites=null;
		int actualNumF=Integer.parseInt(actualNumberofFavorites);

		//assert that the new number of favorites is equal to the old number of favorites plus one
		 Assert.assertEquals(actualNumF, oldNumF+1, "Wrong number of favorites!");

	}*/

	}}
