package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.next.proj.nextG_proj.infra.Web.By2;

public class FavouritePage extends AbstractPage {

	private static final By2 counterFavourites = new By2("'counter afvourites'", By.id("favouriteItemsCountTarget"));
	private static final By2 removeItemButton = new By2("'remove item from favourite page button'", By.xpath("//a[@class='remove-item-link']"));



	//Constractor
	public FavouritePage(WebDriver driver) throws Exception {
		super(driver);
	}

	public int getTextCounterFavourites() {
		String count = bot.getElementText(counterFavourites);
		int countNum = Integer.parseInt(count);
		return countNum;
	}
	public void clickOnRemoveItemButton() {
		bot.click(removeItemButton);
		}
}
