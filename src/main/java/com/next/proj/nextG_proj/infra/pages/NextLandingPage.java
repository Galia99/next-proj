package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NextLandingPage extends NextAbstractPage{

	// class-By, metoda statit-id, mahzira ob'ect mi tipus-By.
	private static final By searbox = By.xpath("//input[@class='SearchBox']");
	private static final By searchProductsButton = By.xpath("//input[@class='SearchButton']");
	private static final By shoppingBagButton = By.xpath("//div[@class='Icon active']");
	private static final By myAccountButton = By.xpath("//a[@data-link-id='DataLinkId']");

	
	//Constractor
	public NextLandingPage(WebDriver driver) throws Exception {
		super(driver, searbox);
	}

	public void writeToSearchBox(String searchTerm) {
		driver.findElement(searbox).sendKeys(searchTerm);
	}

	public void writeToSearchBoxwordRequest(String wordRequestSunglassesSilverAviator) {
		driver.findElement(searbox).sendKeys(wordRequestSunglassesSilverAviator);
	}
	
	public void enterToSearchBox () {
		driver.findElement(searbox).sendKeys(Keys.ENTER); 
	}
	public void clickOnMyAccountButton () {
		driver.findElement(searbox).click(); 
	}

	public NextSearchResultsPage clickOnseachItemsButton () throws Exception {
		driver.findElement(searchProductsButton).click();
		return new NextSearchResultsPage(driver);
	}
	
	public void clickOnshoppingBagButton () {
		driver.findElement(shoppingBagButton).click();
  }

	public void clickOnmyAccountButton () {
		driver.findElement(myAccountButton).click();
		
	}
	/*public void WaitForhelpButtonEnabled() {

		WebElement waitForhelpButton = driver.findElement(WaitForhelpButton);

		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(waitForhelpButton));
	}*/

}