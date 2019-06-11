package com.next.proj.nextG_proj.tests;

import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.config.MainConfig;
import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.SearchResultsPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;
import com.next.proj.nextG_proj.infra.utils.AssertUtils;

public class SearchProductNegativeTest  extends AbstractTest{

	@Test
	public void _002_searchProductNegativeTest() throws Exception {

		String searchTerm = "Shoes";
		String expectedWordInResultSunglasses ="Sunglasses";  
		
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
	
		//Step-4 Wite to search box and click on \"Search Item\" button, browse to Search Results page
		report.startLevel("Step 4 - Wite to search box and click on \"Search Item\" button, browse to Search Results page.");
		landingPage.writeToSearchBox(searchTerm);
		SearchResultsPage searchResultsPage = landingPage.clickOnseachItemsButton();
		report.endLevel();
		
		//Step-5 Assert false:Confirm with message, that the request does not match the search result
		report.startLevel("Step 5 - Assert false:Confirm with message, that the request does not match the search result.");
		String sandalsSearchTitle = searchResultsPage.getSearchFirstResultTitle();  	
		AssertUtils.assertFalse(sandalsSearchTitle.contains(expectedWordInResultSunglasses), "The result found does not match the query! " + expectedWordInResultSunglasses + "'");
		report.endLevel();
		
		//Step- 6 Log Out from Next, click on \"My Account\" button, then click on sign out button
		report.startLevel("Step 6 - Log Out from Next, click on \"My Account\" button, then click on sign out button.");
		landingPage.clickOnmyAccountButton();
		landingPage.clickOnmyAccountSignOut();
		report.endLevel();
	}
}
