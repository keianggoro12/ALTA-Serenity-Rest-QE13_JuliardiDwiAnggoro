Feature: Registration

  #Scenario 6
  @Latihan
  Scenario: Successful registration with valid data
    Given Post register with valid data on json "RegisterUserValid.json"
    When Send request post register
    Then Status code should be 200

  #Scenario 7
  @Latihan
  Scenario: Register user with invalid email
    Given Post register with invalid data on json "RegisterUserInvalid4.json"
    When Send request post register
    Then Status code should be 400

  #Scenario 8
  @Latihan
  Scenario: Register user with blank email
    Given Post register with invalid data on json "RegisterUserInvalid2.json"
    When Send request post register
    Then Status code should be 400

  #Scenario 9
  @Latihan
  Scenario: Register user with blank password
    Given Post register with invalid data on json "RegisterUserInvalid1.json"
    When Send request post register
    Then Status code should be 400

  #Scenario 10
  @Latihan
  Scenario: Register user with email has been registered before
    Given Post register with valid data on json "RegisterUserValid.json"
    When Send request post register
    Then Status code should be 200


  @InvalidRegistration
  Scenario Outline: Unsuccessful registration with invalid data
    Given Post register with invalid data on json "<json>"
    When Send request post register
    Then Status code should be 400
    Examples:
      |                  | json                      |
      | missing passowrd | RegisterUserInvalid1.json |
      | missing email    | RegisterUserInvalid2.json |
      | missing both     | RegisterUserInvalid3.json |