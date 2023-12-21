package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresGetResourcesAPI;

public class ReqresResourcesStep {
    @Steps
    ReqresGetResourcesAPI reqresGetResourcesAPI;
    @Given("Get list resources")
    public void getListResource() {reqresGetResourcesAPI.getListResourcesUser();
    }

    @When("Send request get resource")
    public void sendRequestGetResource() {
        SerenityRest.when().get(ReqresGetResourcesAPI.GET_SINGLE_RESOURCE);
    }

    @Given("Get single resource with id {int}")
    public void getSingleResourceWith(int id) {
        reqresGetResourcesAPI.getSingleResources(id);
    }
}
