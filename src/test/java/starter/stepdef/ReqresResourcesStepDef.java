package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresGetResourcesAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;
import io.restassured.module.jsv.JsonSchemaValidator;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class ReqresResourcesStepDef {
    @Steps
    ReqresGetResourcesAPI reqresGetResourcesAPI;
    @Given("Get list resources")
    public void getListResource() {reqresGetResourcesAPI.getListResourcesUser();
    }
    @When("Send request get list resources")
    public void sendRequestGetListResources(){
        SerenityRest.when().get(ReqresGetResourcesAPI.GET_LIST_RESOURCES);
    }

    @When("Send request get resource")
    public void sendRequestGetResource() {
        SerenityRest.when().get(ReqresGetResourcesAPI.GET_SINGLE_RESOURCE);
    }

    @Given("Get single resource with id {int}")
    public void getSingleResourceWith(int id) {
        reqresGetResourcesAPI.getSingleResources(id);
    }

    @And("Response body id was {int}")
    public void responseBodyIdWas(int id) {
        SerenityRest.and().body(ReqresResponses.DATA_ID, equalTo(id));
    }
    @And("Validate get list resources json schema {string}")
    public void validateGetListUsersJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get single resource with id {string} using alphabet")
    public void getSingleResourceWithIdUsingAlphabet(String alphabet) {
        reqresGetResourcesAPI.getSingleResourceAlphabet(alphabet);
    }


    @Given("Get single resource with id {string} using special character")
    public void getSingleResourceWithIdUsingSpecialCharacter(String specialchara) {
        reqresGetResourcesAPI.getSingleResourceAlphabet(specialchara);
    }
}
