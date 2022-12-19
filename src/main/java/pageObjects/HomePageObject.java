package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	//constructor
	public HomePageObject (WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToProduct() {
		clickToElement(driver, HomePageUI.APPLE_MACBOOK_PRO);
	}
	
}
