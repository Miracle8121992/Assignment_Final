package pageUIs;

public class RegisterPageUI {
	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String VALID_INFORMATION_MESSAGE ="//div[@class='result']";
	public static final String FIRST_NAME_IS_REQUIRED_ERROR_MESSAGE = "//span[@id='FirstName-error']";
	public static final String LAST_NAME_IS_REQUIRED_ERROR_MESSAGE = "//span[@id='LastName-error']";
	public static final String EMAIL_IS_REQUIRED_ERROR_MESSAGE = "//span[@id='Email-error']";
	public static final String WRONG_EMAIL_ERROR_MESSAGE = "//span[text()='Wrong email']";
	public static final String PASSWORD_IS_REQUIRED_MESSAGE = "//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_IS_REQUIRED_MESSAGE = "//span[@id='ConfirmPassword-error']";
	public static final String REGISTER_COMPLETE_MESSAGE = "//div[text()='Your registration completed']";
	public static final String EMAIL_EXIST_ERROR_MESSAGE = "//li[normalize-space()='The specified email already exists']";
	public static final String PASSWORD_SMALLER_THAN_6_MESSAGE = "//p[normalize-space()='Password must meet the following rules:']";
	public static final String PASSWORD_SMALLER_THAN_6_MESSAGE2 = "//li[normalize-space()='must have at least 6 characters']";
	public static final String PASSWORD_DOES_NOT_MATCH_ERROR_MESSAGE = "//span[text()='The password and confirmation password do not match.']";
	
}