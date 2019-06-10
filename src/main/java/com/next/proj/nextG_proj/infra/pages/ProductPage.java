package com.next.proj.nextG_proj.infra.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.next.proj.nextG_proj.infra.Web.By2;

public class ProductPage extends AbstractPage{

	private static final By2 addToBagButton = new By2("'Add to bag button'", By.xpath("//a[text()='Add To Bag']"));
	private static final By2 productTitle = new By2("'Product title'", By.xpath("//div[@class='Title']"));
	private static final By2 viewEditBagButton = new By2("'View edit in bag button'", By.cssSelector("a[class='view_edit_bag']"));

	public ProductPage(WebDriver driver) throws Exception {
		super(driver, addToBagButton, productTitle);
	}
	public void clickOnaddToBagButton () {
		bot.click(addToBagButton);
		
	}

	public String getProductTitle () {
		return bot.getElementText(productTitle);
	}
	 
	 public ShoppingBagPage clickOnviewEditBagButton () throws Exception {
			
			if (viewEditBagButtonVisible()) {
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
}
