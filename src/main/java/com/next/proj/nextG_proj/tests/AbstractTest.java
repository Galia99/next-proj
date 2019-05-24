package com.next.proj.nextG_proj.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.next.proj.nextG_proj.infra.Web.WebDriverFactory;
import com.next.proj.nextG_proj.infra.config.MainConfig;

public abstract class AbstractTest {

	protected WebDriver driver;

	@BeforeMethod
	public void beforeTest() {

		if (driver == null) {
            driver = WebDriverFactory.getWebDriver(MainConfig.webDriverType); //Web>>WebDriverFactory
			/*System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();*/
		}
	} 
 
	@AfterTest 
		public void afterTest() {
		if (driver != null && MainConfig.closeBrowserTestEnd) { 
            driver.close();
		}
	}
}