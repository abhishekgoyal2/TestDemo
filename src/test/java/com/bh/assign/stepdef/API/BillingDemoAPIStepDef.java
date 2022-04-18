package com.bh.assign.stepdef.API;

import com.bh.assign.base.api.ApiBase;
import com.bh.assign.helper.APIConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class BillingDemoAPIStepDef {

    Response response;

//    @Given("user hit the {string} and {string} apiEndpoint with header details and make Post call")
//    public void user_hit_the_and_api_endpoint_with_header_details_and_make_post_call(String uri, String jsonFilepath) {
//        // Write code here that turns the phrase above into concrete actions
//        uri = ApiBase.getURI(APIConstants.fileBasePath+"IniFile/configuration.ini", uri);
//        System.out.println(uri);
//        response = ApiBase.PostCallValidateStatus(uri, new File(jsonFilepath), APIConstants.Basic+" QVVUT01BVEVEX1RFU1RJTkc6dDNzdEBsbHRoM3RoMW5ncw==");
//        System.out.println("getting response from post call-- > " + response.toString());
//    }
    @When("User provide header details and make Post call for grant access token")
    public void user_provide_header_details_and_make_post_call_for_grant_access_token() {
        // Write code here that turns the phrase above into concrete actions

        JSONObject jsonBody = new JSONObject();
        response = ApiBase.PostCallValidateStatus("https://qa.30preprod.com/api/token?grant_type=client_credentials", jsonBody, APIConstants.Basic+" QVVUT01BVEVEX1RFU1RJTkc6dDNzdEBsbHRoM3RoMW5ncw==");
        System.out.println("getting response from post call-- > " + response.toString());
        response.then().assertThat().statusCode(200).log().all();
    }

    @When("User provide header details and make get call to retrieve all with access provided")
    public void user_provide_header_details_and_make_get_call_to_retrieve_all_with_access_provided() {
        // Write code here that turns the phrase above into concrete actions
        String authToken=APIConstants.BEARER+response.then().extract().path("access_token").toString();
        System.out.println("getting access token" +authToken);
        response = ApiBase.getCallValidateStatus("https://qa.30preprod.com/api/client?q=",authToken);
        System.out.println("getting response from -- > " + response.toString());
        response.then().assertThat().statusCode(200).log().all();
    }

    @When("User provide header details and make get call to Payment method with access provided")
    public void user_provide_header_details_and_make_get_call_to_payment_method_with_access_provided() {
        // Write code here that turns the phrase above into concrete actions
        String authToken=APIConstants.BEARER+response.then().extract().path("access_token").toString();
        System.out.println("getting access token " +authToken);
        response = ApiBase.getCallValidateStatus("https://qa.30preprod.com/api/abcblg/payment-method",authToken);
        System.out.println("getting response from -- > " + response.body().prettyPrint());
        response.then().assertThat().statusCode(200).log().all();
        String countryCode= response.then().extract().path("content.address.countryCode").toString();
        System.out.println("getting field country->> " +countryCode);
    }

    // Post Payment method call
    @When("User provide header details and make Post call to Payment method with access provided")
    public void user_provide_header_details_and_make_post_call_to_payment_method_with_access_provided() {
        // Write code here that turns the phrase above into concrete actions
        String authToken=APIConstants.BEARER+response.then().extract().path("access_token").toString();
        System.out.println("getting access token " +authToken);
        response = ApiBase.PostCallValidateStatus("https://qa.30preprod.com/api/abcblg/payment-method",new File(APIConstants.fileBasePath+"Jsonfile/demobilling/paymentMethod.json"),authToken);
        System.out.println("getting response from -- > " + response.body().prettyPrint());
        try {
            response.then().assertThat().statusCode(200).log().all();

        } catch (Throwable e )
        {
            e.printStackTrace();
        }
    }

}
