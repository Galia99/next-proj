package com.next.proj.nextG_proj.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.ProductPage;
import com.next.proj.nextG_proj.infra.pages.SearchResultsPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;

public class SearchProductTest  extends AbstractTest{

	@Test
	public void _04_searchProductsTest() throws Exception {

		String searchTerm ="Sunglasses Silver Aviator";
		String expectedResultSunglasses ="Ray-Ban® Aviator Sunglasses";
		String email = "GalinaLtman@gmail.com";
		String password = "galina@40";
		
		//Step 1 - Browse to next.co.il landing page
		report.startLevel("Step 1 - Browse to next.co.il landing page.");
		browseToUrl("https://www.next.co.il/en");
		LandingPage landingPage = new LandingPage(driver);
		report.endLevel();
		
		//Step 2 - click on "My Account Button"
		report.startLevel("Step 2 - Click on \"My Account\" button, browse to Sign In To page.");
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();
		report.endLevel();
		
		//Step 3 - Enter Password, Email and click on "Sign In Now" button
		report.startLevel("Step 3 - Enter Password, Email and click on \"Sign In Now\" button.");
		signInToNextPage.writeToemailField(email);
		signInToNextPage.writeToPasswordField(password);
		signInToNextPage.clickTosignInNowButton();
		report.endLevel();
		
		//Step-4 write to search box & click on "search items" button
		report.startLevel("Step 4 - Write to search box & click on \"search items\" button, browse to Search Results page.");
		landingPage.writeToSearchBox(searchTerm);
		SearchResultsPage searchResultsPage = landingPage.clickOnseachItemsButton();
		report.endLevel();
		
		//Step-5 click on search results item 
		report.startLevel("Step 5 - Click on search results item, browse to Product page.");
		ProductPage productPage = searchResultsPage.clickOnsilverAviatorStyleSunglasses();
		report.endLevel();
		
		//Step-6 Confirm with message, that the request is match the search result.
		report.startLevel("Step 6 - Confirm with message, that the request is match the search result.");
		String itemTitle = productPage.getProductTitle();
		Assert.assertTrue(itemTitle.contains(expectedResultSunglasses), "The result found does not match the query! " + expectedResultSunglasses + "'");
		report.endLevel();
	}
}