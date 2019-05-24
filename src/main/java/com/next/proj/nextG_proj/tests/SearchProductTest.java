package com.next.proj.nextG_proj.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.pages.NextLandingPage;


public class SearchProductTest  extends AbstractTest{

	@Test
	public void _04_searchProductsTest() throws Exception {

		String searchTerm ="Sunglasses Silver Aviator";

		driver.get("https://www.next.co.il/en");

		//Login to next.com
		WebElement myAccountButton = driver.findElement(By.xpath("//a[@data-link-id='DataLinkId']"));
		myAccountButton.click();

		driver.findElement(By.id("EmailOrAccountNumber")).sendKeys("galinaltman@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("galina@22");
		driver.findElement(By.id("SignInNow")).click();

		//write to search box
		NextLandingPage nextLandingPage = new NextLandingPage(driver);
		nextLandingPage.writeToSearchBox(searchTerm);
		nextLandingPage.clickOnseachItemsButton();
		/*WebElement searchBox = driver.findElement(By.xpath("//input[@class='SearchBox']"));
		searchBox.sendKeys("Sunglasses Silver Aviator");
		WebElement seachItemsButton = driver.findElement(By.xpath("//input[@class='SearchButton']"));
		searchBox.sendKeys(Keys.ENTER);
		 */
		//Open item page.
		driver.findElement(By.xpath(("//article[@id='i1']"))).click();		
	}
}