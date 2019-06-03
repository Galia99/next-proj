package com.next.proj.nextG_proj.infra.config;

import com.next.proj.nextG_proj.infra.Web.WebDriverType;

public class MainConfig {

	public static WebDriverType webDriverType = WebDriverType.CHROME;
	public static boolean closeBrowserTestEnd = false; //To close the browser after the test, change the closeBrowserTestEnd to "True".
	public static int webDriverImplicitWaitInSeconds = 5;
}
