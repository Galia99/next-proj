package com.next.proj.nextG_proj.tests;

import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.config.MainConfig;
import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.MyAccountPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;

public class LoginTest extends AbstractTest{

	@Test
	public void _007_LoginTest() throws Exception {
		
		//Step 1 - Browse to next.co.il landing page, and go to english web site
		report.startLevel("Step 1 - Browse to next.co.il landing page, and go to english web site.");
		browseToUrl(MainConfig.baseUrl);
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goToEnglishWebsite();
		report.endLevel();
		 
		//Step 2 - Click on "My Account" button, browse to Sign In To page
		report.startLevel("Step 2 - Click on \"My Account\" button, browse to Sign In To page.");
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();
		report.endLevel();
		
		//Step 3 - Enter Password, Email and click on \"Sign In Now\" button, browse to My Account page
		report.startLevel("Step 3 - Enter Password, Email and click on \"Sign In Now\" button, browse to My Account page.");
		signInToNextPage.writeToemailField(MainConfig.username);
		signInToNextPage.writeToPasswordField(MainConfig.password);
		MyAccountPage myAccountPage = signInToNextPage.clickTosignInNowButtonReturnMyAccountPage();
		report.endLevel();
		
		//Step 4 - Click on sign in now button and check that we are on the "My Account" page
		report.startLevel("Step 4 - Click on \"Sign In Now\" button and check that we are on the My Account page.");
		myAccountPage.gethiMrsGalinaKhononovTitle();
		report.endLevel();
		
		//Step 5 - Log Out from Next, click on \"My Account\" button, then click on sign out button
		report.startLevel("step 5 - Log Out from Next, click on \"My Account\" button, then click on sign out button.");
		landingPage.clickOnmyAccountButton();
		landingPage.clickOnmyAccountSignOut();
		report.endLevel();
	}
}
