package com.next.proj.nextG_proj.infra.pages;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.next.proj.nextG_proj.infra.Web.By2;

public class LandingPage extends AbstractPage{


	private static final By2 searchbox = new By2("'Main search box'", By.xpath("//input[@class='SearchBox']"));
	private static final By2 searchProductsButton = new By2("'(Magnifier) button for search products'", By.xpath("//input[@class='SearchButton']"));
	private static final By2 shoppingBagButton = new By2("'Shopping bag Icon'",  By.xpath("//div[@class='Icon active']"));
	private static final By2 myAccountButton = new By2("'My Account button for open Sign Into Next page'",  By.xpath("//a[@data-link-id='DataLinkId']"));
	private static final By2 FavouriteIcon = new By2("'Favourite icon'",  By.xpath("//div[@class='favourite-icon intl']"));
	private static final By2 markedFavouriteIcon = new By2("'marked Favourite icon'",  By.xpath("//div[@class='favourite-icon intl notification']"));
	private static final By2 myAccountlinkActive = new By2("'My account link active'",  By.xpath("//a[@class='myAccountlinkactive']"));
	private static final By2 helpButton = new By2("'Help button'",  By.xpath("//section[@class='QuickLinks']//a[@target='_blank']"));

	public LandingPage(WebDriver driver) throws Exception {
		super(driver);
	}

	public CustomerServicesPage clickOnHelpButton() throws Exception {
		bot.click(helpButton);
		return new CustomerServicesPage(driver);
	}
	
	
	public void writeToSearchBox(String searchTerm) {
		
		bot.writeToElement(searchbox, searchTerm);

	}
	public void writeToSearchBoxRandom() {
		String randomSearchTerm = generateRandomSearchTerm();
		bot.writeToElement(searchbox, randomSearchTerm);
	}

	public void writeToSearchBoxwordRequest(String wordRequestSunglassesSilverAviator) {
		bot.writeToElement(searchbox, wordRequestSunglassesSilverAviator);
		
	}

	public void enterToSearchBox () {
		bot.enter(searchbox);
	}		


	public SearchResultsPage clickOnseachItemsButton () throws Exception {
		bot.click(searchProductsButton);
		return new SearchResultsPage(driver);
	}

	public void clickOnSearchBox () {
		bot.click(searchbox);
	}

	public void clickOnshoppingBagButton () {
		bot.click(shoppingBagButton);
	}

	public SignInToNextPage clickOnmyAccountButton () throws Exception {
		bot.click(myAccountButton);
		return new SignInToNextPage(driver);
	}
	
	public String getFavouriteIcon() {
		String FavouriteIconText = bot.getElementText(FavouriteIcon);
		return FavouriteIconText;
	}
	
	public FavouritePage clickOnFavouriteIcon() throws Exception { //try clicking on the empty favorites notification icon, if you get an exception, click on the icon with a notification
		
		try {
			bot.click(FavouriteIcon);
		}catch(Exception e) {
			bot.click(markedFavouriteIcon);
		}
		
		return new FavouritePage(driver);
	}
	
	public void clickOnMyAccountlinkActive() {
		bot.click(myAccountlinkActive);
	}

	public String getFavouriteIconClassText() {
		
		String iconClassText=null;
		iconClassText = bot.getElementClass(FavouriteIcon);
		return iconClassText;
	}
public String getFavouriteIconMarkedClassText() {
		
		String iconClassText=null;
		iconClassText = bot.getElementClass(markedFavouriteIcon);
		return iconClassText;
	}
	
private String generateRandomSearchTerm() {
		
		String[] itemArray = new String[3];
		
		String item1="Suede Across-Body Bag";
		String item2="White Unicorn Bag";
		String item3 = "Sunglasses Silver Aviator";
		itemArray[0]=item1;
		itemArray[1]=item2;
		itemArray[2]=item3;
		
		int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
		
		System.out.println("random number is: "+randomNum+" item is: "+itemArray[randomNum]);
		return itemArray[randomNum];
	}
}
