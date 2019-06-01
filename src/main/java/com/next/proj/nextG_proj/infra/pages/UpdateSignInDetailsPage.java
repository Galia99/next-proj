package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.next.proj.nextG_proj.infra.Web.By2;

public class UpdateSignInDetailsPage extends AbstractPage{

	private static final By2 newPasswordField = new By2("'new password field'", By.id("Password"));
	private static final By2 updateButton = new By2("'sign in details update button'", By.id("btneditSigninDetails"));
	private static final By2 passwordValidationMessageTitle = new By2("'password validation message title'", By.id("Password-validation-message"));
	private static final By2 updateSignInDetailsLabel = new By2("'update sign in details label'", By.xpath("//label[text()='Update Sign In Details']"));

	
	public UpdateSignInDetailsPage(WebDriver driver) throws Exception {
		super(driver, updateSignInDetailsLabel);

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
	
	/*public String getaddressValidationWarningMessageTitle() {
		bot.getElementText(addressValidationWarningMessageTitle);
		return driver.findElement(addressValidationWarningMessageTitle).getText();
	}
	
	public void clickOnCancelButton () throws Exception {
		
		try {
			bot.click(cancelButton);
		} catch (Exception e) {
		    new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
		    bot.click(cancelButton);
		}
	
	}*/
}
