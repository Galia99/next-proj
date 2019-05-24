package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemsInBagPage  extends NextAbstractPage {

	private static final By viewEditBagButton = By.cssSelector("a[class='view_edit_bag']");

	public ItemsInBagPage(WebDriver driver) throws Exception {
		super(driver, viewEditBagButton);
	}

	public void clickOnviewEditBagButton () throws Exception {
		driver.findElement(viewEditBagButton).click();

	}
}