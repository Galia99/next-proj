package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.next.proj.nextG_proj.infra.Web.By2;

public class MyAccountPage extends AbstractPage{

	private static final By2 editSignInDetailsButton = new By2("'Edit signin details button'", By.id("btnUpdateSigninDetails"));
	private static final By2 hiMrsGalinaKhononovTitle = new By2("'Hi Mrs Galina Khononov title'", By.xpath("//h1[@class='heading']"));
	private static final By2 editBillingAddressButton = new By2("'Edit Billing Address button'", By.id("button_Panel_update_billing_address"));
	private static final By2 billingAddressInformation = new By2("'billing address information in My Account page'", By.xpath("//div[@class='address']"));

	public MyAccountPage(WebDriver driver) throws Exception {
		super(driver, hiMrsGalinaKhononovTitle);

	}

	public UpdateSignInDetailsPage clickOnEditSigninDetailsButton() throws Exception {
		bot.click(editSignInDetailsButton);
		return new UpdateSignInDetailsPage(driver);
	}
	
	public String gethiMrsGalinaKhononovTitle() throws Exception {
		bot.getElementText(hiMrsGalinaKhononovTitle);
		return bot.getElementText(hiMrsGalinaKhononovTitle);
	}
	
	
	public UpdateDeliveryAddressDetailsPage clickOnEditBillingAddressButton() throws Exception {
		bot.click(editBillingAddressButton);
		return new UpdateDeliveryAddressDetailsPage(driver);
	}
	
	
	public String getbillingAddressInformation()  {
		
		return bot.getElementText(billingAddressInformation);
	}
}