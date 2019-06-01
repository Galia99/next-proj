package com.next.proj.nextG_proj.infra.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.next.proj.nextG_proj.infra.Web.By2;

public class ProductPage extends AbstractPage{

	private static final By2 addToBagButton = new By2("'add to bag button'", By.xpath("//a[text()='Add To Bag']"));
	private static final By2 productTitle = new By2("'product title'", By.xpath("//div[@class='Title']"));
	private static final By2 viewEditBagButton = new By2("'view edit bag button'", By.cssSelector("a[class='view_edit_bag']"));

	public ProductPage(WebDriver driver) throws Exception {
		super(driver, addToBagButton, productTitle);
	}
	public void clickOnaddToBagButton () {
		bot.click(addToBagButton);
		//driver.findElement(addToBagButton).click();
	}

	public String getProductTitle () {
		return bot.getElementText(productTitle);
	}
	/*
	 * public NextShoppingBagPage clickOnviewEditBagButton () throws Exception {
	 * driver.findElement(viewEditBagButton).click();
	 * 
	 * if (viewEditBagButtonVisible()) { clickOnviewEditBagButton(); }
	 * 
	 * return new NextShoppingBagPage(driver); }
	 */
	 
	 public ShoppingBagPage clickOnviewEditBagButton () throws Exception {
			
			if (viewEditBagButtonVisible()) {
				//write here that this page exists
				System.out.println("The bag of items is shown");
				bot.click(viewEditBagButton);
			}
	
			return new ShoppingBagPage(driver);
	}
	 
	public boolean viewEditBagButtonVisible() {
		
		List<WebElement> elements = driver.findElements(viewEditBagButton.by);
		if (elements.size() > 0) {
			return elements.get(0).isDisplayed();
		}
		return false;
	}
	
	/*public boolean isviewEditBagButtonVisible () {
	
	try {
		WebElement xButton = driver.findElement(viewEditBagButton);//if xButton exists and displayet
		driver.findElement(viewEditBagButton).click();
		return xButton.isDisplayed();
	}
	catch (NoSuchElementException e) { //if xButton exists but is not displayet
		return false;
	}
}/*
	//-------------------------------------(Or)--------------------------------
	/*public boolean isviewEditBagButtonVisible () {// kak pojmat' ne postoyannyj popap

		List<WebElement> elements = driver.findElements(viewEditBagButton);
		if (elements.size() > 0) {
			return elements.get(0).isDisplayed();
		}
		return false;
		*/
	
		//-----------------------------(Or)----------------------------------------------
	
		/*try {
			WebElement xButton = driver.findElement(viewEditBagButton);//if xButton exists and displayet
			return xButton.isDisplayed();
			
		}
		catch (NoSuchElementException e) { //if xButton exists but is not displayet
			return false;
		}
	}*/
}
