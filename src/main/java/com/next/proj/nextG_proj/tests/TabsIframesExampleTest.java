package com.next.proj.nextG_proj.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.Web.TabAndIframeUtils;


public class TabsIframesExampleTest extends AbstractTest {

	@Test
	public void iframeTest() {

		browseToUrl("file:///C:/Rony/iframe_tabs/page1.html");

		TabAndIframeUtils.switchToIframe(driver, By.id("main_iframe"));
		
		driver.findElement(By.id("p3_link")).click();
	}

	@Test
	public void tabsTest() throws Exception {

		browseToUrl("file:///C:/Rony/iframe_tabs/page1.html");

		driver.findElement(By.xpath("//a[@href='page2.html']")).click();

		//TabUtils.switchToTabByTitle(driver, "Page 2");
		TabAndIframeUtils.switchToTabByUrl(driver, "page21.html");
		
		driver.findElement(By.id("p3_link")).click();
	}
}
