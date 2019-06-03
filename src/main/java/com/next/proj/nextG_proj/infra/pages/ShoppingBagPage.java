package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.next.proj.nextG_proj.infra.Web.By2;

public class ShoppingBagPage extends AbstractPage{

	private static final By2 bagCounterSpan = new By2("'Bag counter span'", By.xpath("//a[@class='dk_toggle dk_label']"));
	private static final By2 shoppingBagTitle = new By2("'Shopping Bag page title'", By.xpath("//h1[contains(text(),'SHOPPING BAG')]"));
	private static final By2 removeThisItemButton = new By2("'Remove item from bag button'", By.xpath("//a[@title='Click to remove this item']"));
  
	public ShoppingBagPage(WebDriver driver) throws Exception{
		super(driver, shoppingBagTitle);
	}
	
	public int getBagCounterConteiner() {
		
		String bagCounterText = bot.getElementText(bagCounterSpan);
		//String bagCounterText = driver.findElement(bagCounterSpan).getText();
		int bagCounter = Integer.parseInt(bagCounterText);
		return bagCounter;
	} 
	
	public void clickOnRemoveThisItemButton(){
		bot.click(removeThisItemButton);
	}
}
