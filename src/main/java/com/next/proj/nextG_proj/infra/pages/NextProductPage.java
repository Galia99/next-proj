package com.next.proj.nextG_proj.infra.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NextProductPage extends NextAbstractPage{

	private static final By addToBagButton = By.xpath("//article[@id='Style16796']//a[text()='Add To Bag']");
	private static final By productTitle = By.xpath("//h1[text()='Ray-Ban® Aviator Sunglasses']");
	private static final By viewEditBagButton = By.cssSelector("a[class='view_edit_bag']");


	public NextProductPage(WebDriver driver) throws Exception {
		super(driver, addToBagButton, productTitle);
	}
	public void clickOnaddToBagButton () {
		driver.findElement(addToBagButton).click();
	}

	
	/*
	 * public NextShoppingBagPage clickOnviewEditBagButton () throws Exception {
	 * driver.findElement(viewEditBagButton).click();
	 * 
	 * if (viewEditBagButtonVisible()) { clickOnviewEditBagButton(); }
	 * 
	 * return new NextShoppingBagPage(driver); }
	 */
	 
	 public NextShoppingBagPage clickOnviewEditBagButton () throws Exception {
			
			
			if (viewEditBagButtonVisible()) {
				//write here that this page exists
				System.out.println("The bag of items is shown");
				driver.findElement(viewEditBagButton).click();
			}
			
			
		return new NextShoppingBagPage(driver);
	}
	 
	 
	public boolean viewEditBagButtonVisible() {
		
		List<WebElement> elements = driver.findElements(viewEditBagButton);
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
