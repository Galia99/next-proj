package com.next.proj.nextG_proj.infra.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.next.proj.nextG_proj.infra.Web.WebDriverType;

public class MainConfig {

	public static WebDriverType webDriverType;
	public static boolean closeBrowserTestEnd ; //To close the browser after the test, change the closeBrowserTestEnd to "True".
	public static int webDriverImplicitWaitInSeconds;
	public static String baseUrl;
	public static String username;
	public static String password;
	public static String oldPassword;
	public static String newPassword;
	
	//Enter to @BeforeMethod function, in AbstractTest.
	public static void initFromFile(String filePath) throws IOException {

		
		Properties prop = new Properties();
		InputStream input = new FileInputStream(filePath);

		//Load a properties file 
		prop.load(input);
		
		//Convert 4 WebDriverType(webDriverType String object) to CHROME.
		webDriverType = WebDriverType.valueOf(prop.getProperty("webDriverType"));
		closeBrowserTestEnd = Boolean.parseBoolean(prop.getProperty("closeBrowserTestEnd"));
		webDriverImplicitWaitInSeconds = Integer.parseInt(prop.getProperty("webDriverImplicitWaitInSeconds"));
		baseUrl = prop.getProperty("baseUrl");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		newPassword = prop.getProperty("newPassword");
		
		//input.close();
		/*		
		//Convert 1 WebDriverType(webDriverType String object) to CHROME.
	    // get the property key(webDriverTypeString) and print it out
		String webDriverTypeString = prop.getProperty("webDriverType");
		//Convert 2 WebDriverType(webDriverType String object) to CHROME.
		WebDriverType driverType = WebDriverType.valueOf("CHROME");
		//Convert 3 WebDriverType(webDriverType String object) to CHROME.
		WebDriverType driverType = WebDriverType.valueOf(prop.getProperty("webDriverType"));
		 */
	}
/*	public static void main (String[] args) throws IOException {
		initFromFile("src//main//resources//config//MainConfig.properties");
		
		System.out.println(webDriverType);
		System.out.println(closeBrowserTestEnd);
		System.out.println(webDriverImplicitWaitInSeconds);
		System.out.println(baseUrl);

	}*/
}
