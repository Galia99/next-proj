package com.next.proj.nextG_proj.tests;

import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.config.MainConfig;
import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.ProductPage;
import com.next.proj.nextG_proj.infra.pages.SearchResultsPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;
import com.next.proj.nextG_proj.infra.utils.AssertUtils;

public class SearchProductTest  extends AbstractTest{

	@Test
	public void _001_searchProductsTest() throws Exception {

		String searchTerm ="Sunglasses Silver Aviator";
		String expectedResultSunglasses ="Ray-Ban® Aviator Sunglasses";

		//Step 1 - Browse to next.co.il landing page, and go to english web site
		report.startLevel("Step 1 - Browse to next.co.il landing page, and go to english web site.");
		browseToUrl(MainConfig.baseUrl);
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goToEnglishWebsite();
		report.endLevel();
		
		//Step 2 - Click on "My Account" button, browse to Sign In To page
		report.startLevel("Step 2 - Click on \"My Account\" button, browse to Sign In To page.");
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();
		report.endLevel();
		
		//Step 3 - Enter Password, Email and click on "Sign In Now" button
		report.startLevel("Step 3 - Enter Password, Email and click on \"Sign In Now\" button.");
		signInToNextPage.writeToemailField(MainConfig.username);
		signInToNextPage.writeToPasswordField(MainConfig.password);
		signInToNextPage.clickTosignInNowButtonVoidFunction();
		report.endLevel();
		
		//Step 4 - Write to search box & click on "Search Items" button, browse to Search Results page
		report.startLevel("Step 4 - Write to search box & click on \"search items\" button, browse to Search Results page.");
		landingPage.writeToSearchBox(searchTerm);
		SearchResultsPage searchResultsPage = landingPage.clickOnseachItemsButton();
		report.endLevel();
		
		//Step 5 - click on search results item 
		report.startLevel("Step 5 - Click on search results button, browse to Product page.");
		ProductPage productPage = searchResultsPage.clickSearchFirstResultTitle();
		report.endLevel();
		
		//Step 6 - Confirm with message, that the request matches the search result
		report.startLevel("Step 6 - Confirm with message, that the request matches the search result.");
		String itemTitle = productPage.getProductTitle();
		AssertUtils.assertTrue(itemTitle.contains(expectedResultSunglasses), "The result matches the query! " + expectedResultSunglasses + "'");
		report.endLevel();
		
		//Step 7 - Log Out from Next, click on \"My Account\" button, then click on sign out button
		report.startLevel("step 7 - Log Out from Next, click on \"My Account\" button, then click on sign out button.");
		landingPage.clickOnmyAccountButton();
		landingPage.clickOnmyAccountSignOut();
		report.endLevel();
	}
}