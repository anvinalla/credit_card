Feature: Add Account details endpoint happy path

  Scenario: Testing a POST endpoint with request body with status true
    Given url 'http://localhost:8080/api/v1/addAccount'
    And request { name: 'TestUser' , accNo: '12345678' , srcCode: '121212' , PAN: '1234123412340980'}
    When method POST
    Then status 200
    And match response == { name: 'TestUser' , status: true ,  PAN: '1234xxxxxxxx0980'}

  Scenario: Testing a POST endpoint with response status false when accNo is less than 8
    Given url 'http://localhost:8080/api/v1/addAccount'
    And request { name: 'TestUser' , accNo: '1234567' , srcCode: '121212' , PAN: '1234123412340980'}
    When method POST
    Then status 200
    And match response == { name: 'TestUser' , status: false ,  PAN: '1234xxxxxxxx0980'}


  Scenario: Testing a POST endpoint with response status false when accNo starts with 8
    Given url 'http://localhost:8080/api/v1/addAccount'
    And request { name: 'TestUser' , accNo: '81234567' , srcCode: '121212' , PAN: '1234123412340980'}
    When method POST
    Then status 200
    And match response == { name: 'TestUser' , status: false ,  PAN: '1234xxxxxxxx0980'}


  Scenario: Testing a POST endpoint with response status false when srcCode is less than 6
    Given url 'http://localhost:8080/api/v1/addAccount'
    And request { name: 'TestUser' , accNo: '81234567' , srcCode: '1212' , PAN: '1234123412340980'}
    When method POST
    Then status 200
    And match response == { name: 'TestUser' , status: false ,  PAN: '1234xxxxxxxx0980'}