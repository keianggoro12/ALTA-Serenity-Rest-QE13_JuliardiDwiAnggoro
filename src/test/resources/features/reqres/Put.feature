Feature: Update User

  #Scenario 11
  @Latihan
  Scenario Outline: Update user with valid id and json
    Given Update user with valid id <id> and json "<json>"
    When Send request update user
    Then Status code should be 200
    And Response body name was "<name>" and job was "<job>"
    And Validate update user json schema "UpdateUserSchema.json"
    Examples:
      | id | json             | name               | job               |
      | 1  | UpdateUser.json  | Pria Mister Edit   | QE Dadakan Edit   |
      | 2  | UpdateUser2.json | Pria Mister Edit 2 | QE Dadakan Edit 2 |

    #Scenario 12
  @Latihan
  Scenario Outline: Update user with id using alphabet and json
    Given Update user with id "<id>" using alphabet and json "<json>"
    When Send request update user
    Then Status code should be 400

    Examples:
      | id      | json             | name               | job               |
      | jdskal  | UpdateUser.json  | Pria Mister Edit   | QE Dadakan Edit   |
      | tetewww | UpdateUser2.json | Pria Mister Edit 2 | QE Dadakan Edit 2 |

    #Scenario 13
  @Latihan
  Scenario Outline: Update user with id using special character and json
    Given Update user with id "<id>" using special character and json "<json>"
    When Send request update user
    Then Status code should be 400

    Examples:
      | id     | json             | name               | job               |
      | !@#!@# | UpdateUser.json  | Pria Mister Edit   | QE Dadakan Edit   |
      | &^%&^& | UpdateUser2.json | Pria Mister Edit 2 | QE Dadakan Edit 2 |

    #Scenario 14
  @latihan
  Scenario: Update user with valid id without name on json
    Given Update user with id 2 without name on json "UpdateUser3.json"
    When Send request update user
    Then Status code should be 400

    #Scenario 15
  @latihan
  Scenario: Update user with valid id without job on json
    Given Update user with id 2 without job on json "UpdateUser4.json"
    When Send request update user
    Then Status code should be 400

  #Scenario 16
  @latihan
  Scenario: Update user with valid id and empty json
    Given Update user with id 2 and empty json "UpdateUser5.json"
    When Send request update user
    Then Status code should be 400
