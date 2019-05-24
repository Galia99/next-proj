package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NextShoppingBagPage extends NextAbstractPage{

	private static final By bagCounterConteiner = By.id("#dk_container_Qty_2");
	private static final By shoppingBagTitle = By.xpath("//h1[contains(text(),'SHOPPING BAG')]");
	
	public NextShoppingBagPage(WebDriver driver) throws Exception{
		super(driver, shoppingBagTitle, bagCounterConteiner);
	}
	
	public int getBagCounterConteiner() {
		
		String bagCounterText = driver.findElement(bagCounterConteiner).getText();
		int bagCounter = Integer.parseInt(bagCounterText);
		return bagCounter;
	}
}
