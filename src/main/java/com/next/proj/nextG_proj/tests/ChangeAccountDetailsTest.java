package com.next.proj.nextG_proj.tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.config.MainConfig;
import com.next.proj.nextG_proj.infra.pages.LandingPage;
import com.next.proj.nextG_proj.infra.pages.MyAccountPage;
import com.next.proj.nextG_proj.infra.pages.SignInToNextPage;
import com.next.proj.nextG_proj.infra.pages.UpdateDeliveryAddressDetailsPage;
import com.next.proj.nextG_proj.infra.utils.AssertUtils;

public class ChangeAccountDetailsTest extends AbstractTest {

	@Test
	public void _008_ChangeAccountDetailsTest() throws Exception {

		//Step 1 - Browse to next.co.il landing page
		report.startLevel("Step 1 - Browse to next.co.il landing page, and go to english web site.");
		browseToUrl(MainConfig.baseUrl);
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goToEnglishWebsite();
		report.endLevel();

		//Step 2 - Click on "My Account" button, browse to Sign In To page.
		report.startLevel("Step 2 - Click on \"My Account\" button, browse to Sign In To page.");
		SignInToNextPage signInToNextPage = landingPage.clickOnmyAccountButton();
		report.endLevel();

		//Step 3 - Enter Password, Email and click on "Sign In Now" button
		report.startLevel("Step 3 - Enter Password, Email and click on \"Sign In Now\" button, browse to My Account page.");
		signInToNextPage.writeToemailField(MainConfig.username);
		signInToNextPage.writeToPasswordField(MainConfig.password);
		MyAccountPage myAccountPage = signInToNextPage.clickTosignInNowButtonReturnMyAccountPage();
		report.endLevel();
	
		//Step 4 - From My Account page in BILLING ADDRESS window, click on "EDIT"  button, browse to Update Delivery Address Details page
		report.startLevel("Step 4 - In BILLING ADDRESS click on \"EDIT\"  button, browse to Update Delivery Address Details page.");
		String currentAddress = myAccountPage.getbillingAddressInformation();
		UpdateDeliveryAddressDetailsPage updateDeliveryAddressDetailsPage = myAccountPage.clickOnEditBillingAddressButton();
		report.endLevel(); 
		
		//Step 5 - Click to State Or Province field, select a random Province and click on \"Update\" button
		report.startLevel("Step 5 - Click to State Or Province field, select a random Province and click on \"Update\" button.");
		updateDeliveryAddressDetailsPage.clickToStateOrProvincefield();
		updateDeliveryAddressDetailsPage.selectRandomProvince(); 
		updateDeliveryAddressDetailsPage.clickOnUpdateButton();
		report.endLevel();
		
		//Step 6 - Get address information from myAccount page
		report.startLevel("Step 6 - Get address information from My Account page.");
		String newAddress = null;
		try {
			newAddress = myAccountPage.getbillingAddressInformation();
		}catch(NoSuchElementException e) {
			updateDeliveryAddressDetailsPage.clickOnUpdateButton();
			newAddress = myAccountPage.getbillingAddressInformation();
			System.out.println("Step 6 failed");
		}
		report.endLevel();
		
		//Step 7 - Assert that the old address and the new address are not equal
		report.startLevel("Step 7 - Assert that the old address and the new address are not equal.");
		AssertUtils.assertFalse(currentAddress.contains(newAddress), "The result found does not match the query!");
		report.endLevel();
		
		//step 8 - Log Out from Next, click on "My Account" button, then click on sign out button
		report.startLevel("Step 8 - Log Out from Next, click on \"My Account\" button, then click on sign out button.");
		landingPage.clickOnmyAccountButton();
		landingPage.clickOnmyAccountSignOut();
		report.endLevel();
	}	
}
