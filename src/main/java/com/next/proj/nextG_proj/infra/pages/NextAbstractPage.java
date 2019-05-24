 package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class NextAbstractPage {

	protected WebDriver driver;
    protected By[] pageUniqueElements;
	
	public NextAbstractPage(WebDriver driver, By... pageUniqueElements) throws Exception {
		this.driver = driver;
		this.pageUniqueElements = pageUniqueElements;
		assertInPage(); //a function that determines that I am on the right page.
	}
	
	public void assertInPage() throws Exception {
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		
		try {
			for (By UniqueElement : pageUniqueElements) {
				webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(UniqueElement));//web driver determines the visibility of the element / defines the page, wait 5 seconds.
			}
		}
		catch(TimeoutException ex) {
			throw new Exception("Not on the expected page! " + "Class name : " + this.getClass().getSimpleName() +  "\n" + ex.getMessage());//Java - get the current class name

		}
	}
}
