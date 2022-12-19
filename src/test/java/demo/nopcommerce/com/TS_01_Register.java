package demo.nopcommerce.com;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.RegisterPageObject;

public class TS_01_Register extends BaseTest {
	WebDriver driver;
	RegisterPageObject register;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/register?returnUrl=%2F");
		register = new RegisterPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
	@Test
	public void TC_01_RegisterWithEmptyData() {
		register.clickToRegisterButton();
		Assert.assertTrue(register.isFirstNameErrorMessage("First name is required."));
		Assert.assertTrue(register.isLastNameErrorMessage("Last name is required."));
		Assert.assertTrue(register.isEmailErrorMessage("Email is required."));
		Assert.assertTrue(register.isPasswordErrorMessage("Password is required."));
		Assert.assertTrue(register.isConfirmPasswordErrorMessage("Password is required."));
	}
	
	@Test
	public void TC_02_RegisterWithInvalidEmail() {
		register.inputToFirstNameTextbox("test auto");
		register.inputToLastNameTextbox("123");
		register.inputToEmailTextbox("Cuongtest123");
		register.clickToRegisterButton();
		Assert.assertTrue(register.isEmailErrorMessage("Wrong email"));
	}
	
	@Test
	public void TC_03_RegisterSuccess() {
		register.inputToFirstNameTextbox("test auto");
		register.inputToLastNameTextbox("123");
		register.inputToEmailTextbox("Cuongtest133@gmail.com");
		register.inputToPasswordTextbox("abc123");
		register.inputToConfirmPasswordTextbox("abc123");
		register.clickToRegisterButton();
		Assert.assertTrue(register.isRegisterComplete("Your registration completed"));
		}
	
	@Test
	public void TC_04_RegisterWithExistEmail() {
		register.navigateToRegisterPage("https://demo.nopcommerce.com/register?returnUrl=%2F");
		register.inputToFirstNameTextbox("test auto123");
		register.inputToLastNameTextbox("1234");
		register.inputToEmailTextbox("Cuongtest133@gmail.com");
		register.inputToPasswordTextbox("abc123");
		register.inputToConfirmPasswordTextbox("abc123");
		register.clickToRegisterButton();
		Assert.assertTrue(register.isEmailExistErrorMessage("The specified email already exists"));
	}
	
	@Test
	public void TC_05_RegisterWithPasswordSmallThan6() {
		register.refreshCurrentPage(driver);
		register.inputToPasswordTextbox("abc1");
		register.clickToRegisterButton();
		Assert.assertTrue(register.isPasswordSmallThan6Message("Password must meet the following rules:"));
		Assert.assertTrue(register.isPasswordSmallThan6Message2("must have at least 6 characters"));
		}
	
	@Test
	public void TC_06_RegisterWithPassWordDoesNotMatchWithConfirm() {
		register.refreshCurrentPage(driver);
		register.inputToFirstNameTextbox("test auto123");
		register.inputToLastNameTextbox("1234");
		register.inputToEmailTextbox("Cuongtest130@gmail.com");
		register.inputToPasswordTextbox("abc123");
		register.inputToConfirmPasswordTextbox("abc122");
		register.clickToRegisterButton();
		Assert.assertTrue(register.isPassWordDoesNotMatchMessage("The password and confirmation password do not match."));
	}
}