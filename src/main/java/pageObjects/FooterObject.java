package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.FooterUI;

public class FooterObject extends BasePage {
	WebDriver driver;
	
	//constructor
	public FooterObject (WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToSearchButton() {
		clickToElement(driver, FooterUI.SEARCH_BUTTON);
	}
}
