package com.next.proj.nextG_proj.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.next.proj.nextG_proj.infra.Web.WebDriverFactory;
import com.next.proj.nextG_proj.infra.config.MainConfig;
import com.next.proj.nextG_proj.infra.reports.ConsoleReporter;

public abstract class AbstractTest {

	protected WebDriver driver;

	@BeforeMethod
	public void beforeTest() {

		if (driver == null) {
			driver = WebDriverFactory.getWebDriver(MainConfig.webDriverType); //Web>>WebDriverFactory
		}
	} 

	public void browseToUrl(String url) {
		ConsoleReporter.report("Prowsing to URL: " + url);
		driver.get(url);
	}

	@AfterMethod
	public void afterTest() {
		if (driver != null && MainConfig.closeBrowserTestEnd) { 
			driver.close();
		}
	}
}