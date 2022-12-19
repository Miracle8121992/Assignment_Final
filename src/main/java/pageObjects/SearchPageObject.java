package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import common.BasePage;
import pageUIs.SearchPageUI;

public class SearchPageObject extends BasePage{
	WebDriver driver;
	
	//Constructor
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToSearchTextbox(String keyword) {
		sendKeysToElement(driver, SearchPageUI.SEARCH_TEXTBOX, keyword);
	}
	
	public void clickToSearchButton() {
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}
	
	public boolean isSearchEmptyErrorMessage(String value) {
		String message = getTextOfElement(driver, SearchPageUI.SEARCH_EMPTY_ERROR_MESSAGE);
		return message.equals(value);
	}
	
	public boolean isWrongDataErrorMessage(String value) {
		String message = getTextOfElement(driver, SearchPageUI.SEARCH_WRONG_DATA_ERROR_MESSAGE);
		return message.equals(value);
	}
	
	public boolean isAddToCartButton(String value) {
		String message = getTextOfElement(driver, SearchPageUI.ADD_TO_CART_BUTTON);
		return message.equals(value);
	}
	
	public void clickToAdvanceSearchCheckBox() {
		clickToElement(driver, SearchPageUI.ADVANCE_SEARCH_CHECK_BOX);
	}
	
	public void selectTextOfDropdown(String value) {
		Select select = new Select(findElement(driver, SearchPageUI.CATEGORY_DROPBOX));
		select.selectByVisibleText(value);
	}
	
	public void clickToAutomaticallySearchCheckBox() {
		clickToElement(driver, SearchPageUI.AUTOMATICALLY_SEARCH_CHECK_BOX);
	}

	public boolean isVerifyElements(String value) {
		List<WebElement> ln = findElements(driver, SearchPageUI.PRODUCT_NAME_TEXT);
		boolean verify = true;
		for (WebElement o : ln) {
			if (o.getText().contains(value)) {
				return verify = true;
			} else {
				return verify = false;
			}
		}
		return verify;
	}
}
