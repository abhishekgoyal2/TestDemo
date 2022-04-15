package com.bh.assign.stepdef.API;

import com.bh.assign.base.api.ApiBase;
import com.bh.assign.helper.APIConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class BillingAuthAPIStepdef {

    Response response;

//@When("User provide header details and make get call to retrieve all with access provided")
//    public void user_provide_header_details_and_make_get_call_to_retrieve_all_with_access_provided() {
//        // Write code here that turns the phrase above into concrete actions
//        String authToken=APIConstants.BEARER+response.then().extract().path("access_token").toString();
//        System.out.println("getting access token" +authToken);
//        response = ApiBase.getCallValidateStatus("https://qa.30preprod.com/api/client?q=",authToken);
//        System.out.println("getting response from -- > " + response.toString());
//        response.then().assertThat().statusCode(200).log().all();
//    }

}
