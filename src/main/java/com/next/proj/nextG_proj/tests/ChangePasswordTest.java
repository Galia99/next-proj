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
		report.startLevel("Step 1 - Browse to next.co.il landing page.");
		browseToUrl("https://www.next.co.il/en");
		LandingPage landingPage = new LandingPage(driver);
		report.endLevel();
		
		//Step 2 - click on "My Account" Button from Landing Page
		report.startLevel("Step 2 - Click on \"My Account\" button, browse to Sign In To page.");
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();
		report.endLevel();
		
		//Step 3 - Enter Password, Email and click on \"Sign In Now\" button, browse to My Account page.
		report.startLevel("Step 3 - Enter Password, Email and click on \"Sign In Now\" button.");
		signInToNextPage.writeToemailField(email);
		signInToNextPage.writeToPasswordField(oldPassword);
		signInToNextPage.clickTosignInNowButton();
		report.endLevel();
		
		//Step 4 - In SIGN IN DETAILS, click on \"EDIT\" button, browse to Update Sign In Details page
		report.startLevel("Step 4 - In SIGN IN DETAILS, click on \"EDIT\" button, browse to Update Sign In Details page.");
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		UpdateSignInDetailsPage updateSignInDetailsPage = myAccountPage.clickOnEditSigninDetailsButton();
		report.endLevel();
		
		//Step 5 - enter new password and click "UPDATE" button
		report.startLevel("Step 5 - Enter new password and click \"UPDATE\" button.");
		updateSignInDetailsPage.writeToNewPasswordField(newPassword);
		updateSignInDetailsPage.clickToUpdateButton();
		report.endLevel();
		
		//Step 6 - click to "My Account link active" button, then click on "My Account SignOut" button
		report.startLevel("Step 6 - Click to \"My Account link active\" button, then click on \"My Account SignOut\" button.");
		landingPage.clickOnMyAccountlinkActive();
		landingPage.clickOnmyAccountSignOut();
		report.endLevel();
		
		//Step 7 - Enter old Password, Email, and click on "Sign In Now" button
		report.startLevel("Step 7 - Enter old Password, Email, and click on \"Sign In Now\" button.");
		signInToNextPage.writeToemailField(email);
		signInToNextPage.writeToPasswordField(oldPassword);
		signInToNextPage.clickTosignInNowButton();
		report.endLevel();
		
		//Step 8 - check "Password validation message" and confirm the correct message 
		report.startLevel("Step 8 - Check \"Password validation message\" and confirm the correct message .");
		String warningMessageTitel = signInToNextPage.getTextWarningMessageTitle();
		Assert.assertEquals(warningMessageTitel, "Sorry, we have been unable to sign you in."); 
		report.endLevel();
		
		//Step 7 - reenter new password and click on "UPDATE" button
		report.startLevel("Step 1 - Reenter new password and click on \"UPDATE\" button.");
		signInToNextPage.writeToPasswordField(newPassword);
		signInToNextPage.clickTosignInNowButton();
		report.endLevel();
	}
}
