package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresPostRegisterAPI;
import starter.utils.Constants;

import java.io.File;

public class ReqresRegistStepDef {
    @Steps
    ReqresPostRegisterAPI reqresPostRegisterAPI;
    @Given("Post register with valid data on json {string}")
    public void postRegisterWithValidDataOnJson(String json) {
        File jsonRegisterUser = new File(Constants.REQ_BODY+json);
        reqresPostRegisterAPI.postRegisterUser(jsonRegisterUser);
    }

    @When("Send request post register")
    public void sendRequestPostRegister() {
        SerenityRest.when().post(ReqresPostRegisterAPI.POST_REGISTER);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Post register with invalid data on json {string}")
    public void postRegisterWithInvalidDataOnJson(String json) {
        File jsonRegisterUser = new File(Constants.REQ_BODY+json);
        reqresPostRegisterAPI.postRegisterUser(jsonRegisterUser);
    }
}
