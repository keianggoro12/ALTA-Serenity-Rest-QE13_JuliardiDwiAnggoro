Feature: Delete User

  #Scenario 17
@Latihan
  Scenario Outline: Delete user with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Status code should be 204
    Examples:
      | id |
      | 1  |
      | 2  |

  #Scenario 18
  @Latihan
  Scenario Outline: Delete user with id more than data have
    Given Delete user with valid id <id>
    When Send request delete user
    Then Status code should be 404
    Examples:
      | id |
      | 15 |
      | 16 |

  #Scenario 19
  @Latihan
  Scenario Outline: Delete user with id using alphabet
    Given Delete user with id "<id>" using alphabet
    When Send request delete user
    Then Status code should be 400
    Examples:
      | id       |
      | sdnali   |
      | dasdqawa |
