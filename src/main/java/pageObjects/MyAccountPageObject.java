package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
	WebDriver driver;
	
	//constructor
	public MyAccountPageObject (WebDriver driver) {
		this.driver = driver;
	}
	//Customer info
	public void checkMaleOption () {
		waitForElementClickable(driver, MyAccountPageUI.MALE_RADIO_BUTTON);
		clickToElement(driver, MyAccountPageUI.MALE_RADIO_BUTTON);
	}
	
	public void inputFirstNameTextBox(String firstName) {
		sendKeysToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	
	public void inputLastNameTextBox(String lastName) {
		sendKeysToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
	public void inputCompanyName(String companyName) {
		sendKeysToElement(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}
	
	public void clickSaveButton() {
		clickToElement(driver, MyAccountPageUI.SAVE_CUSTOMER_INFO_BUTTON);
	}
	//Verify update customer info
	
	public boolean isFirstNameValueUpdate(String value) {
		String message = getAttributeValue(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, "value");
		return message.equals(value);
	}
	
	public boolean isLastNameValueUpdate(String value) {
		String message = getAttributeValue(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, "value");
		return message.equals(value);
		}
	
	public boolean isCompanyNameValueUpdate(String value) {
		String message = getAttributeValue(driver, MyAccountPageUI.COMPANY_NAME_TEXTBOX, "value");
		return message.equals(value);
	}
	//Address tab
	public void clickAddressesTab() {
		clickToElement(driver, MyAccountPageUI.ADDRESSES_TAB);
	}
	
	public void clickToAddNewAddressButton() {
		clickToElement(driver, MyAccountPageUI.ADD_NEW_ADDRESS_BUTTON);
	}
	
	public void inputFirstNameTextboxAddress(String firstName) {
		sendKeysToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX_ADDRESS, firstName);
	}
	
	public void inputLastNameTextBoxAddress(String lastName) {
		sendKeysToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX_ADDRESS, lastName);
	}
	
	public void inputEmailTextboxAddress(String email) {
		sendKeysToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX_ADDRESS, email);
	}
	
	public void selectCountryAddress() {
		clickToElement(driver, MyAccountPageUI.SELECT_COUNTRY_OPTION_3);
	}
	
	public void inputCityTextboxAddress(String city) {
		sendKeysToElement(driver, MyAccountPageUI.CITY_TEXTBOX_ADDRESS, city);
	}
	
	public void inputAddress1Textbox(String address) {
		sendKeysToElement(driver, MyAccountPageUI.ADDRESS_1_TEXTBOX, address);
	}
	
	public void inputZipPostalCodeTextboxAddress(String zip) {
		sendKeysToElement(driver, MyAccountPageUI.ZIP_POSTAL_CODE_TEXTBOX_ADDRESS, zip);
	}
	
	public void inputPhoneNumberTextboxAddress(String phone) {
		sendKeysToElement(driver, MyAccountPageUI.PHONE_NUMBER_ADDRESS, phone);
	}
	
	public void clickSaveButtonAddress() {
		clickToElement(driver, MyAccountPageUI.SAVE_ADDRESS_BUTTON);
	}
	
	public boolean isNameDisplayed (String value) {
		String message = getTextOfElement(driver, MyAccountPageUI.NAME_TEXT);
		return message.equals(value);
	}
	
	public boolean isEmailDisplayed (String value) {
		String message = getTextOfElement(driver, MyAccountPageUI.EMAIL_TEXT);
		return message.equals(value);
	}
	
	public boolean isPhoneNumberDisplayed(String value) {
		String message = getTextOfElement(driver, MyAccountPageUI.PHONE_NUMBER_TEXT);
		return message.equals(value);
	}
	
	public boolean isAddress1Displayed(String value) {
		String message = getTextOfElement(driver, MyAccountPageUI.ADDRESS_1_TEXT);
		return message.equals(value);
	}
	
	public boolean isCityZipCodeDisplayed(String value) {
		String message = getTextOfElement(driver,MyAccountPageUI.CITY_ZIP_CODE_TEXT);
		return message.equals(value);
	}
	
	public boolean isCountryDisplayed(String value) {
		String message = getTextOfElement(driver, MyAccountPageUI.COUNTRY_TEXT);
		return message.equals(value);
	}
	
	public void clickToChangePasswordTab() {
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_TAB);
	}
	
	public void inputOldPasswordTextbox(String oldPassword) {
		sendKeysToElement(driver, MyAccountPageUI.OLD_PASSWORD_TEXTBOX, oldPassword);
	}
	
	public void inputToNewPasswordTextbox(String newPassword) {
		sendKeysToElement(driver, MyAccountPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}
	
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		sendKeysToElement(driver, MyAccountPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}
	
	public void clickToChangePasswordButton() {
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
	}
	
	
	
}