package demo.nopcommerce.com;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.HeaderObject;
import pageObjects.LoginPageObject;

public class TS_02_Login extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HeaderObject header;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/login?returnUrl=%2F");
		loginPage = new LoginPageObject(driver);
		header = new HeaderObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void TC_01_LoginWithEmptyData() {
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isEmailErrorMessage("Please enter your email"));
	}
	
	@Test
	public void TC_02_LoginWithInvalidData() {
		loginPage.refreshCurrentPage(driver);
		loginPage.inputToEmailTextbox("abcd");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isEmailErrorMessage("Wrong email"));
	}
	
	@Test
	public void TC_03_LoginWithUnregisteredEmail() {
		loginPage.refreshCurrentPage(driver);
		loginPage.inputToEmailTextbox("abcd@gmail.com");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isLoginErrorMessage("No customer account found"));
	}
	
	@Test
	public void TC_04_LoginWithRegisteredEmailAndBlankPassword() {
		loginPage.inputToEmailTextbox("Cuongtest133@gmail.com");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isLoginWithRegisteredEmailAndBlankPasswordErrorMessage("The credentials provided are incorrect"));
	}
	
	@Test
	public void TC_05_LoginWithRegisteredEmailAndIncorrectPassword() {
		//loginPage.refreshCurrentPage(driver);
		loginPage.inputToEmailTextbox("Cuongtest133@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isLoginWithRegisteredEmailAndBlankPasswordErrorMessage("The credentials provided are incorrect"));
	}
	//chua biet cach verify do chuyen sang trang homepage
	@Test
	public void TC_06_LoginSuccess() {
		loginPage.inputToEmailTextbox("Cuongtest133@gmail.com");
		loginPage.inputToPasswordTextbox("abc123");
		loginPage.clickToLoginButton();
		header.isMyAccountDisplayed("My account");
	}
}