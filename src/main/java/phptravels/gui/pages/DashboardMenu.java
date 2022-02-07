package phptravels.gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import utils.ElementActions;

public class DashboardMenu {
    private WebDriver driver;

    // Elements Locators
    private final By dashboardMenu_button = By.id("drawerToggle");
    private final By navigation_body = By.xpath("//body[contains(@class,'nav-fixed')]");
    private final By Accounts_linkText = By.xpath("//a[contains(.,'Accounts')]");
    private final By Admins_linkText = By.xpath("//a[contains(.,'Admins')]");

    // Constructor
    public DashboardMenu(WebDriver driver) {
	this.driver = driver;
    }

    //////////////////////////////////////////////////////////////////
    //////////////////////////// Actions ////////////////////////////

    @Step("Navigate to Admin Page")
    public void navigateToAdminsPage() {
	if (!ElementActions.getAttributeValue(driver, navigation_body, "class").contains("drawer-toggled")) {
	    ElementActions.click(driver, dashboardMenu_button);
	}
	new ElementActions(driver)
	.click(Accounts_linkText)
	.click(Admins_linkText);
    }

}
