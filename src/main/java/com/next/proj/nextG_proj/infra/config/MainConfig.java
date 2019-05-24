package com.next.proj.nextG_proj.infra.config;

import com.next.proj.nextG_proj.infra.Web.WebDriverType;

public class MainConfig {

	public static WebDriverType webDriverType = WebDriverType.CHROME;
	public static boolean closeBrowserTestEnd = false; //Browser will never close (false)
	public static int webDriverImplicitWaitInSeconds = 5;
}
