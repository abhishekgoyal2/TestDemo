@BillingDemo
Feature:Demo abc billing rest api test validation

#######################################

	@Get_Access_token_Post
	Scenario Outline: get billing access token be sending API requests of type Post to grant access to server
		Given user hit the "<uri>" and "<jsonFilepath>" apiEndpoint with header details and make Post call
#	|header|contentType|application/json|
		Then user will get status code <expectedStatusCode> as respond code
#    	|Param1_toValidate       |results.sunrise      |
#    	|Param2_toValidate       |results.sunset             |
		And Response has the json "<expectedKey>" in response

		And Response matches the schema json "<expectedField1>"  with "<expectedValue1>" and "<expectedField2>"  with "<expectedValue2>" in response
		Examples:
			| uri |jsonFilepath|expectedStatusCode |expectedKey |expectedField1 |expectedValue1 |expectedField2 |expectedValue2 |
			|grantAccessUrl|src/test/resources/util/Jsonfile/billinGrantaccess.json|200 |access_token |token_type | bearer |expires_in |899  |

	@Scenario_postAPI
	Scenario: Send API requests of  type Post to server
#	Given user hit the uri apiEndpoint
		When User provide header details and make Post call for grant access token
		When User provide header details and make get call to retrieve all with access provided

	@Scenario_get_PaymentMethod
	Scenario: Send API requests of  type get for Payment method to server
#	Given user hit the uri apiEndpoint
		When User provide header details and make Post call for grant access token
		When User provide header details and make get call to Payment method with access provided

	@Scenario_post_PaymentMethod
	Scenario: Send API requests of  type Post for Payment method to server
#	Given user hit the uri apiEndpoint
		When User provide header details and make Post call for grant access token
		When User provide header details and make Post call to Payment method with access provided
