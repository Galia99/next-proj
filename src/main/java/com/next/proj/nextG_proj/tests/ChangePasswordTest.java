package com.next.proj.nextG_proj.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.MyAccountPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;
import com.next.proj.nextG_proj.infra.pages.UpdateSignInDetailsPage;

public class ChangePasswordTest  extends AbstractTest{

	@Test
	public void _05_ChangeAccountDetailsTest() throws Exception {

		String email = "galinaltman@gmail.com";
		String oldPassword = "galina@40";
		String newPassword = "galina@41";

		//Step 1 - Browse to next.co.il landing page
		browseToUrl("https://www.next.co.il/en");
		LandingPage landingPage = new LandingPage(driver);

		//Step 2 - click on "My Account" Button from Landing Page
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();

		//Step 3 - Enter Password, Email and click on "Sign In Now" button from Sign In page
		signInToNextPage.writeToemailField(email);
		signInToNextPage.writeToPasswordField(oldPassword);
		signInToNextPage.clickTosignInNowButton();

		//Step 4 - from My Accaunt page in SIGN IN DETAILS  window, click on "EDIT"  button
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		UpdateSignInDetailsPage updateSignInDetailsPage = myAccountPage.clickOnEditSigninDetailsButton();

		//Step 5 - enter new password and click "UPDATE" button
		updateSignInDetailsPage.writeToNewPasswordField(newPassword);
		updateSignInDetailsPage.clickToUpdateButton();

		//Step 8 - click to "My Account link active" button, then click on "My Account SignOut" button
		landingPage.clickOnMyAccountlinkActive();
		landingPage.clickOnmyAccountSignOut();
		
		//Step 3 - Enter old Password, Email, and click on "Sign In Now" button
		signInToNextPage.writeToemailField(email);
		signInToNextPage.writeToPasswordField(oldPassword);
		signInToNextPage.clickTosignInNowButton();
		
		//check "Password validation message" and confirm the correct message 
		String warningMessageTitel = signInToNextPage.getTextWarningMessageTitle();
		Assert.assertEquals(warningMessageTitel, "Sorry, we have been unable to sign you in."); 

		//Step 7 - reenter new password and click on "UPDATE" button
		signInToNextPage.writeToPasswordField(newPassword);
		signInToNextPage.clickTosignInNowButton();
	}
}
