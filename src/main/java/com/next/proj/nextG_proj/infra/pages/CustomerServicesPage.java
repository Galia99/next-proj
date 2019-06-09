package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.next.proj.nextG_proj.infra.Web.By2;

public class CustomerServicesPage extends AbstractPage {

	private static final By2 arrowImgButton = new By2("'Open live Chat Link'",  By.xpath("//a[@href='#']/img[@class='arrow']"));


	public CustomerServicesPage(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public NextWebChatPage clickOnarrowImgButton() throws Exception {
		bot.click(arrowImgButton);
		return new NextWebChatPage(driver);
	}
}
