package com.next.proj.nextG_proj.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.SearchResultsPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;

public class SearchProductNegativeTest  extends AbstractTest{

	@Test
	public void _003_searchProductNegativeTest() throws Exception {

		
		String searchTerm = "Shoes";
		String expectedWordInResultSunglasses ="Sunglasses";  
		String email = "GalinaLtman@gmail.com";
		String password = "galina@40";
		
		//Step 1 - Browse to next.co.il landing page
		browseToUrl("https://www.next.co.il/en");
		LandingPage landingPage = new LandingPage(driver);

		//Step 2 - click on "My Account Button"
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();

		//Step 3 - Enter Password, Email and click on "Sign In Now" button
		signInToNextPage.writeToemailField(email);
		signInToNextPage.writeToPasswordField(password);
		signInToNextPage.clickTosignInNowButton();

		//Step-4 write to search box & click on "Search Box" button
		landingPage.writeToSearchBox(searchTerm);

		//Step-5 click on "Item Button"
		SearchResultsPage searchResultsPage = landingPage.clickOnseachItemsButton();

		//Step-6 ????????????
		String sandalsSearchTitle = searchResultsPage.getSandalsSearchTitle();  	

		//Step-7 check search result
		Assert.assertTrue(sandalsSearchTitle.contains(expectedWordInResultSunglasses), "The result found does not match the query! " + expectedWordInResultSunglasses + "'");
	}
}
