package phptravels.gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.qameta.allure.Step;
import utils.BrowserActions;
import utils.ElementActions;
import utils.ExtentReport;
import utils.PropertiesReader;

public class SignUpPage {
    private WebDriver driver;
    private String signUpPageUrl = PropertiesReader.getProperty("automationChallenge.properties", "phptravels.baseuri")
	    + "register";

    // Elements Locators
    private By firstName_textField = By.name("firstname");
    private By lastName_textField = By.name("lastname");
    private By phone_textField = By.name("phone");
    private By email_textField = By.name("email");
    private By password_textField = By.name("password");
    private By confirmPassword_textField = By.name("confirmpassword");
    private By alert_text = By.xpath("//div[contains(@class, 'alert')]");

    // Constructor
    public SignUpPage(WebDriver driver) {
	this.driver = driver;
    }

    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////// Actions ////////////////////////////////

    public SignUpPage navigateToSignUpPage() {
	BrowserActions.navigateToUrl(driver, signUpPageUrl);
	return this;
    }

    @Step("User Sign up with Data --> First Name: [{firstName}], Last Name: [{lastName}], Mobile Number: [{mobileNumber}], Email: [{email}] and Password: [{password}]")
    public UserAccountPage userSignUp(String firstName, String lastName, String mobileNumber, String email,
	    String password) {
	ExtentReport.info(MarkupHelper.createLabel("User Sign up", ExtentColor.BLUE));
	enterFirstNameField(firstName);
	enterLastNameField(lastName);
	enterMobileNumberField(mobileNumber);
	enterEmailField(email);
	enterPasswordFields(password);
	ElementActions.clickKeyboardKey(driver, confirmPassword_textField, Keys.ENTER);
	return new UserAccountPage(driver);
    }

    public SignUpPage invalidUserSignUp(String firstName, String lastName, String phone, String email,
	    String password) {
	userSignUp(firstName, lastName, phone, email, password);
	return this;
    }

    @Step("Enter First Name --> [{firstName}]")
    public SignUpPage enterFirstNameField(String firstName) {
	ElementActions.type(driver, firstName_textField, firstName);
	return this;
    }

    @Step("Enter Last Name --> [{lastName}]")
    public SignUpPage enterLastNameField(String lastName) {
	ElementActions.type(driver, lastName_textField, lastName);
	return this;
    }

    @Step("Enter Mobile Number --> [{mobileNumber}]")
    public SignUpPage enterMobileNumberField(String mobileNumber) {
	ElementActions.type(driver, phone_textField, mobileNumber);
	return this;
    }

    @Step("Enter Email --> [{email}]")
    public SignUpPage enterEmailField(String email) {
	ElementActions.type(driver, email_textField, email);
	return this;
    }

    @Step("Enter Password and Confirm Password --> [{password}]")
    public SignUpPage enterPasswordFields(String password) {
	ElementActions.type(driver, password_textField, password);
	ElementActions.type(driver, confirmPassword_textField, password);
	return this;
    }

    @Step("Get the text of the Alert message")
    public String getAlertMessage() {
	return ElementActions.getText(driver, alert_text);
    }

}
