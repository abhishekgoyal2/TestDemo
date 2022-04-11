Feature: rest api test validation

#######################################
	@Scenario_getAPI
Scenario: Send API requests of type GET to server
	Given user hit the uri apiEndpoint
	When User provide header details and make GET call
#	|header|contentType|application/json|
	Then user will get status code 200 as respond code
#    	|Param1_toValidate       |results.sunrise      |
#    	|Param2_toValidate       |results.sunset             |
    	
    And Response matches the schema json "field" response
	

#######################################
	@Scenario_postAPI
Scenario: Send API requests of  type Post to server
#	Given user hit the uri apiEndpoint
	When User provide header details and make Post call
#	|header|contentType|application/json|
	Then user will get status code 200 as respond code
		Then user validate status code and existing key
#    	|Param1_toValidate       |results.sunrise      |
#    	|Param2_toValidate       |results.sunset             |

    And Response matches the schema json response

	@Scenario_PutAPI
	Scenario: Send API requests of  type Put to server
#		Given user hit the uri apiEndpoint
		When User provide header details and make Put call
#	|header|contentType|application/json|
		Then user will get status code 200 as respond code
#    	|Param1_toValidate       |results.sunrise      |
#    	|Param2_toValidate       |results.sunset             |

#		And Response matches the schema json response

	@Scenario_deleteAPI
	Scenario: Send API requests of  type delete to server
#		Given user hit the uri apiEndpoint
		When User provide header details and make delete call
#	|header|contentType|application/json|
#		Then user will get status code 200 as respond code
#    	|Param1_toValidate       |results.sunrise      |
#    	|Param2_toValidate       |results.sunset             |

#		And Response matches the schema json response

	@Scenario_Outline_getAPI
Scenario Outline: Send API requests of type GET to server
		Given user hit the "<uri>" apiEndpoint with header details and make "get" call
#	|header|contentType|application/json|
		Then user will get status code <expectedStatusCode> as respond code
#    	|Param1_toValidate       |results.sunrise      |
#    	|Param2_toValidate       |results.sunset             |
		And Response has the json "<expectedKey>" in response

		And Response matches the schema json "<expectedField>"  with "<expectedValue>" in response
		Examples:
			| uri |expectedStatusCode |expectedKey |expectedField |expectedValue |
		    | https://pokeapi.co/api/v2/pokemon/pikachu |200 |name |forms.name|[pikachu]   |

	@Scenario_Outline_PostAPI
	Scenario Outline: Send API requests of type Post to server
		Given user hit the "<uri>" apiEndpoint with header details and make Post call
#	|header|contentType|application/json|
		Then user will get status code <expectedStatusCode> as respond code
#    	|Param1_toValidate       |results.sunrise      |
#    	|Param2_toValidate       |results.sunset             |
		And Response has the json "<expectedKey>" in response

		And Response matches the schema json "<expectedField1>"  with "<expectedValue1>" and "<expectedField2>"  with "<expectedValue2>" in response
		Examples:
			| uri |expectedStatusCode |expectedKey |expectedField1 |expectedValue1 |expectedField2 |expectedValue2 |
			| https://restful-booker.herokuapp.com/booking |200 |bookingid |booking.lastname |Brown  |booking.firstname |Jim  |

	@@Scenario_Outline_PutAPI
	Scenario Outline: Send API requests of type Post to server
		Given user hit the "<uri>" apiEndpoint with header details and make Put call
#	|header|contentType|application/json|
		Then user will get status code <expectedStatusCode> as respond code
#    	|Param1_toValidate       |results.sunrise      |
#    	|Param2_toValidate       |results.sunset             |
		And Response has the json "<expectedKey>" in response

		And Response matches the schema json "<expectedField1>"  with "<expectedValue1>" and "<expectedField2>"  with "<expectedValue2>" in response
		Examples:
			| uri |expectedStatusCode |expectedKey |expectedField1 |expectedValue1 |expectedField2 |expectedValue2 |
			| https://jsonplaceholder.typicode.com/posts/1 |200 |id |id |1  |userId |101    |

	@Scenario_Outline_deleteAPI
	Scenario Outline: Send API requests of type Post to server
		Given user hit the "<uri>" apiEndpoint with header details and make delete call
#	|header|contentType|application/json|
		Then user will get status code <expectedStatusCode> as respond code
#    	|Param1_toValidate       |results.sunrise      |
#    	|Param2_toValidate       |results.sunset             |
		And Response has the json "<expectedKey>" in response

		And Response matches the schema json "<expectedField1>"  with "<expectedValue1>" and "<expectedField2>"  with "<expectedValue2>" in response
		Examples:
			| uri |expectedStatusCode |expectedKey |expectedField1 |expectedValue1 |expectedField2 |expectedValue2 |
			| https://api.stripe.com/v1/customers |200 |object |object |customer  |deleted |true  			|