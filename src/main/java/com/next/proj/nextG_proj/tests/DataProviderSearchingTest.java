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

public class DataProviderSearchingTest extends AbstractTest{

	//@Test(dataProvider = "objectParamsProvider")
	@Test (dataProvider = "csvParamsProvider") 
	public void _011_searchFromMainLandingPage(SearchItem searchItem) throws Exception {
		
		browseToUrl(MainConfig.baseUrl);
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.writeToSearchBox(searchItem.searchTerm);
		
		SearchResultsPage searchResultsPage = landingPage.clickOnseachItemsButton();
		takeScreenshot("\"" + searchItem.searchTerm + "\" - Search results");
		
		//Search Result Title By Id
		String searchResultTitle = searchResultsPage.getSearchResultTitleById(searchItem.itemIndex);
		AssertUtils.assertTrue(searchResultTitle.contains(searchItem.expectedResult), "Expecting to see '" + searchItem.expectedResult + "' in first result");
	}
	
	@Test(dataProvider = "nextSearchTestParamsProvider1")
	public void searchFromMainLandingPage1(String searchTerm, int id, String expected) {
		
		report.log("searchTerm = " + searchTerm);
		report.log("itemId = " + id);
		report.log("expectedResult = " + expected);
	}
	
	@DataProvider(name = "nextSearchTestParamsProvider1")
	public Object[][] dataProvider1() {
	
		/*//Diff option
		Object[][] myObjects = new Object[5][6];
		myObjects[3][4] = "AA";
		*/
		Object[][] params = new Object[2][3];
		
		params[0][0] = "Suits";
		params[0][1] = 1;
		params[0][2] = "Two Button Suit: Jacket";
		
		params[1][0] = "Curtains";
		params[1][1] = 3;
		params[1][2] = "Cotton Curtains";

		return params;
	}

	@DataProvider(name = "objectParamsProvider")
	public Object[][] dataProvider2() {
		
		Object[][] params = new Object[3][1];
		
		SearchItem searchItem1 = new SearchItem("Suits", 1, "Two Button Suit: Jacket");
		SearchItem searchItem2 = new SearchItem("Curtains", 3, "Cotton Curtains");
		SearchItem searchItem3 = new SearchItem("Nova", 4, "Nova Fides Signature Check Blazer");
		
		params[0][0] = searchItem1;
		params[1][0] = searchItem2;
		params[2][0] = searchItem3;

		return params;
	}
	
	@DataProvider(name = "csvParamsProvider")
	public Object[][] dataProvider3() throws Exception {
		
		FileInputStream fstream = new FileInputStream("src/main/resources/config/products.csv");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		int numOfLines = 0;
		String line;

		ArrayList<SearchItem> searchItems = new ArrayList<SearchItem>();
		
		//choose next line in file
		while ((line = br.readLine()) != null) {
			
			if (numOfLines > 0) {
				
				//separates columns with(,)
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

