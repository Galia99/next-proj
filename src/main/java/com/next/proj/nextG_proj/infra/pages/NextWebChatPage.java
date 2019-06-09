package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.next.proj.nextG_proj.infra.Web.By2;

public class NextWebChatPage extends AbstractPage {

	
	private static final By2 exitButton = new By2("'Close Live Chat button'", By.id("exitButton"));
	private static final By2 time = new By2("'Close Live Chat button'", By.xpath("//div[@class='iwt-message-time sm-pull-right']"));



	public NextWebChatPage(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void clickOnexitButton() {
		bot.click(exitButton);
	}
}
