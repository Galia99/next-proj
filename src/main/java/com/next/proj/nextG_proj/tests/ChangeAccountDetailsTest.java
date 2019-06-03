package com.next.proj.nextG_proj.tests;

import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.MyAccountPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;
import com.next.proj.nextG_proj.infra.pages.UpdateDeliveryAddressDetailsPage;

public class ChangeAccountDetailsTest extends AbstractTest {

	@Test
	public void _02_ChangeAccountDetailsTest() throws Exception {

		String email = "GalinaLtman@gmail.com";
		String password = "galina@40";
		
		//Step 1 - Browse to next.co.il landing page
		report.startLevel("Step 1 - Browse to next.co.il landing page.");
		browseToUrl("https://www.next.co.il/en");
		LandingPage landingPage = new LandingPage(driver);
		report.endLevel();

		//Step 2 - click on "My Account Button"
		report.startLevel("Step 2 - Click on \"My Account\" button, browse to Sign In To page.");
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();
		report.endLevel();

		//Step 3 - Enter Password, Email and click on "Sign In Now" button
		report.startLevel("Step 3 - Enter Password, Email and click on \"Sign In Now\" button, browse to My Account page.");
		signInToNextPage.writeToemailField(email);
		signInToNextPage.writeToPasswordField(password);
		MyAccountPage myAccountPage = signInToNextPage.clickTosignInNowButton();
		report.endLevel();
	
		//Step-4 from My Accaunt page in BILLING ADDRESS window, click on "EDIT"  button
		report.startLevel("Step 4 - In BILLING ADDRESS click on \"EDIT\"  button, browse to Update Delivery Address Details page.");
		UpdateDeliveryAddressDetailsPage updateDeliveryAddressDetailsPage = myAccountPage.clickOnEditBillingAddressButton();
		report.endLevel(); 
		
		//Step 5 - Click to State Or Province field, select Province with random and click on \"Update\" button
		report.startLevel("Step 5 - Click to State Or Province field, select Province with random and click on \"Update\" button.");
		updateDeliveryAddressDetailsPage.clickToStateOrProvincefield();
		updateDeliveryAddressDetailsPage.selectRandomProvince(); //IZMENIT" VYBO, NA POOCHEREDNYI
		updateDeliveryAddressDetailsPage.clickOnUpdateButton(); //PERVYI CLIK OTMECHAET IZMENENIYA
		report.endLevel();
		
		//Step-4 get address information from myAccount page
		report.startLevel("Step 6 - Get address information from My Account page.");
		myAccountPage.getbillingAddressInformation();
		report.endLevel();
	}	
}
