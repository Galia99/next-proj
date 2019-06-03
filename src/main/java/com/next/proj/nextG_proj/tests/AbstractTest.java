package com.next.proj.nextG_proj.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.next.proj.nextG_proj.infra.Web.WebDriverFactory;
import com.next.proj.nextG_proj.infra.config.MainConfig;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

@Listeners(il.co.topq.difido.ReportManagerHook.class)

public abstract class AbstractTest {

	protected ReportDispatcher report = ReportManager.getInstance();
	protected WebDriver driver;

	@BeforeMethod
	public void beforeTest() {

		if (driver == null) {
			driver = WebDriverFactory.getWebDriver(MainConfig.webDriverType); //Web>>WebDriverFactory
		}
	} 

	public void browseToUrl(String url) {
		report.log("Prowsing to URL: " + url);
		driver.get(url);
	}

	@AfterMethod
	public void afterTest() {
		if (driver != null && MainConfig.closeBrowserTestEnd) { 
			driver.close();
		}
	}
}