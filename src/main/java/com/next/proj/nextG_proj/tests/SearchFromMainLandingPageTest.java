package com.next.proj.nextG_proj.tests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.config.MainConfig;
import com.next.proj.nextG_proj.infra.entities.SearchItem;
import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.SearchResultsPage;
import com.next.proj.nextG_proj.infra.utils.AssertUtils;

public class SearchFromMainLandingPageTest extends AbstractTest{

	@Test (dataProvider = "csvParamsProvider") 
	public void _003_searchFromMainLandingPageTest(SearchItem searchItem) throws Exception {
		
		//Step 1 - Browse to next.co.il landing page, and go to english web site
		report.startLevel("Step 1 - Browse to next.co.il landing page, and go to english web site.");
		browseToUrl(MainConfig.baseUrl);
		report.endLevel();
		
		//Step 2 - Write to search box, click on "search items" button, browse to Search Results page, take screenshot of search result
		report.startLevel("Step 2 - Write to search box, click on \"search items\" button, browse to Search Results page, take screenshot of search result.");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.writeToSearchBox(searchItem.searchTerm);
		SearchResultsPage searchResultsPage = landingPage.clickOnseachItemsButton();
		takeScreenshot("\"" + searchItem.searchTerm + "\" - Search results");
		report.endLevel();
		
		//Step 3 - Get Result Title By Id and assert that the results title matches the search item string
		report.startLevel("Step 3 - Get Result Title By Id and assert that the results title matches the search item string.");
		String searchResultTitle = searchResultsPage.getSearchResultTitleById(searchItem.itemIndex);
		AssertUtils.assertTrue(searchResultTitle.contains(searchItem.expectedResult), "Expecting to see '" + searchItem.expectedResult + "' in first result, but saw: " + searchResultTitle);
		report.endLevel();
	}
	
	@DataProvider(name = "csvParamsProvider")
	public Object[][] dataProvider3() throws Exception {
		
		FileInputStream fstream = new FileInputStream("src/main/resources/config/products.csv");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		int numOfLines = 0;
		String line;

		ArrayList<SearchItem> searchItems = new ArrayList<SearchItem>();
		
		while ((line = br.readLine()) != null) {
			
			if (numOfLines > 0) {
				
				String[] splitStr = line.split(",");
				SearchItem searchItem = new SearchItem(splitStr[0], Integer.parseInt(splitStr[1]), splitStr[2]);
				searchItems.add(searchItem);
			}
			
			numOfLines++;
		}
		
		br.close();
		
		Object[][] params = new Object[numOfLines-1][1];
		
		for (int i=0; i<numOfLines-1; i++) {
			params[i][0] = searchItems.get(i);
		}

		return params;
	}
}

