package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;
    
    @Given("Get list users with page {int}")
    public void getListUsersWithPage(int page){
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers(){
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);

    }
    @Then("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.and().body(ReqresResponses.PAGE,equalTo(page));

    }

    @And("Validate get list users json schema {string}")
    public void validateGetListUsersJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

//    @And("Validate update user json schema {string}")
//    public void validateUpdateListUsersJsonSchema(String json) {
//        File jsonUpdateSchema = new File(Constants.JSON_SCHEMA+json);
//        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonUpdateSchema));
//    }

//    dimatikan sementara
//    @Then("Status code should be {int}")
//    public void statusCodeShouldBe(int statusCode){
//        SerenityRest.then().statusCode(statusCode);
//    }

    //////

    @Given("Post create user with valid json {string}")
    public void postCreateUserWithValidJson(String json) {
        File jsonCreateUser = new File(Constants.REQ_BODY+json);
        reqresAPI.postCreateUser(jsonCreateUser);
    }

    @And("Validate create user json schema {string}")
    public void validateCreateUserJsonSchema(String json)
    {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
    @When("Post request post create user")
    public void postRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USERS);
    }


//    @And("Response body name was {string} and job was {string}")
//    public void responseBodyNameWasAndJobWas(String name, String job) {
//        SerenityRest.and()
//                .body(ReqresResponses.NAME, equalTo(name))
//                .body(ReqresResponses.JOB, equalTo(job));
//    }

////////////////////
//    @Given("Update user with valid id {int} and json {string}")
//    public void updateUserWithValidIdAndJson(int id, String json) {
//        File jsonUpdateUser = new File(Constants.REQ_BODY+json);
//        reqresAPI.updateUser(id,jsonUpdateUser);
//
//    }

//    @When("Send request update user")
//    public void sendRequestUpdateUser() {
//        SerenityRest.when().put(ReqresAPI.UPDATE_USER);
//
//    }

//    @Given("Delete user with valid id {int}")
//    public void updateUserWithValidId(int id) {
//        reqresAPI.deleteUser(id);
//    }
//
//    @When("Send request delete user")
//    public void sendRequestDeleteUser() {
//        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
//    }
//

}
