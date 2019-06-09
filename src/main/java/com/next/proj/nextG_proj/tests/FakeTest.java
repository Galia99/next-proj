package com.next.proj.nextG_proj.tests;

import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.config.MainConfig;
import com.next.proj.nextG_proj.infra.pages.CustomerServicesPage;
import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.NextWebChatPage;

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
		report.startLevel("uyhgitguytfyjgluihli.");
		CustomerServicesPage customerServicesPage = landingPage.clickOnHelpButton();
		report.endLevel();
		
		//Step-2  ar and click the "search items" button
		report.startLevel("blkguyfrfrkuygkugku.");
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		 customerServicesPage.clickOnarrowImgButton();
		report.endLevel();

		//
	//	nextWebChatPage
	//	nextWebChatPage
	}
}
