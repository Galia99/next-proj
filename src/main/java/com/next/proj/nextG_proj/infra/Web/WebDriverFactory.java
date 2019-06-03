package com.next.proj.nextG_proj.infra.Web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.next.proj.nextG_proj.infra.config.MainConfig;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

public class WebDriverFactory {
	
	protected static ReportDispatcher report = ReportManager.getInstance();

	public static WebDriver getWebDriver(WebDriverType webDriverType ){
		
		WebDriver driver = null;

		switch(webDriverType) {
		case CHROME:
			System.setProperty("webdriver.chrome,driver", "src/main/resources/chromedriver.exe"); //System.setProperty("what we are looking for...", "where to looking for...");
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko,driver", "src/main/resources/geckodriver.exe"); //System.setProperty("what we are looking for...", "where to looking for...");
			driver = new FirefoxDriver();
			break; 
		case INTERNET_EXPLORER:
			System.setProperty("webdriver.ie,driver", "src/main/resources/IEDriverServer.exe"); //System.setProperty("what we are looking for...", "where to looking for...");
			driver = new InternetExplorerDriver();
			break;
		}
		driver.manage().timeouts().implicitlyWait(MainConfig.webDriverImplicitWaitInSeconds, TimeUnit.SECONDS);//Implicitly Wait (TimeOut) If Element not found.
		driver.manage().window().maximize();

		report.log("Open new  " + webDriverType + " browser window");

		return driver;
	}
}
