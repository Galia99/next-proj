package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NextSearchResultsPage extends AbstractPage {
	
	private static final By sandalsSearchTitle = By.xpath("//a[@data-label='Tan Smart Leather Corkbed Sandals (Younger)']");
	private static final By aviatorSunglasses = By.xpath("//article[@id='i1']");
	
	public NextSearchResultsPage(WebDriver driver) {
		super(driver);
	}
	public String getSandalsSearchTitle() {
		return driver.findElement(sandalsSearchTitle).getText();
	}
	
	public String getsilverAviatorStyleSunglasses() {
		return driver.findElement(aviatorSunglasses).getText();
	}
	
	public void clickOnsilverAviatorStyleSunglasses() {
		driver.findElement(aviatorSunglasses).click();
	}
}
