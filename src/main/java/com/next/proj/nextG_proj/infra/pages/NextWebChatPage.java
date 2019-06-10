package com.next.proj.nextG_proj.infra.pages;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.joestelmach.natty.Parser;
import com.next.proj.nextG_proj.infra.Web.By2;

public class NextWebChatPage extends AbstractPage {

	
	private static final By2 exitButton = new By2("'Close Live Chat button'", By.id("exitButton"));
	private static final By2 timeStamp = new By2("'Close Live Chat button'", By.xpath("//div[@class='iwt-message-time sm-pull-right']"));

	public NextWebChatPage(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void clickOnExitButton() {
		bot.click(exitButton);
	}
	
	public String getChatTimeText() {
		String timeStampString = bot.getElementText(timeStamp);
		return timeStampString;
		
	}
	
	public String getChatDate(String chatTimeStamp) {
		List<Date> dates = new Parser().parse(chatTimeStamp).get(0).getDates();
		
		LocalDate nextSiteDate = dates.get(0).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int chatYear  = nextSiteDate.getYear();
		int chatMonth = nextSiteDate.getDayOfMonth();
		int chatDay   = nextSiteDate.getMonthValue();
		String chatDate = chatDay + "/" + chatMonth + "/" + chatYear;
		
		return chatDate;
	}
	
	public String getCurrentDate() {
		Date currentDateTime = new Date();
		LocalDate locatDate = currentDateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int localYear  = locatDate.getYear();
		int localMonth = locatDate.getMonthValue();
		int localDay   = locatDate.getDayOfMonth();
		
		String currentDate = localDay + "/" + localMonth + "/" + localYear;
		
		return currentDate;
	}
}
