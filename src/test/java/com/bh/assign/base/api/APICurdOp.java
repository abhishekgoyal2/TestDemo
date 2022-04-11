package com.bh.assign.base.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.ini4j.Wini;
import org.json.JSONObject;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class APICurdOp {

    public static Response PostCallValidateStatus(String uri, JSONObject jsonBody){
      Response response= (Response) given().relaxedHTTPSValidation().contentType("application/json").body(jsonBody.toString()).post(uri);
        return response;
    }

    public static Response PostCallValidateStatus(String uri, JSONObject jsonBody,String authToken){
        Response response= (Response) given().relaxedHTTPSValidation().header("Authorization",authToken).contentType("application/json").body(jsonBody.toString()).post(uri);
        return response;
    }

    public static Response PostCallValidateStatus(String uri, File Jsonfile,String authToken){
        Response response= (Response) given().relaxedHTTPSValidation().header("Authorization",authToken).contentType("application/json").body(Jsonfile).post(uri);
        return response;
    }

    public static Response PutCallValidateStatus(String uri, File Jsonfile,String authToken){
        Response response= (Response) given().relaxedHTTPSValidation().header("Authorization",authToken).contentType("application/json").body(Jsonfile).put(uri);
        return response;
    }

    public static Response getCallValidateStatus(String uri,String authToken){
        Response response= (Response) given().relaxedHTTPSValidation().header("Authorization",authToken).contentType("application/json").get(uri);
        return response;
    }

    public static Response deleteCallValidateStatus(String uri,String authToken){
        Response response= (Response) given().relaxedHTTPSValidation().header("Authorization",authToken).contentType("application/json").delete(uri);
        return response;
    }

    public static Response deleteCallValidateStatusAl(String uri,String authToken){
        Response response= (Response) given().relaxedHTTPSValidation().header("Authorization",authToken).contentType("application/json").delete(uri);
       given().filter(new AllureRestAssured());
        return response;
    }

    //-- validate has key
    public static boolean checkJsonHasKey(String key, Response response)
    {
        JSONObject json= new JSONObject(response.asString());
        return json.has(key);
    }

    public static String getURI() {
        String uri = null;
        {
            Wini ini = null;
            try {
                ini = new Wini(new File("src\\test\\resources\\util\\IniFile\\configuration.ini"));
                uri = ini.get("apiConstant", "poke_man_URI");
//                System.out.print("URI : " + uri + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return uri;
    }

    public static String getURI(String filepath,String uri) {
        {
            Wini ini = null;
            try {
                ini = new Wini(new File(filepath));
                uri = ini.get("apiConstant",uri);
                System.out.print("URI : " + uri + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return uri;
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethodSetup(ITestResult result) throws InterruptedException {
        // Setting Test Status to Extent
        switch(result.getStatus()) {
            case ITestResult.SUCCESS:
                String testPass = "Test Case " + " -- PASSED";
                Logger.getLogger(testPass).info(testPass);
                break;
            case ITestResult.FAILURE:
                String testFail=("Test Case " +  " -- FAILED");
                Logger.getLogger(testFail).info(testFail);
                break;
            case ITestResult.SKIP:
                String testSkip=("Test Case "  + " -- SKIPPED");
                break;
            default:
                String testFailUnrecognised=("Result Not Recognized");
                break;
        }

    }
}
