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
		browseToUrl("https://www.next.co.il/en");
		LandingPage landingPage = new LandingPage(driver);

		//Step 2 - click on "My Account Button"
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();

		//Step 3 - Enter Password, Email and click on "Sign In Now" button
		signInToNextPage.writeToemailField(email);
		signInToNextPage.writeToPasswordField(password);
		MyAccountPage myAccountPage = signInToNextPage.clickTosignInNowButton();
	
		//Step-4 from My Accaunt page in BILLING ADDRESS window, click on "EDIT"  button
		UpdateDeliveryAddressDetailsPage updateDeliveryAddressDetailsPage = myAccountPage.clickOnEditBillingAddressButton();
		
		//Step 5 - 
		updateDeliveryAddressDetailsPage.clickToStateOrProvincefield();
		updateDeliveryAddressDetailsPage.selectRandomProvince(); //HOCHU RANDOM!!!!
		updateDeliveryAddressDetailsPage.clickOnUpdateButton(); //PERVYI CLIK OTMECHAET IZMENENIYA
		
		//Step-4 get address information from myAccount page
		myAccountPage.getbillingAddressInformation();
	}	
}
