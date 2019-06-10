package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.next.proj.nextG_proj.infra.Web.By2;

public class UpdateSignInDetailsPage extends AbstractPage{

	private static final By2 newPasswordField = new By2("'New password field'", By.id("Password"));
	private static final By2 updateButton = new By2("'Update, sign in and details button'", By.id("btneditSigninDetails"));
	private static final By2 passwordValidationMessageTitle = new By2("'Password validation message, when entering invalid password in Sign In Details page'", By.id("Password-validation-message"));
	private static final By2 updateSignInDetailsTitle = new By2("'update sign in details title'", By.xpath("//label[text()='Update Sign In Details']"));

	public UpdateSignInDetailsPage(WebDriver driver) throws Exception {
		super(driver, updateSignInDetailsTitle);

	}

	public void writeToNewPasswordField(String newPassword) {
		bot.writeToElement(newPasswordField, newPassword);
	}

	public MyAccountPage clickToUpdateButton() throws Exception {
		bot.click(updateButton);
		return new MyAccountPage(driver);
	}
	
	public String getPasswordValidationMessageTitle() {
		bot.getElementText(passwordValidationMessageTitle);
		return bot.getElementText(passwordValidationMessageTitle);
	}
}
