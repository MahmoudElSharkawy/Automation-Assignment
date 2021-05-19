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

public class LoginPage {
    private WebDriver driver;
    private String loginPageUrl = PropertiesReader.getProperty("automationChallenge.properties", "phptravels.baseuri")
	    + "login";

    // Elements Locators
    private By email_textField = By.name("username");
    private By password_textField = By.name("password");
    private By alert_text = By.xpath("//div[contains(@class, 'alert')]");

    // Constructor
    public LoginPage(WebDriver driver) {
	this.driver = driver;
    }

    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////// Actions ////////////////////////////////

    public LoginPage navigateToLoginPage() {
	BrowserActions.navigateToUrl(driver, loginPageUrl);
	return this;
    }

    @Step("User Login with Data --> Email: [{email}] and Password: [{password}]")
    public UserAccountPage userLogin(String email, String password) {
	ExtentReport.info(MarkupHelper.createLabel("User Login", ExtentColor.BLUE));
	enterEmail(email);
	enterPassword(password);
	ElementActions.clickKeyboardKey(driver, password_textField, Keys.ENTER);
	return new UserAccountPage(driver);
    }

    public LoginPage invalidUserLogin(String email, String password) {
	userLogin(email, password);
	return this;
    }

    @Step("Enter Email --> [{email}]")
    public UserAccountPage enterEmail(String email) {
	ElementActions.type(driver, email_textField, email);
	return new UserAccountPage(driver);
    }

    @Step("Enter password --> [{password}]")
    public UserAccountPage enterPassword(String password) {
	ElementActions.type(driver, password_textField, password);
	return new UserAccountPage(driver);
    }

    @Step("Get the text of the Alert message")
    public String getAlertMessage() {
	return ElementActions.getText(driver, alert_text);
    }

}
