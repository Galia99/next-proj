package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.next.proj.nextG_proj.infra.Web.By2;

public class SearchResultsPage extends AbstractPage {
	
	
	private static final By2 searchFirstResultTitle = new By2("'Search first result title'", By.xpath("//article[@id='i1']"));
	private static final By2 addToFavouritesHeartButton = new By2("'add to Favourites Heart button on the product link'", By.xpath("//article[@id='i1']//a[@class='heart add plp desktop']"));
	private static final By2 removeFromFavouritesHeartButton = new By2("'add to Favourites Heart button on the product link'", By.xpath("//article[@id='i1']//a[@class='heart plp desktop remove']"));
	
	public SearchResultsPage(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public String getSearchResultTitleById(int resultId) throws Exception{
		By2 resultTitle = new By2("Title of search result #" + resultId, By.id("i" + resultId +""));
		return bot.getElementText(resultTitle);
	}
	
	public String getSearchFirstResultTitle() {
		return bot.getElementText(searchFirstResultTitle);
	}
	
	public ProductPage clickSearchFirstResultTitle() throws Exception {
		bot.click(searchFirstResultTitle);
		return new ProductPage(driver);
	}
	
	public void clickToAddToFavouritesHeartButton() {
		bot.click(addToFavouritesHeartButton);
		
	}
	
	public void clickToRemoveFromFavouritesHeartButton() {
		bot.click(removeFromFavouritesHeartButton);
	}
}
