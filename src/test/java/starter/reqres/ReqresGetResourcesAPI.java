package starter.reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresGetResourcesAPI {
    public static String GET_LIST_RESOURCES = Constants.BASE_URL+"/api/unknown/";
    public static String GET_SINGLE_RESOURCE = Constants.BASE_URL+"/api/unknown/{id}";

    @Step("Get list resources")
    public void getListResourcesUser(){
        SerenityRest.given();
    }
    @Step ("Get single resource")
    public void getSingleResources(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step ("Get single resource with id using alphabet")
    public void getSingleResourceAlphabet(String id){
        SerenityRest.given().pathParam("id",id);
    }

}
