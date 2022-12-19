package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.HeaderUI;

public class HeaderObject extends BasePage {
	WebDriver driver;
	
	//Constructor
	public HeaderObject (WebDriver driver) {
		this.driver = driver;
	}
	public void clickToLogOutButton () {
		clickToElement(driver, HeaderUI.LOG_OUT_BUTTON);
	}
	
	public void clickToLogInButton() {
		clickToElement(driver, HeaderUI.LOG_IN_BUTTON);
	}
	
	public boolean isMyAccountDisplayed(String value) {
		String message = getTextOfElement(driver, HeaderUI.MY_ACCOUNT_BUTTON);
		return message.equals(value);
	}
	
	public void clickToWishListButton() {
		clickToElement(driver, HeaderUI.WISH_LIST_BUTTON);
	}
	
	public void clickToShoppingCartButton() {
		clickToElement(driver, HeaderUI.SHOPPING_CART_BUTTON);
	}
}
