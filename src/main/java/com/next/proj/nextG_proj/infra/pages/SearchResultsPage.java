package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.next.proj.nextG_proj.infra.Web.By2;

public class SearchResultsPage extends AbstractPage {
	
	private static final By2 sandalsSearchTitle = new By2("'Sandals search result title'", By.xpath("//a[@data-label='Tan Smart Leather Corkbed Sandals (Younger)']"));
	private static final By2 aviatorSunglassesTitle = new By2("'Search result Aviator Sun Glasses title'", By.xpath("//article[@id='i1']"));
	private static final By2 addToFavouritesHeartButton = new By2("'add to Favourites Heart button on the product link'", By.xpath("//article[@id='i1']//a[@class='heart add plp desktop']"));
	
	
	public SearchResultsPage(WebDriver driver) throws Exception {
		super(driver);
	}
	public String getSandalsSearchTitle() {
		return bot.getElementText(sandalsSearchTitle);
	}
	
	public String getsilverAviatorStyleSunglasses() {
		return bot.getElementText(aviatorSunglassesTitle);
	}
	
	public ProductPage clickOnsilverAviatorStyleSunglasses() throws Exception {
		bot.click(aviatorSunglassesTitle);
		return new ProductPage(driver);
	}
	
	public void clickToAddToFavouritesHeartButton() {
		bot.click(addToFavouritesHeartButton);
		
	}
	
	/*public void clickOnsilverAviatorStyleSunglassesById(int resultId) {
		driver.findElement(aviatorSunglassesTitle).click();
	}*/
	
	/*public void clickOnsilverAviatorStyleSunglassesById(int resultId) {
		By resultTitle = By.xpath("//article[@id='" + resultId + "']");
		driver.findElement(resultTitle).click();
	}*/
}
