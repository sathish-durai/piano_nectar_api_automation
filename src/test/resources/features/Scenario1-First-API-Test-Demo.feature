Feature: This is the feature to test the Shared Offers API

  @TC_1
  Scenario: Validate to get the response status for the shared Offers
    Given the api sends the request
    When the api get the response status
    Then the api status to be verified
      | statusCode |
      | 200        |

  @TC_2
  Scenario: Validate to get the response message for the shared Offers
    Given the api sends the request
    When the api get the response status
    Then the api status to be verified
      | statusCode |
      | 200        |