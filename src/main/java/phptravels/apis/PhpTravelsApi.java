package phptravels.apis;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import utils.ApiActions;
import utils.ExtentReport;
import utils.PropertiesReader;
import utils.ApiActions.RequestType;

public class PhpTravelsApi {
    String baseUrl = PropertiesReader.getProperty("automationPractice.properties", "phptravels.baseuri");
    ApiActions api = new ApiActions(baseUrl);

    // Expected status codes
    private static final int SUCCESS = 200;

    // Services Names
    private String signup_endpoint = "account/signup";


    @Step("User Sign up with Data --> First Name: [{firstName}], Last Name: [{lastName}], Mobile Number: [{mobileNumber}], Email: [{email}] and Password: [{password}]")
    public Response userSignUp(String firstName, String lastName, String mobileNumber, String email, String password) {
	ExtentReport.info(MarkupHelper.createLabel("User Sign up", ExtentColor.BLUE));

	Map<String, Object> formParams = new HashMap<>();
	formParams.put("firstname", firstName);
	formParams.put("lastname", lastName);
	formParams.put("phone", mobileNumber);
	formParams.put("email", email);
	formParams.put("password", password);
	formParams.put("confirmpassword", password);

	return api.performRequest(RequestType.POST, signup_endpoint, SUCCESS, null, null, formParams, null,
		null, null);

    }

}
