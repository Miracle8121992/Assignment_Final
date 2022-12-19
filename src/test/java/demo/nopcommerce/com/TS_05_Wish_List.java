package demo.nopcommerce.com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.HeaderObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.ShoppingCartPageObject;
import pageObjects.WishListPageObject;

public class TS_05_Wish_List extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	WishListPageObject wishList;
	HomePageObject homePage;
	HeaderObject header;
	ShoppingCartPageObject shoppingCart;

	@Parameters ("browser")
	@BeforeClass
	public void beforeClass (String browserName) {
		driver = getBrowserDriver (browserName, "https://demo.nopcommerce.com/login?returnUrl=%2F");
		loginPage = new LoginPageObject(driver);
		homePage = new HomePageObject(driver);
		wishList = new WishListPageObject(driver);
		header = new HeaderObject(driver);
		shoppingCart = new ShoppingCartPageObject(driver);
	}
	@AfterClass
	public void afterClass () {
		driver.quit();
	}
	
	@Test
	public void TC_01_AddProductToWishList() {
		loginAccount("Cuongtest133@gmail.com","abc124");
		homePage.clickToProduct();
		wishList.clickToWishListButton();
		Assert.assertTrue(wishList.isAddToWishListSuccessMessage("The product has been added to your wishlist"));
		wishList.clickToCloseMessage();
		sleepInSeconds(2);
		header.clickToWishListButton();
		Assert.assertTrue(wishList.isProductAddToWishList("Apple MacBook Pro 13-inch"));
	}
	
	@Test
	public void TC_02_AddProductInWishListPage() {
		wishList.clickToAddToCartCheckBox();
		wishList.clickToAddToCartButton();
		Assert.assertTrue(shoppingCart.isProductAddToCart("Apple MacBook Pro 13-inch"));
		header.clickToWishListButton();
		Assert.assertTrue(wishList.isNoProductMessage("The wishlist is empty!"));
	}
	
	
	public void loginAccount(String email, String password) {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
	}

}
