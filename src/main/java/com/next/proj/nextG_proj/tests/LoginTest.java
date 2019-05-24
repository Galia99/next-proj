package com.next.proj.nextG_proj.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest{

	@Test
	public void _01_loginToNext() {

		driver.get("https://www.next.co.il/en");

		//Open login window
		WebElement myAccountButton = driver.findElement(By.xpath("//a[@data-link-id='DataLinkId']"));
		myAccountButton.click();

		//Enter email and password.
		driver.findElement(By.id("EmailOrAccountNumber")).sendKeys("galinaltman@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("galina@22");
		driver.findElement(By.id("SignInNow")).click();
	}
}
