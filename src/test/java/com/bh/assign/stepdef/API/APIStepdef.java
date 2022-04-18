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
import static org.junit.Assert.*;


public class APIStepdef {

    Response response;

    @Given("user hit the uri apiEndpoint")
    public void user_hit_the_uri_api_endpoint() {
        // Write code here that turns the phrase above into concrete actions
        given().filter(new AllureRestAssured());
        String uri = ApiBase.getURI();
        System.out.print("URI : " + uri + "\n");
        response = ApiBase.getCallValidateStatus(ApiBase.getURI(), "");
        System.out.println("getting response body from server -- " + response.body().asString());
    }

    @When("User provide header details and make GET call")
    public void user_provide_header_details_and_make_get_call() {
        // Write code here that turns the phrase above into concrete actions

    }

    //validate status code
    @Then("user will get status code {int} as respond code")
    public void user_will_get_status_code_as_respond_code(Integer expectedStatusCode) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("getting response status code  -- " + response.getStatusCode());
        response.then().assertThat().statusCode(expectedStatusCode);
    }

    //validate response matching fields
    @Then("Response matches the schema json {string} response")
    public void response_matches_the_schema_json_response(String field) {
        // Write code here that turns the phrase above into concrete actions
        field = response.then().extract().path("forms.name").toString();
        System.out.println("getting name field ..> " + field);
        assertEquals("[pikachu]", field);
    }

    // post call
    @When("User provide header details and make Post call")
    public void user_provide_header_details_and_make_post_call() {
        // Write code here that turns the phrase above into concrete actions
        File jsonfile = new File("src/test/resources/util/Jsonfile/requestbodyherokuappbooking.json");
        response = ApiBase.PostCallValidateStatus("https://restful-booker.herokuapp.com/booking", jsonfile, "");
        System.out.println("getting response from post call-- > " + response.toString());
        response.then().assertThat().statusCode(200).log().all();
    }

    @When("User provide header details and make Put call")
    public void user_provide_header_details_and_make_put_call() {
        // Write code here that turns the phrase above into concrete actions
        File jsonfile = new File("src/test/resources/util/Jsonfile/jsonplaceholderupdatebody.json");
        response = ApiBase.PutCallValidateStatus("https://jsonplaceholder.typicode.com/posts/1", jsonfile, "");
        System.out.println("getting response ->> " + response.toString());
        response.then().assertThat().statusCode(200).log().all();
        boolean b = ApiBase.checkJsonHasKey("id", response);
        System.out.println("getting field boolean value->> " + b);
        assertTrue(b);
    }

    @When("User provide header details and make delete call")
    public void user_provide_header_details_and_make_delete_call() {
        // Write code here that turns the phrase above into concrete actions
        response = ApiBase.getCallValidateStatus("https://api.stripe.com/v1/customers", "Bearer sk_test_4eC39HqLyjWDarjtT1zdp7dc");
        String customerId = response.then().extract().path("data.id[0]");
        System.out.println("customer id is ->> " + customerId);
        response = ApiBase.deleteCallValidateStatus("https://api.stripe.com/v1/customers/" + customerId, "Bearer sk_test_4eC39HqLyjWDarjtT1zdp7dc");
        System.out.println("getting response ->> " + response.then().log().all().toString() + " getting status code --> " + response.getStatusCode());
        response.then().assertThat().statusCode(200).log().all();
    }

    // Validation of schema and other

    @Then("user validate status code and existing key")
    public void user_validate_status_code_and_existing_key() {
        // Write code here that turns the phrase above into concrete actions
        response.then().assertThat().statusCode(200).log().all();

        boolean b = ApiBase.checkJsonHasKey("bookingid", response);
        System.out.println("getting field boolean value->> " + b);
        assertTrue(b);
    }

    @Then("Response matches the schema json response")
    public void response_matches_the_schema_json_response() {
        // Write code here that turns the phrase above into concrete actions
        //Get JsonPath instance of above JSON string
        String lastname = response.then().extract().path("booking.lastname").toString();
        String firstname = response.then().extract().path("booking.firstname").toString();
        System.out.println("getting name field ..> " + lastname);
        assertEquals("Brown", lastname);
        assertEquals("Jim", firstname);
    }

// ** with scenario outline api call and schema,key,Status validation:
    //**

    //Get call api to server
    @Given("user hit the {string} apiEndpoint with header details and make {string} call")
    public void user_hit_the_api_endpoint_with_header_details_and_make_call(String uri, String get) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("getting uri ->> " + uri);
        response = ApiBase.getCallValidateStatus(uri, "");
        System.out.println("getting response body from server -- " + response.body().asString());
    }

    //Post call api to server
    @Given("user hit the {string} apiEndpoint with header details and make Post call")
    public void user_hit_the_api_endpoint_with_header_details_and_make_post_call(String uri) {
        // Write code here that turns the phrase above into concrete actions
        File jsonfile = new File("src/test/resources/util/Jsonfile/requestbodyherokuappbooking.json");
        response = ApiBase.PostCallValidateStatus(uri, jsonfile, "");
        System.out.println("getting response from post call-- > " + response.toString());

    }

    //Put call api to server
    @Given("user hit the {string} apiEndpoint with header details and make Put call")
    public void user_hit_the_api_endpoint_with_header_details_and_make_put_call(String uri) {
        // Write code here that turns the phrase above into concrete actions
        File jsonfile = new File("src/test/resources/util/Jsonfile/jsonplaceholderupdatebody.json");
        response = ApiBase.PutCallValidateStatus(uri, jsonfile, "");
        System.out.println("getting response ->> " + response.toString());
    }

    //delete call api to server

    @Given("user hit the {string} apiEndpoint with header details and make delete call")
    public void user_hit_the_api_endpoint_with_header_details_and_make_delete_call(String uri) {
        // Write code here that turns the phrase above into concrete actions
        response = ApiBase.getCallValidateStatus(uri,APIConstants.BEARER +" sk_test_4eC39HqLyjWDarjtT1zdp7dc");
        String customerId = response.then().extract().path("data.id[0]");
        System.out.println("customer id is ->> " + customerId);
        System.out.println("endPoint is ->> " + uri + "/" + customerId);
        response = ApiBase.deleteCallValidateStatus(uri + "/" + customerId, "Bearer sk_test_4eC39HqLyjWDarjtT1zdp7dc");
        System.out.println("getting response ->> " + response.then().log().all().toString() + " getting status code --> " + response.getStatusCode());
        response.then().assertThat().statusCode(200).log().all();
    }

    //key validation
    @Then("Response has the json {string} in response")
    public void response_has_the_json_in_response(String expectedKey) {
        // Write code here that turns the phrase above into concrete actions
        response.then().assertThat().statusCode(200).log().all();
        boolean b = ApiBase.checkJsonHasKey(expectedKey, response);
        System.out.println("getting field boolean value->> " + b);
        assertTrue(b);
    }

    //schema validation
    @Then("Response matches the schema json {string}  with {string} in response")
    public void response_matches_the_schema_json_with_in_response(String expectedField, String expectedValue) {
        // Write code here that turns the phrase above into concrete actions
        String actualValue1 = response.then().extract().path(expectedField).toString();
        String actualValue2 = response.then().extract().path(expectedField).toString();
        //validation of schema response
        System.out.println("getting name field ..> " + actualValue1);
        assertEquals(actualValue1, expectedValue);
        assertEquals(actualValue2, expectedValue);
    }

    // mulltiple response schema validation
    @Then("Response matches the schema json {string}  with {string} and {string}  with {string} in response")
    public void response_matches_the_schema_json_with_and_with_in_response(String expectedField1, String expectedValue1, String expectedField2, String expectedValue2) {
        // Write code here that turns the phrase above into concrete actions
        String actualValue1 = response.then().extract().path(expectedField1).toString();
        String actualValue2 = response.then().extract().path(expectedField2).toString();
        //validation of schema response
        System.out.println("getting name field ..> value1 " + actualValue1 + " value2->> " + actualValue2);
        assertEquals(actualValue1, expectedValue1);
        assertEquals(actualValue2, expectedValue2);
    }
// Step for calling uri with json file parameterised

    @Given("user hit the {string} and {string} apiEndpoint with header details and make Post call")
    public void user_hit_the_and_api_endpoint_with_header_details_and_make_post_call(String uri, String jsonFilepath) {
        // Write code here that turns the phrase above into concrete actions
        uri = ApiBase.getURI(APIConstants.fileBasePath+"IniFile/configuration.ini", uri);
        System.out.println(uri);
        response = ApiBase.PostCallValidateStatus(uri, new File(jsonFilepath), APIConstants.Basic+" QVVUT01BVEVEX1RFU1RJTkc6dDNzdEBsbHRoM3RoMW5ncw==");
        System.out.println("getting response from post call-- > " + response.toString());
    }

}
