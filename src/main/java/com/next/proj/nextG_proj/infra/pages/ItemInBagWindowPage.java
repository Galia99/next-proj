package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.next.proj.nextG_proj.infra.Web.By2;

public class ItemInBagWindowPage  extends AbstractPage {

	private static final By2 viewEditBagButton = new By2("'view edit bag button'", By.cssSelector("a[class='view_edit_bag']"));

	public ItemInBagWindowPage(WebDriver driver) throws Exception {
		super(driver, viewEditBagButton);
	}

	public void clickOnviewEditBagButton () throws Exception {
	bot.click(viewEditBagButton);
	}
}