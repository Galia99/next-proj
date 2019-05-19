package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NextLandingPage extends AbstractPage{

	// class-By, metoda statit-id, mahzira ob'ect mi tipus-By.
	private static final By searbox = By.xpath("//input[@class='SearchBox']");
	private static final By seachItemsButton = By.xpath("//input[@class='SearchButton']");
	private static final By WaitForhelpButton = By.xpath("//a[@target='_blank']");
	//Constractor
	public NextLandingPage(WebDriver driver) {
		super(driver);
	}

	public void writeToSearchBox(String searchTerm) {
		driver.findElement(searbox).sendKeys(searchTerm);
	}

	public void writeToSearchBoxwordRequest(String wordRequest) {
		driver.findElement(searbox).sendKeys(wordRequest);
	}

	public void enterToSearchBox () {
		driver.findElement(searbox).sendKeys(Keys.ENTER); 
	}

	public NextSearchResultsPage clickOnseachItemsButton () {
		driver.findElement(seachItemsButton).click();
		return new NextSearchResultsPage(driver);
	}
	public void clickOnMyAccountButton () {
		driver.findElement(searbox).click(); 
	}

	/*public void WaitForhelpButtonEnabled() {

		WebElement waitForhelpButton = driver.findElement(WaitForhelpButton);

		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(waitForhelpButton));
	}*/

}