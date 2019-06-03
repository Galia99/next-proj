package com.next.proj.nextG_proj.tests;

import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.MyAccountPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;

public class LoginTest extends AbstractTest{

	@Test
	public void _01_LoginTestToNext() throws Exception {

		String email = "GalinaLtman@gmail.com";
		String password = "galina@40";
		
		//Step 1 - Browse to next.co.il landing page
		report.startLevel("Step 1 - Browse to next.co.il landing page.");
		browseToUrl("https://www.next.co.il/en");
		LandingPage landingPage = new LandingPage(driver);
		report.endLevel();
		
		//Step 2 - click on "My Account Button"
		report.startLevel("Step 2 - click on \"My Account\" button, browse to Sign In To page.");
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();
		report.endLevel();
		
		//Step 3 - Enter Password, Email and click on "Sign In Now" button
		report.startLevel("Step 3 - Enter Password, Email and click on \"Sign In Now\" button, browse to My Account page.");
		signInToNextPage.writeToemailField(email);
		signInToNextPage.writeToPasswordField(password);
		MyAccountPage myAccountPage = signInToNextPage.clickTosignInNowButton();
		report.endLevel();
		
		//Step 4 - click on sign in now button and check that we are on the "My Account" page
		report.startLevel("Step 4 - Click on \"Sign In Now\" button and check that we are on the My Account page.");
		myAccountPage.gethiMrsGalinaKhononovTitle();
		report.endLevel();
	}
}
