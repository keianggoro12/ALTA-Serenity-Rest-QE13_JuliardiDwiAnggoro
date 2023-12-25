package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.reqres.ReqresUpdateUserAPI;
import starter.utils.Constants;
import io.restassured.module.jsv.JsonSchemaValidator;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class ReqresUpdateStepDef {
    @Steps
    ReqresUpdateUserAPI reqresUpdateUserAPI;

    @Given("Update user with valid id {int} and json {string}")
    public void updateUserWithValidIdAndJson(int id, String json) {
        File jsonUpdateUser = new File(Constants.REQ_BODY+json);
        reqresUpdateUserAPI.updateUser(id,jsonUpdateUser);

    }
//    @Given("Update user with id {string} using alphabet and json {string)")
//    public void updateUserWithIdUsingAlphabetAndJson(String id, String json) {
//        File jsonInvalidUpdateUser = new File(Constants.REQ_BODY+json);
//        reqresUpdateUserAPI.updateUser(id,jsonInvalidUpdateUser);
//
//    }

    @Given("Update user with id {string} using alphabet and json {string}")
    public void updateUserWithIdUsingAlphabetAndJson(String id, String json) {
        File jsonInvalidUpdateUser = new File(Constants.REQ_BODY+json);
        reqresUpdateUserAPI.updateUser(id,jsonInvalidUpdateUser);
    }
    @Given("Update user with id {string} using special character and json {string}")
    public void updateUserWithIdUsingSpecialCharaAndJson(String id, String json) {
        File jsonInvalidUpdateUser = new File(Constants.REQ_BODY+json);
        reqresUpdateUserAPI.updateUser(id,jsonInvalidUpdateUser);
    }

    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when().put(ReqresAPI.UPDATE_USER);

    }
    @Then("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @And("Validate update user json schema {string}")
    public void validateUpdateListUsersJsonSchema(String json) {
        File jsonUpdateSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonUpdateSchema));
    }


    @Given("Update user with id {int} without name on json {string}")
    public void updateUserWithIdWithoutNameOnJson(int id, String json) {
        File jsonUpdateUser = new File(Constants.REQ_BODY+json);
        reqresUpdateUserAPI.updateUser(id,jsonUpdateUser);
    }

    @Given("Update user with id {int} without job on json {string}")
    public void updateUserWithIdWithoutJobOnJson(int id, String json) {
        File jsonUpdateUser = new File(Constants.REQ_BODY+json);
        reqresUpdateUserAPI.updateUser(id,jsonUpdateUser);
    }

    @Given("Update user with id {int} and empty json {string}")
    public void updateUserWithIdAndEmptyJson(int id, String json) {
        File jsonUpdateUser = new File(Constants.REQ_BODY+json);
        reqresUpdateUserAPI.updateUser(id,jsonUpdateUser);
    }
}
