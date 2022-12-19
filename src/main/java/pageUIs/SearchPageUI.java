package pageUIs;

public class SearchPageUI {
	public static final String SEARCH_TEXTBOX = "//input[@id='q']";
	public static final String SEARCH_BUTTON = "//button[@class='button-1 search-button']";
	public static final String SEARCH_EMPTY_ERROR_MESSAGE = "//div[@class='warning']";
	public static final String SEARCH_WRONG_DATA_ERROR_MESSAGE = "//div[@class='no-result']";
	public static final String ADD_TO_CART_BUTTON = "//span[text()='Sort by']/parent::div/parent::div/following-sibling::div//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/3/1/1\"),!1']";
	public static final String ADVANCE_SEARCH_CHECK_BOX = "//input[@id='advs']";
	public static final String CATEGORY_DROPBOX = "//select[@id='cid']";
	public static final String AUTOMATICALLY_SEARCH_CHECK_BOX = "//input[@id='isc']";
	public static final String PRODUCT_NAME_TEXT = "//h2[@class='product-title']";
}
