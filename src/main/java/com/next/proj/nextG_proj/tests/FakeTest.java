package com.next.proj.nextG_proj.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.testng.annotations.Test;

import com.joestelmach.natty.*;
import com.next.proj.nextG_proj.infra.config.MainConfig;
import com.next.proj.nextG_proj.infra.pages.CustomerServicesPage;
import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.NextWebChatPage;
import com.next.proj.nextG_proj.infra.utils.AssertUtils;

public class FakeTest extends AbstractTest{

	@Test
	public void _009_timeLiveChatTest () throws Exception {


		//Step 1 - Browse to next.co.il landing page
		report.startLevel("Step 1 - Browse to next.co.il landing page, and go to english web site.");
		browseToUrl(MainConfig.baseUrl);
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goToEnglishWebsite();
		report.endLevel();

		//Step-2  ar and click the "search items" button
		report.startLevel("Step 2 - Click on the help button, switch to help window.");
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		
		CustomerServicesPage customerServicesPage = landingPage.clickOnHelpButton();
		// Switch to new window opened - help site
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		report.endLevel();
		
		report.startLevel("Step 3 - Click on the chat button, switch to chat window.");
		NextWebChatPage nextWebChatPage =  customerServicesPage.clickOnarrowImgButton();
		
		//switch to new window opened - chat window
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		report.endLevel();
		
		
		report.startLevel("Step 4 - Get time from chat window, assert that it is equal to current time.");
		String chatTimeStamp = nextWebChatPage.getChatTimeText();
		List<Date> dates = new Parser().parse(chatTimeStamp).get(0).getDates();
		
		
		
		Date chatDate = new SimpleDateFormat("dd/MM/yyyy").parse(dates.get(0).toString());  
		Date currentDateTime = new Date();
		
		AssertUtils.assertTrue(chatDate.equals(currentDateTime), "the text is: "+chatTimeStamp+" Chat date is: "+chatDate+" and it is equal to the current date: "+currentDateTime);
		report.endLevel();
		
		
		report.startLevel("Step 5 - Go back to the main page.");
		// Close the new window, if that window is not required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		report.endLevel();
		

		//
	//	nextWebChatPage
	//	nextWebChatPage
	}
}
