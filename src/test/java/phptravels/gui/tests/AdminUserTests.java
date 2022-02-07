package phptravels.gui.tests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import phptravels.gui.pages.AdminLoginPage;
import phptravels.gui.pages.AdminsPage;
import phptravels.gui.pages.DashboardMenu;
import utils.BrowserActions;
import utils.BrowserFactory;
import utils.ExcelFileManager;
import utils.Helper;

@Epic("PHPTRAVELS")
@Feature("Admin User")
public class AdminUserTests {
    private ExcelFileManager spreadSheet;
    private WebDriver driver;

    private AdminLoginPage adminLoginPage;
    private DashboardMenu dashboardMenu;
    private AdminsPage adminsPage;

    private String currentTime = Helper.getCurrentTime();

    //////////////////////////////////////////////////////
    /////////////////// Test Cases //////////////////////

    @Test(description = "Create a new admin user with location permissions")
    public void createNewAdminUserWithLocationPermissions() {
	adminLoginPage	.loginAsDefaultAdminUser();
	dashboardMenu	.navigateToAdminsPage();
	adminsPage	.addAdminUser("Mahmoud", "ElSharkawy", "test" + currentTime + "@test.com", "12345678", "01234567890", "Egypt", "address1", "address2");
	adminsPage	.clickEditAdminUserIcon("test" + currentTime + "@test.com");
	adminsPage	.toggleLocationPermissions();
	adminsPage	.assertThatTheAdminUserIsInTheTable("test" + currentTime + "@test.com");
    }

    //////////////////////////////////////////////////////
    ///////////////// Configurations ////////////////////

    @BeforeMethod
    public void beforeMethod() {
	driver = BrowserFactory.getBrowser();
	
	adminLoginPage = new AdminLoginPage(driver);
	dashboardMenu = new DashboardMenu(driver);
	adminsPage = new AdminsPage(driver);
	
	adminLoginPage.navigateToAdminLoginPage();
    }
    
    @BeforeClass
    public void setup() {
	spreadSheet = new ExcelFileManager(new File("src/test/resources/TestData/AdminUserTestData.xlsx"));
	spreadSheet.switchToSheet("adminUser");

    }

    @AfterMethod
    public void tearDown() {
	BrowserActions.closeAllOpenedBrowserWindows(driver);
    }
}
