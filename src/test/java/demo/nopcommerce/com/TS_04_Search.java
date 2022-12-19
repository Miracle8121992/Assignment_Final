package demo.nopcommerce.com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.FooterObject;
import pageObjects.LoginPageObject;
import pageObjects.SearchPageObject;

public class TS_04_Search extends BaseTest {
	WebDriver driver;
	SearchPageObject searchPage;
	FooterObject footer;
	LoginPageObject loginPage;

	@Parameters ("browser")
	@BeforeClass
	public void beforeClass (String browserName) {
		driver = getBrowserDriver (browserName, "https://demo.nopcommerce.com/login?returnUrl=%2F");
		searchPage = new SearchPageObject(driver);
		footer = new FooterObject(driver);
		loginPage = new LoginPageObject(driver);
	}
	@AfterClass
	public void afterClass () {
		driver.quit();
	}
	
	@Test
	public void TC_01_SearchWithEmptyData() {
		footer.clickToSearchButton();
		searchPage.inputToSearchTextbox("");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isSearchEmptyErrorMessage("Search term minimum length is 3 characters"));
	}
	
	@Test
	public void TC_02_SearchWithWrongData() {
		searchPage.inputToSearchTextbox("Macbook Pro 2040");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isWrongDataErrorMessage("No products were found that matched your criteria."));
	}
	
	@Test
	public void TC_03_SearchWithKeywordLenovo() {
		searchPage.inputToSearchTextbox("Lenovo");
		searchPage.clickToSearchButton();
		// Verify có sản phẩm xuất hiện
		searchPage.isAddToCartButton("ADD TO CART");
		// Verify sản phẩm có chứa chữ “Lenovo” 
		Assert.assertTrue(searchPage.isVerifyElements("Lenovo"));
		
	}
	
	@Test
	public void TC_04_AdvanceSearchWithParentCategories() {
		searchPage.inputToSearchTextbox("Apple Macbook Pro");
		searchPage.clickToAdvanceSearchCheckBox();
		searchPage.selectTextOfDropdown("Computers");
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isWrongDataErrorMessage("No products were found that matched your criteria."));
	}
	
	@Test
	public void TC_05_AdvanceSearchWithSubCategories() {
		searchPage.refreshCurrentPage(driver);
		footer.clickToSearchButton();
		searchPage.inputToSearchTextbox("Apple Macbook Pro");
		searchPage.clickToAdvanceSearchCheckBox();
		searchPage.selectTextOfDropdown("Computers");
		searchPage.clickToAutomaticallySearchCheckBox();
		searchPage.clickToSearchButton();
		// Verify sản phẩm có chứa chữ “Apple Macbook Pro” 
		Assert.assertTrue(searchPage.isVerifyElements("Apple Macbook Pro"));
		
		
	}
	public void loginAccount(String email, String password) {
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
	}
}
