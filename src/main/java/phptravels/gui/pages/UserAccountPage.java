package phptravels.gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import utils.ElementActions;

public class UserAccountPage {
    private WebDriver driver;

    // Constructor
    public UserAccountPage(WebDriver driver) {
	this.driver = driver;
    }

    // Elements
    private By hi_text = By.xpath("//*[@style='margin-left: 17px']");

    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////// Actions ////////////////////////////////

    @Step("Get the text of the Hi message")
    public String getHiMessage() {
	return ElementActions.getText(driver, hi_text);
    }

}
