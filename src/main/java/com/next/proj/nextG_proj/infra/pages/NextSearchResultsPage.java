package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NextSearchResultsPage extends NextAbstractPage {
	
	private static final By sandalsSearchTitle = By.xpath("//a[@data-label='Tan Smart Leather Corkbed Sandals (Younger)']");
	private static final By aviatorSunglassesTitle = By.xpath("//article[@id='i1']");
	
	public NextSearchResultsPage(WebDriver driver) throws Exception {
		super(driver);
	}
	public String getSandalsSearchTitle() {
		return driver.findElement(sandalsSearchTitle).getText();
	}
	
	public String getsilverAviatorStyleSunglasses() {
		return driver.findElement(aviatorSunglassesTitle).getText();
	}
	
	public NextProductPage clickOnsilverAviatorStyleSunglasses() throws Exception {
		driver.findElement(aviatorSunglassesTitle).click();
		return new NextProductPage(driver);
	}
	
	/*public void clickOnsilverAviatorStyleSunglassesById(int resultId) {
		driver.findElement(aviatorSunglassesTitle).click();
	}*/
	
	/*public void clickOnsilverAviatorStyleSunglassesById(int resultId) {
		By resultTitle = By.xpath("//article[@id='" + resultId + "']");
		driver.findElement(resultTitle).click();
	}*/
}
