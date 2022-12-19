package pageObjects;


import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	// constructor
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToFirstNameTextbox(String firstname) {
		sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstname);
	}
	
	public void inputToLastNameTextbox(String lastname) {
		sendKeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastname);
	}
	
	public void inputToEmailTextbox(String email) {
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void inputToPasswordTextbox(String password) {
		sendKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public void inputToConfirmPasswordTextbox(String confirmPass) {
		sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPass);
	}
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	
	public boolean isRegisterSuccess(String value) {
		String message = getTextOfElement(driver, RegisterPageUI.VALID_INFORMATION_MESSAGE);
		return message.equals(value);
	}
	
	public boolean isFirstNameErrorMessage(String value) {
		String message = getTextOfElement(driver, RegisterPageUI.FIRST_NAME_IS_REQUIRED_ERROR_MESSAGE);
		return message.equals(value);
	}
	
	public boolean isLastNameErrorMessage (String value) {
		String message = getTextOfElement(driver, RegisterPageUI.LAST_NAME_IS_REQUIRED_ERROR_MESSAGE);
		return message.equals(value);
	}
	
	public boolean isEmailErrorMessage (String value) {
		String message = getTextOfElement(driver, RegisterPageUI.EMAIL_IS_REQUIRED_ERROR_MESSAGE);
		return message.equals(value);
	}
	
	public boolean isPasswordErrorMessage(String value) {
		String message = getTextOfElement(driver, RegisterPageUI.PASSWORD_IS_REQUIRED_MESSAGE);
		return message.equals(value);
	}
	
	public boolean isConfirmPasswordErrorMessage (String value) {
		String message = getTextOfElement(driver, RegisterPageUI.CONFIRM_PASSWORD_IS_REQUIRED_MESSAGE);
		return message.equals(value);
	}
	
	public boolean isRegisterComplete(String value) {
		String message = getTextOfElement(driver, RegisterPageUI.REGISTER_COMPLETE_MESSAGE);
		return message.equals(value);
	}
	
	public boolean isEmailExistErrorMessage(String value) {
		String message = getTextOfElement(driver, RegisterPageUI.EMAIL_EXIST_ERROR_MESSAGE);
		return message.equals(value);
	}
	 
	public boolean isPasswordSmallThan6Message(String value) {
		 String message = getTextOfElement(driver, RegisterPageUI.PASSWORD_SMALLER_THAN_6_MESSAGE);
		 return message.equals(value);
	 }
	
	public boolean isPasswordSmallThan6Message2(String value) {
		 String message = getTextOfElement(driver, RegisterPageUI.PASSWORD_SMALLER_THAN_6_MESSAGE2);
		 return message.equals(value);
	 }
	
	public void refreshRegisterPage(String url) {
		refreshCurrentPage(driver);
	}
	
	public void navigateToRegisterPage(String url) {
		openUrl(driver, url);
	}
	
	public boolean isPassWordDoesNotMatchMessage(String value) {
		String message = getTextOfElement(driver, RegisterPageUI.PASSWORD_DOES_NOT_MATCH_ERROR_MESSAGE);
		return message.equals(value);
	}
}