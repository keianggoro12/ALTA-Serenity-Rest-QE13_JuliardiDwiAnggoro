package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresDeleteAPI;

public class ReqresDeleteStepDef {
    @Steps
    ReqresDeleteAPI reqresDeleteAPI;

    @Given("Delete user with valid id {int}")
    public void updateUserWithValidId(int id) {
        reqresDeleteAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresDeleteAPI.DELETE_USER);
    }

    @Given("Delete user with id {string} using alphabet")
    public void deleteUserWithIdUsingAlphabet(String alphabet) {
        reqresDeleteAPI.deleteUserAlphabet(alphabet);
    }
}
