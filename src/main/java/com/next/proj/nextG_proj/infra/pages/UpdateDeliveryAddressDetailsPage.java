package com.next.proj.nextG_proj.infra.pages;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.next.proj.nextG_proj.infra.Web.By2;

public class UpdateDeliveryAddressDetailsPage extends AbstractPage {

	private static final By2 addressDetailsTitle = new By2("'Address details title'", By.xpath("//legend[contains(text(),'Please enter your address details')]"));
	private static final By2 stateOrProvincefield = new By2("'State or province field'", By.id("dk_container_AddressLine5"));
	private static final By2 haifaProvince = new By2("'Haifa province'", By.xpath("//a[@data-dk-dropdown-value='H_EFA']"));
	private static final By2 haZafonProvince = new By2("'Ha Zafon province'", By.xpath("//a[@data-dk-dropdown-value='HA Z_AFON']"));
	private static final By2 haDaromProvince = new By2("'Ha Darom province'", By.xpath("//a[@data-dk-dropdown-value='HADAROM']"));
	private static final By2 haMerkazProvince = new By2("'Ha Merkaz province'", By.xpath("//a[@data-dk-dropdown-value='HAMERKAZ']"));
	private static final By2 telAvivProvince = new By2("'Tel-Aviv province'", By.xpath("//a[@data-dk-dropdown-value='TEL-AVIV']"));
	private static final By2 yerushalaimProvince = new By2("'Yerushalaim province'", By.xpath("//a[@data-dk-dropdown-value='YERUSHALAYIM']"));
	private static final By2 updateButton = new By2("'Update, address and details button '", By.xpath("//button[@class='submit']"));

	public UpdateDeliveryAddressDetailsPage(WebDriver driver) throws Exception {
		super(driver, addressDetailsTitle);

	}

	public void clickToStateOrProvincefield() {
		bot.click(stateOrProvincefield);
	}

	public void selectToHaMerkazProvince() {
		bot.click(haMerkazProvince);
	}
	
	public void selectYerushalaimProvince() {
		bot.click(yerushalaimProvince);
	}
	
	public void selectRandomProvince() {
		By2[] provinces = new By2[6];
		provinces[0]=haifaProvince;
		provinces[1]=haZafonProvince;
		provinces[2]=haDaromProvince;
		provinces[3]=haMerkazProvince;
		provinces[4]=telAvivProvince;
		provinces[5]=yerushalaimProvince;
		
		int randomNum = ThreadLocalRandom.current().nextInt(0, 6);
		bot.click(provinces[randomNum]);
	}
	
	public void clickOnUpdateButton () throws Exception {
		try {
			bot.click(updateButton);
		} catch (Exception e) {
			new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
			bot.click(updateButton);//1 CLIK OTMECHAET IZMENENIYA
		}
	}
}
