package com.next.proj.nextG_proj.tests;

import org.testng.Assert;

import com.next.proj.nextG_proj.infra.pages.NextLandingPage;
import com.next.proj.nextG_proj.infra.pages.NextSearchResultsPage;

public class Bla {
	//Write search box.
			NextLandingPage nextLandingPage = new NextLandingPage(driver);
			nextLandingPage.writeToSearchBox(searchTerm);
			nextLandingPage.enterToSearchBox();
			/*//Write search box.
			WebElement searchBox = driver.findElement(By.xpath("//input[@class='SearchBox']"));
			searchBox.sendKeys(searchTerm);
			searchBox.sendKeys(Keys.ENTER);
			*/
			//Found item.
			NextSearchResultsPage nextSearchResultsPage = new NextSearchResultsPage(driver);
			String sandalsSearchTitle = nextSearchResultsPage.getSandalsSearchTitle();  
			//String sandalsSearchTitle = driver.findElement(By.xpath("//a[@data-label='Tan Smart Leather Corkbed Sandals (Younger)']")).getText();
			
			Assert.assertTrue(sandalsSearchTitle.contains(expectedWordInResult), "The result found does not match the query! " + expectedWordInResult + "'");
			

}
