package com.mapsynq.automation.pages.profile;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mapsynq.automation.helper.UtilClass;

public class UserRegistrationPage extends UtilClass{

	private static Logger log = Logger.getLogger(UserRegistrationPage.class);
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "profile_first_name")
    private WebElement txtFirstName;

	@FindBy(id = "profile_last_name")
    private WebElement txtLastName;

	@FindBy(xpath = "//select[@id='profile_country']")
    private WebElement ddlCountry;

	@FindBy(id = "profile_gender_M")
    private WebElement btnGender;

	@FindBy(id = "profile_dob")
    private WebElement txtDOB;

	@FindBy(id = "profile_email")
    private WebElement txtEmail;

	@FindBy(id = "password")
    private WebElement txtPassword;

	@FindBy(id = "identity[password_confirmation]")
    private WebElement txtConfirmPassword;

	@FindBy(id = "chk_agree")
    private WebElement chkAgreeBox;

	@FindBy(name = "commit")
    private WebElement btnSubmit;

	@FindBy(xpath = "//div[@class='error_signup']")
    private WebElement lblPopUp;


	public UserRegistrationPage(WebDriver driver) {
		log.info("Home Page constructor is Invoked");
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.titleContains("mapSYNQ user profile"));
	}

	public UserRegistrationPage setFirstName(String firstName) {
		setText(driver, txtFirstName, firstName);
		log.info("Entered First Name : " + firstName);

		return this;
	}

	public UserRegistrationPage setLastName(String lastName) {
		setText(driver, txtLastName, lastName);
		log.info("Entered First Name : " + lastName);

		return this;
	}
	
	public UserRegistrationPage clickGenderOption() {
		log.info("Clicking Male Gender");
		clickElement(driver, btnGender);
		
		return this;
	}

	public UserRegistrationPage selectCountry(String country) {
		selectByValue(ddlCountry, country);
		log.info("Selected Country Name : " + country);

		return this;
	}

	public UserRegistrationPage selectGender() {
		log.info("Select Gender for the Account Creation");
		clickElement(driver, btnGender);
		log.info("Selected Gender for the Account Creation");

		return this;
	}

	public UserRegistrationPage setDOB(String dob) {
		setText(driver, txtDOB, dob);
		log.info("Entered DOB : " + dob);

		return this;
	}

	public UserRegistrationPage setEmail(String email) {
		setText(driver, txtEmail, email);
		log.info("Entered E-mail : " + email);

		return this;
	}
	
	public UserRegistrationPage setPassword(String password) {
		setText(driver, txtPassword, password);
		log.info("Entered Password : " + password);

		return this;
	}
	
	public UserRegistrationPage setConfirmPassword(String password) {
		setText(driver, txtConfirmPassword, password);
		log.info("Entered Confirm Password : " + password);

		return this;
	}

	public UserRegistrationPage clickAgreeCheckBox() {
		clickElement(driver, chkAgreeBox);
		log.info("Checked Agree for Creating User Account");

		return this;
	}

	public UserRegistrationPage clickSubmit() {
		log.info("Clicking Submit Button");
		clickElement(driver, btnSubmit);
		
		return this;
	}

	public String getMessage() {
		String msg = getElementText(driver, lblPopUp);
		log.info("Message : "+msg);

		return msg;
	}

}