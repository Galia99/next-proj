package com.next.proj.nextG_proj.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.pages.NextLandingPage;
import com.next.proj.nextG_proj.infra.pages.NextSearchResultsPage;

public class SearchProductNegativeTest  extends AbstractTest{

	@Test
	public void _003_searchProductNegativeTest() throws Exception {

		//Search and compare data.
		String searchTerm = "Shoes";
		String expectedWordInResultSunglasses ="Sunglasses";  

		driver.get("https://www.next.co.il/en");

		//Open logIn window.
		WebElement myAccountButton = driver.findElement(By.xpath("//a[@data-link-id='DataLinkId']"));
		myAccountButton.click();

		//Enter "LogIn" parameters and click on "SignIn" button
		driver.findElement(By.id("EmailOrAccountNumber")).sendKeys("galinaltman@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("galina@22");
		driver.findElement(By.id("SignInNow")).click();

		//Write search box.
		NextLandingPage nextLandingPage = new NextLandingPage(driver);
		nextLandingPage.writeToSearchBox(searchTerm);

		//Click on "Item Button".
		NextSearchResultsPage nextSearchResultsPage = nextLandingPage.clickOnseachItemsButton();

		//????????????
		String sandalsSearchTitle = nextSearchResultsPage.getSandalsSearchTitle();  	

		//Check search result.
		Assert.assertTrue(sandalsSearchTitle.contains(expectedWordInResultSunglasses), "The result found does not match the query! " + expectedWordInResultSunglasses + "'");
	}
}
