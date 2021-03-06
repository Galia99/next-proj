package com.next.proj.nextG_proj.infra.pages;

import org.openqa.selenium.By;
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
	private static final By2 israelFlagButton = new By2("'click on israeli flag button'", By.xpath("//div[@class='HeaderFlag flagBackground flag-Israel ']"));
	private static final By2 englishLanguageButton = new By2("'click on english language button'", By.xpath("//input[@value='English']"));
	private static final By2 browsetoEnglishSiteButton = new By2("'Browse to English website button'", By.id("btnFlagSelectorShopNow"));
	private static final By2 myAccountSignOutButton = new By2("'Sign Out button in My Account page'",  By.xpath("//a[@class='myAccountsignout']"));
	
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
	
	public void goToEnglishWebsite() {
		
		bot.click(israelFlagButton);
		bot.click(englishLanguageButton);
		bot.click(browsetoEnglishSiteButton);
	}

	public SignInToNextPage clickOnmyAccountSignOut() throws Exception {
		bot.click(myAccountSignOutButton);
		return new SignInToNextPage(driver);
		
	}
}
