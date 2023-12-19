package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

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


    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode){
        SerenityRest.then().statusCode(statusCode);
    }


    //////

    @Given("Post create user with valid json {string}")
    public void postCreateUserWithValidJson(String json) {
        File jsonCreateUser = new File(Constants.REQ_BODY+json);
        reqresAPI.postCreateUser(jsonCreateUser);
    }

    @When("Post request post create user")
    public void postRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USERS);
    }
}
