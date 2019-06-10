package com.next.proj.nextG_proj.tests;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.next.proj.nextG_proj.infra.Web.WebDriverFactory;
import com.next.proj.nextG_proj.infra.config.MainConfig;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;
import il.co.topq.difido.model.Enums.Status;

@Listeners(il.co.topq.difido.ReportManagerHook.class)
public abstract class AbstractTest {

	protected static ReportDispatcher report = ReportManager.getInstance();
	protected static WebDriver driver;
	
	@BeforeMethod
	public void beforeTest() throws IOException   {

		MainConfig.initFromFile("src/main/resources/config/MainConfig.properties");
		 
		if (driver == null) {
			driver = WebDriverFactory.getWebDriver(MainConfig.webDriverType);
		}		
	} 

	public void browseToUrl(String url) {
		report.log("Prowsing to URL: " + url); 
		driver.get(url);
	}

	public static void takeScreenshot(String description) throws Exception {
		
        	if(driver != null) {
			java.io.File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			report.addImage(screenshotFile, description);	
		}
		else {
			report.log("driver == null; Can't take screnshot. ", Status.warning);
		}
	}

	@AfterMethod
	public void afterTest() throws Exception {
		
		takeScreenshot("Browser state at test end");
		
		if (driver != null && MainConfig.closeBrowserTestEnd) { 
			driver.close();
		}
	}
}