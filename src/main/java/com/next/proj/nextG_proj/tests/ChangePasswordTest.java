package com.next.proj.nextG_proj.tests;

import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.config.MainConfig;
import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.MyAccountPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;
import com.next.proj.nextG_proj.infra.pages.UpdateSignInDetailsPage;
import com.next.proj.nextG_proj.infra.utils.AssertUtils;

public class ChangePasswordTest  extends AbstractTest{

	@Test
	public void _010_ChangePasswordTest () throws Exception {

		//Step 1 - Browse to next.co.il landing page, and go to english web site
		report.startLevel("Step 1 - Browse to next.co.il landing page, and go to english web site.");
		browseToUrl(MainConfig.baseUrl);
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goToEnglishWebsite();
		report.endLevel();
		
		//Step 2 - Click on "My Account" Button from Landing page, browse to Sign In To page
		report.startLevel("Step 2 - Click on \"My Account\" button, browse to Sign In To page.");
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();
		report.endLevel();
		
		//Step 3 - Enter Password, Email and click on \"Sign In Now\" button, browse to My Account page.
		report.startLevel("Step 3 - Enter Password, Email and click on \"Sign In Now\" button.");
		signInToNextPage.writeToemailField(MainConfig.username);
		signInToNextPage.writeToPasswordField(MainConfig.password);
		signInToNextPage.clickTosignInNowButtonVoidFunction();
		report.endLevel();
		
		//Step 4 - In SIGN IN DETAILS, click on \"EDIT\" button, browse to Update Sign In Details page
		report.startLevel("Step 4 - In SIGN IN DETAILS, click on \"EDIT\" button, browse to Update Sign In Details page.");
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		UpdateSignInDetailsPage updateSignInDetailsPage = myAccountPage.clickOnEditSigninDetailsButton();
		report.endLevel();
		
		//Step 5 - Enter new password and click "UPDATE" button
		report.startLevel("Step 5 - Enter new password and click \"UPDATE\" button.");
		updateSignInDetailsPage.writeToNewPasswordField(MainConfig.newPassword);
		updateSignInDetailsPage.clickToUpdateButton();
		report.endLevel();
		
		//Step 6 - click to "My Account link active" button, then click on "My Account SignOut" button
		report.startLevel("Step 6 - Click to \"My Account link active\" button, then click on \"My Account SignOut\" button.");
		landingPage.clickOnMyAccountlinkActive();
		landingPage.clickOnmyAccountSignOut();
		report.endLevel();
		
		//Step 7 - Enter old Password, Email, and click on "Sign In Now" button
		report.startLevel("Step 7 - Enter old Password, Email, and click on \"Sign In Now\" button.");
		signInToNextPage.writeToemailField(MainConfig.username);
		signInToNextPage.writeToPasswordField(MainConfig.password);
		signInToNextPage.clickTosignInNowButtonVoidFunction();
		report.endLevel();
		
		//Step 8 - Check "Password validation message" and confirm the correct message 
		report.startLevel("Step 8 - Check \"Password validation message\" and confirm the correct message .");
		String actualWarningMessageTitle = signInToNextPage.getTextWarningMessageTitle();
		String expectedWarningMessageTitle = "Sorry, we have been unable to sign you in.";
		AssertUtils.assertEquals(actualWarningMessageTitle,expectedWarningMessageTitle ,"The actual message is not the same as the expected message"); 
		report.endLevel();
		
		//Step 9 - Reenter new password and click on "Sign In Now " button
		report.startLevel("Step 9 - Reenter new password and click on \"Sign In Now \" button.");	
		signInToNextPage.writeToPasswordField(MainConfig.newPassword);
		signInToNextPage.clickTosignInNowButtonVoidFunction();
		report.endLevel();
		
		//Step 10 - Log Out from Next, lick on \"My Account\" button, after click on sign out button.
		report.startLevel("step 10 - Log Out from Next, lick on \"My Account\" button, after click on sign out button.");
		landingPage.clickOnmyAccountButton();
		landingPage.clickOnmyAccountSignOut();
		report.endLevel();
	}
}
