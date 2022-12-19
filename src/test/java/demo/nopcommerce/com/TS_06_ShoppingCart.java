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
import pageObjects.ShoppingCartPageObject;

public class TS_06_ShoppingCart extends BaseTest {
	WebDriver driver;
	ShoppingCartPageObject shoppingCart;
	HeaderObject header;
	LoginPageObject loginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver (browserName, "https://demo.nopcommerce.com/login?returnUrl=%2F");
		shoppingCart = new ShoppingCartPageObject(driver);
		header = new HeaderObject(driver);
		loginPage = new LoginPageObject(driver);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void TC_01_UpdateShoppingCart() {
		loginAccount("Cuongtest133@gmail.com", "abc124");
		header.clickToShoppingCartButton();
		shoppingCart.inputToQuantityTextBox("5");
		shoppingCart.clickToUpdateShoppingCartButton();
		Assert.assertTrue(shoppingCart.isUpdateShoppingCartSuccess("5"));
	}
	
	@Test
	public void TC_02_RemoveFromCart() {
		shoppingCart.clickToRemoveProductButton();
		Assert.assertTrue(shoppingCart.isNoProductMessage("Your Shopping Cart is empty!"));
		
	}
	public void loginAccount(String email, String password) {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
	}
}
