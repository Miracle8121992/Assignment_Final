package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.WishListPageUI;

public class WishListPageObject extends BasePage {
	WebDriver driver;
	
	//constructor
	public WishListPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToWishListButton() {
		clickToElement(driver, WishListPageUI.ADD_TO_WISH_LIST_BUTTON);
	}
	
	public boolean isAddToWishListSuccessMessage (String value) {
		String message = getTextOfElement(driver, WishListPageUI.ADD_TO_WISH_LIST_SUCCESS_MESSAGE);
		return message.equals(value);
	}
	public boolean isProductAddToWishList(String value) {
		String message = getTextOfElement(driver, WishListPageUI.PRODUCT_NAME);
		return message.equals(value);
	}
	
	public void clickToAddToCartCheckBox() {
		clickToElement(driver, WishListPageUI.ADD_TO_CART_CHECK_BOX);
	}
	
	public void clickToAddToCartButton() {
		clickToElement(driver, WishListPageUI.ADD_TO_CART_BUTTON);
	}
	
	public boolean isNoProductMessage(String value) {
		String message = getTextOfElement(driver, WishListPageUI.NO_PRODUCT_MESSAGE);
		return message.equals(value);
	}
}
