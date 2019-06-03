package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.next.proj.nextG_proj.infra.Web.ActionBot;
import com.next.proj.nextG_proj.infra.Web.By2;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

public abstract class AbstractPage {

	protected  ReportDispatcher report = ReportManager.getInstance();
	protected WebDriver driver;
	protected ActionBot bot;
	protected By2[] pageUniqueElements;

	public AbstractPage(WebDriver driver, By2... pageUniqueElements) throws Exception {
		this.driver = driver;
		this.bot = new ActionBot(driver);
		this.pageUniqueElements = pageUniqueElements;
		assertInPage(); //a function that determines that I am on the right page.
	}

	public void assertInPage() throws Exception {

		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

		try {
			for (By2 UniqueElement : pageUniqueElements) {
				webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(UniqueElement.by));//web driver determines the visibility of the element / defines the page, wait 5 seconds.
			}
			
			report.log("*** On page: " + this.getClass().getSimpleName());

		}
		catch(TimeoutException ex) {
			throw new Exception("Not on the expected page! " + "Class name : " + this.getClass().getSimpleName() +  "\n" + ex.getMessage());//Java - get the current class name
		
		}
	}
}
