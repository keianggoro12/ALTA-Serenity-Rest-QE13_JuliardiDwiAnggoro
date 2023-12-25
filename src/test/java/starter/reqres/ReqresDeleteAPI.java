package starter.reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class ReqresDeleteAPI {
    public static String DELETE_USER = Constants.BASE_URL+"/api/users/{id}";
    @Step ("Delete user")
    public void deleteUser (int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step ("Delete user using alphabet")
    public void deleteUserAlphabet (String id){
        SerenityRest.given().pathParam("id",id);
    }
}
