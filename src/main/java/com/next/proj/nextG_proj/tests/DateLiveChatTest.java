package com.next.proj.nextG_proj.tests;

import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.config.MainConfig;
import com.next.proj.nextG_proj.infra.pages.CustomerServicesPage;
import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.NextWebChatPage;
import com.next.proj.nextG_proj.infra.utils.AssertUtils;

public class DateLiveChatTest extends AbstractTest{

	@Test
	public void _009_dateLiveChatTest () throws Exception {

		//Step 1 - Browse to next.co.il landing page, and go to english web site
		report.startLevel("Step 1 - Browse to next.co.il landing page, and go to english web site.");
		browseToUrl(MainConfig.baseUrl);
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goToEnglishWebsite();
		report.endLevel();

		//Step 2 -  Click on the help button, switch to customer services page window
		report.startLevel("Step 2 - Click on the help button, switch to customer services page window.");
		String winHandleBefore = driver.getWindowHandle();
		CustomerServicesPage customerServicesPage = landingPage.clickOnHelpButton();
		String winHandleHelpPage = null;
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    winHandleHelpPage = driver.getWindowHandle();
		}
		report.endLevel();
		
		//Step 3 - Click on the chat button, switch to live chat window
		report.startLevel("Step 3 - Click on the chat button, switch to live chat window.");
		NextWebChatPage nextWebChatPage =  customerServicesPage.clickOnarrowImgButton();
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		report.endLevel();
		
		//Step 4 - Get date from live chat window, get current date, assert that chat date and current date are equal
		report.startLevel("Step 4 - Get date from live chat window, get current date, assert that chat date and current date are equal.");
		String chatTimeStamp = nextWebChatPage.getChatTimeText();
		String chatDate =  nextWebChatPage.getChatDate(chatTimeStamp);
		String currentDate = nextWebChatPage.getCurrentDate();
		
		AssertUtils.assertTrue(chatDate.equals(currentDate), "Chat date is: "+chatDate+" and it is equal to the current date: "+currentDate);
		report.endLevel();
		
		//Step 5 - Close live chat window, close customer services page window, switch to landing page
		report.startLevel("Step 5 - Close live chat window, close customer services page window, switch to landing page.");
		driver.close();
		driver.switchTo().window(winHandleHelpPage);
		driver.close();
		driver.switchTo().window(winHandleBefore);
		report.endLevel();
	}
}
