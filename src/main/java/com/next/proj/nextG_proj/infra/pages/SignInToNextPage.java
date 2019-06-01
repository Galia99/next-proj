package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.next.proj.nextG_proj.infra.Web.By2;

public class SignInToNextPage extends AbstractPage{

	private static final By2 emailField = new By2("'email field'", By.id("EmailOrAccountNumber"));
	private static final By2 PasswordField = new By2("'password field'", By.id("Password"));
	private static final By2 signInNowButton = new By2("'signInNow button'", By.id("SignInNow"));
	private static final By2 warningMessageTitle = new By2("'warning message title'", By.xpath("//span[text()='Sorry, we have been unable to sign you in.']"));

	
	//Constractor
		public SignInToNextPage(WebDriver driver) throws Exception {
			super(driver);
		}
		
		
		public void writeToemailField(String email) {
			bot.writeToElement(emailField, email);
		}
		
		public void writeToPasswordField(String password) {
			bot.writeToElement(PasswordField, password);
		}
		
		public MyAccountPage clickTosignInNowButton() throws Exception {
			bot.click(signInNowButton);
			return new MyAccountPage(driver);
		}
		
		public String getTextWarningMessageTitle() {
			bot.getElementText(warningMessageTitle);
			return bot.getElementText(warningMessageTitle);
		}
}