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
		browseToUrl("https://www.next.co.il/en");
		LandingPage landingPage = new LandingPage(driver);

		//Step 2 - click on "My Account Button"
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();

		//Step 3 - Enter Password, Email and click on "Sign In Now" button
		signInToNextPage.writeToemailField(email);
		signInToNextPage.writeToPasswordField(password);
		signInToNextPage.clickTosignInNowButton();

		//Step-4 write to search box & click on "search items" button
		landingPage.writeToSearchBox(searchTerm);
		SearchResultsPage searchResultsPage = landingPage.clickOnseachItemsButton();

		//Step-5 click on search results item 
		searchResultsPage.clickOnsilverAviatorStyleSunglasses();

		//Step-6 ?????
		ProductPage productPage = new ProductPage(driver);
		String itemTitle = productPage.getProductTitle();

		//Step-7 check search result
		Assert.assertTrue(itemTitle.contains(expectedResultSunglasses), "The result found does not match the query! " + expectedResultSunglasses + "'");
	}
}