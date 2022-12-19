package pageObject.dataTable;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.dataTable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGING_BY_NUMBER,pageNumber);
		clickToElement(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
	}
	
	public boolean isPageActiveNumber(String pageNumber) {
		//waitForElementVisible(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVED, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVED, pageNumber);
	}
	
	public void inputToHeaderTextBoxByName(String headerName, String value) {
		sendKeysToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, value, headerName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, Keys.ENTER, headerName);
	}
	
	public boolean isRowValueDisplay(String female, String country, String male, String total) {
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL, female, country, male, total);
	}
	
	public void clickToIconByCountryName(String countryName, String iconAction) {
		waitForElementClickable(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
		clickToElement(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
	}
	
	public boolean isDataRemoved(String female, String country, String male, String total) {
		return isElementExist(driver, HomePageUI.ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL, female, country, male, total);
	}
}
