package com.next.proj.nextG_proj.infra.Web;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.next.proj.nextG_proj.infra.reports.ConsoleReporter;

public class ActionBot { 

	private WebDriver driver;
	private WebDriverWait webDriverWait;

	public ActionBot(WebDriver driver) {
		this.driver = driver; 
		webDriverWait = new WebDriverWait(driver, 5);
	}

	public void enter(By2 elementLocator) {
		ConsoleReporter.report("Enter on element: " + elementLocator);
		driver.findElement(elementLocator.by).sendKeys(Keys.ENTER);
	}
	
	public void click(By2 elementLocator) {
		ConsoleReporter.report("Click on element: " + elementLocator);
		driver.findElement(elementLocator.by).click();
	}
	
	public void clear(By2 elementLocator) {
		ConsoleReporter.report("Clear text: " + elementLocator);
		driver.findElement(elementLocator.by).clear();
	}

	public void writeToElement(By2 elementLocator, String text) {
		ConsoleReporter.report("Write '" + text + "' to element: " + elementLocator);
		WebElement element = driver.findElement(elementLocator.by);
		element.clear();
		element.sendKeys(text);
	}

	public String getElementText(By2 elementLocator) {
		String text = driver.findElement(elementLocator.by).getText();
		ConsoleReporter.report("Element " + elementLocator + " inner text: " + text);
		return text;
	}

	public void waitForElementToBeClickable(By2 elementLocator) {
		ConsoleReporter.report("Wait for element:  " + elementLocator + " to be clickable");
		webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator.by));
	}

	/*public boolean isElementDisplayed(By elementLocator) {

		List<WebElement> elements = driver.findElements(elementLocator);
		if (elements.size() > 0) {

			boolean isDisplayed = elements.get(0).isDisplayed();
			ConsoleReporter.report("Element " + elementLocator + " is displayed: " + isDisplayed);

			return isDisplayed;
		}

		    ConsoleReporter.report("Element " + elementLocator + " is NOT displayed!");
		    return false;
	}*/
//---------------------------------------------------------------------------------
	/*public NextShoppingBagPage clickOnviewEditBagButton () throws Exception {


		if (viewEditBagButtonVisible()) {
			//write here that this page exists
			System.out.println("The bag of items is shown");
			driver.findElement(viewEditBagButton).click();
		}

		return new NextShoppingBagPage(driver);
}

public boolean viewEditBagButtonVisible() {

	List<WebElement> elements = driver.findElements(viewEditBagButton);
	if (elements.size() > 0) {
		return elements.get(0).isDisplayed();
	}
	return false;
} */
}
