package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage {
	WebDriver driver;
	
	//constructor
	public ShoppingCartPageObject (WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isProductAddToCart (String value) {
		String message = getTextOfElement(driver, ShoppingCartPageUI.PRODUCT_NAME);
		return message.equals(value);
	}
	
	public void inputToQuantityTextBox(String value) {
		sendKeysToElement(driver, ShoppingCartPageUI.QUANTITY_TEXT_BOX, value);
	}
	
	public void clickToUpdateShoppingCartButton() {
		clickToElement(driver, ShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
	}
	
	public boolean isUpdateShoppingCartSuccess(String value) {
		String message = getAttributeValue(driver, ShoppingCartPageUI.QUANTITY_TEXT_BOX, "value");
		return message.equals(value);
	}
	
	
	
	public void clickToRemoveProductButton() {
		clickToElement(driver, ShoppingCartPageUI.REMOVE_PRODUCT_BUTTON);
	}
	
	public boolean isNoProductMessage(String value) {
		String message = getTextOfElement(driver, ShoppingCartPageUI.NO_PRODUCT_MESSAGE);
		return message.contains(value);
	}
	

}
