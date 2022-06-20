package phptravels.gui.tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import phptravels.gui.pages.LoginPage;
import phptravels.gui.pages.SignupPage;
import utils.BrowserActions;
import utils.BrowserFactory;
import utils.Helper;
import utils.JsonFileManager;

@Epic("PHPTRAVELS")
@Feature("Admin User")
public class SignupTests {
    private WebDriver driver;
    
    JsonFileManager testData;

    private SignupPage signupPage;
    private LoginPage loginPage;

    private String currentTime = Helper.getCurrentTime();

    //////////////////////////////////////////////////////
    /////////////////// Test Cases //////////////////////

    @Test(description = "PHPTRAVELS - GUI - Valid User Signup")
    @Description("When I enter valid data in the sign up form And click the signup button, Then I should be registered successfully And be navigated to the user account page And I can see my user data and Hi message")
    @Story("Signup")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("Test_case")
    public void testingValidUserSignUp() {
	String email = testData.getTestData("user.email") + currentTime + "@" + testData.getTestData("user.emailDomain");
	
	signupPage	.userSignUp(testData.getTestData("user.firstName"), testData.getTestData("user.lastName"), testData.getTestData("user.phoneNumber"), email, testData.getTestData("user.password"), testData.getTestData("user.accountType"));
	loginPage	.assertOnFormMessage(testData.getTestData("messages.successfulSignup"));
    }
    
    @Test(description = "PHPTRAVELS - GUI - Invalid User Signup - Email Already Exists", dependsOnMethods = { "testingValidUserSignUp" })
    @Description("Given i already signed up with an email, When I use the same email for new sign up , Then I should get an error message ")
    @Story("Signup")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Test_case")
    public void testingInvalidUserSignUp_emailAlreadyExists() {
	String email = testData.getTestData("user.email") + currentTime + "@" + testData.getTestData("user.emailDomain");
	
	signupPage	.userSignUp(testData.getTestData("user.firstName"), testData.getTestData("user.lastName"), testData.getTestData("user.phoneNumber"), email, testData.getTestData("user.password"), testData.getTestData("user.accountType"));
	signupPage	.assertOnFormMessage(testData.getTestData("messages.emailExists"));
    }
    
    @Test(description = "PHPTRAVELS - GUI - Invalid User Sign Up - Wrong Email Format")
    @Description("When I use a wrong email format on the sign up , Then I should get an error message ")
    @Story("Signup")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("Test_case")
    @Issue("Software_bug")
    public void testingInvalidUserSignUp_emailWrongFormat() {	
	signupPage	.userSignUp(testData.getTestData("user.firstName"), testData.getTestData("user.lastName"), testData.getTestData("user.phoneNumber"), testData.getTestData("user.email") + currentTime, testData.getTestData("user.password"), testData.getTestData("user.accountType"));
	signupPage	.assertOnFormMessage(testData.getTestData("messages.emailWrongFormat"));	
    }

    //////////////////////////////////////////////////////
    ///////////////// Configurations ////////////////////

    @BeforeMethod
    public void methodSetup() {
	testData = new JsonFileManager("src/test/resources/TestData/phptravelsTestData.json");
	
	driver = BrowserFactory.getBrowser();
	
	signupPage = new SignupPage(driver);
	loginPage = new LoginPage(driver);
	
	signupPage.navigateToSignupPage();
    }

    @AfterMethod
    public void methodTearDown() {
	BrowserActions.closeAllOpenedBrowserWindows(driver);
    }
}
