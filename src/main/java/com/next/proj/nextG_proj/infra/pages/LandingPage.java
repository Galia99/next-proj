package com.next.proj.nextG_proj.infra.pages;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.next.proj.nextG_proj.infra.Web.By2;

public class LandingPage extends AbstractPage{

	// class-By, metoda statit-id, mahzira ob'ect mi tipus-By.
	private static final By2 searchbox = new By2("'Main search box'", By.xpath("//input[@class='SearchBox']"));
	private static final By2 searchProductsButton = new By2("' Magnifier button for search products'", By.xpath("//input[@class='SearchButton']"));
	private static final By2 shoppingBagButton = new By2("'Shopping bag button'",  By.xpath("//div[@class='Icon active']"));
	private static final By2 myAccountButton = new By2("'My account button'",  By.xpath("//a[@data-link-id='DataLinkId']"));
	private static final By2 checkoutButton = new By2("'Checkout button'",  By.xpath("//div[@class='Checkout ']/a[@class='nxbtn primary']"));
	private static final By2 FavouriteIcon = new By2("'Favourite icon'",  By.xpath("//div[@class='favourite-icon intl']"));
	private static final By2 FavouriteIconAfterNotification = new By2("'Favourite icon after notification'",  By.xpath("//div[@class='favourite-icon intl notification']"));
	private static final By2 myAccountlinkActive = new By2("'My account link active'",  By.xpath("//a[@class='myAccountlinkactive']"));
	private static final By2 myAccountSignOut = new By2("'MyAccount sign Out'",  By.xpath("//a[@class='myAccountsignout']"));

	public LandingPage(WebDriver driver) throws Exception {
		super(driver);
	}

	public void writeToSearchBox(String searchTerm) {
		
		bot.writeToElement(searchbox, searchTerm);
		//ConsoleReporter.report("Write '" + searchTerm + "' into search box (" + searchbox + ")");
		//driver.findElement(searchbox).sendKeys(searchTerm);
	}
	public void writeToSearchBoxRandom() {
		String randomSearchTerm = generateRandomSearchTerm();
		bot.writeToElement(searchbox, randomSearchTerm);
		//ConsoleReporter.report("Write '" + searchTerm + "' into search box (" + searchbox + ")");
		//driver.findElement(searchbox).sendKeys(searchTerm);
	}

	public void writeToSearchBoxwordRequest(String wordRequestSunglassesSilverAviator) {
		bot.writeToElement(searchbox, wordRequestSunglassesSilverAviator);
		//driver.findElement(searchbox).sendKeys(wordRequestSunglassesSilverAviator);
	}

	public void enterToSearchBox () {
		bot.enter(searchbox);
	}		


	public SearchResultsPage clickOnseachItemsButton () throws Exception {
		bot.click(searchProductsButton);
		//driver.findElement(searchProductsButton).click();
		return new SearchResultsPage(driver);
	}

	public void clickOnSearchBox () {
		bot.click(searchbox);
		//driver.findElement(searchbox).click();
	}

	public void clickOnshoppingBagButton () {
		bot.click(shoppingBagButton);
		//driver.findElement(shoppingBagButton).click();
	}

	public SignInToNextPage clickOnmyAccountButton () throws Exception {
		bot.click(myAccountButton);
		return new SignInToNextPage(driver);
		//driver.findElement(myAccountButton).click();

	}
	public void WaitForhelpButtonEnabled() {
		bot.waitForElementToBeClickable(checkoutButton);
	}

	/*public String getFavouriteIcon() {
		String FavouriteIconText = bot.getElementText(FavouriteIcon);
		return FavouriteIconText;
	}*/
	
	public FavouritePage clickOnFavouriteIcon() throws Exception { //try clicking on the empty favorites notification icon, if you get an exception, click on the icon with a notification

		try {
			bot.click(FavouriteIcon);
		}catch(Exception e) {
			bot.click(FavouriteIconAfterNotification);
		}
		return new FavouritePage(driver);
	}
	
	public void clickOnMyAccountlinkActive() {
		bot.click(myAccountlinkActive);
	}

	public SignInToNextPage clickOnmyAccountSignOut() throws Exception {
			bot.click(myAccountSignOut);
			return new SignInToNextPage(driver);
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
	
	/*WebElement mycheckoutButton = driver.findElement(checkoutButton);

		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
	}*/

}
