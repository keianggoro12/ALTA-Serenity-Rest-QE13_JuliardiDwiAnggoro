Feature: Resources


#Scenario 1
  @Latihan
  Scenario: Successful get list resource
    Given Get list resources
    When Send request get list resources
    Then Status code should be 200
    And Validate get list resources json schema "ListResourcesSchema.json"



#Scenario 2
  @Latihan
  Scenario Outline: Get single resource with id
    Given Get single resource with id <id>
    When Send request get resource
    Then Status code should be 200
    And Response body id was <id>
    And Validate get list resources json schema "SingleResourceSchema.json"
    Examples:
      | id |
      | 2  |
      | 4  |
      | 6  |

#Scenario 3
  @Latihan
  Scenario Outline: Get single resource with id more than data have
    Given Get single resource with id <id>
    When Send request get resource
    Then Status code should be 404
    Examples:
      | id |
      | 20 |
      | 13 |

#Scenario 4
  @Latihan
  Scenario Outline: Get single resource with id using alphabet
    Given Get single resource with id "<id>" using alphabet
    When Send request get resource
    Then Status code should be 404
    Examples:
      | id   |
      | rere |
      | satu |

#Scenario 5
  @Latihan
  Scenario Outline: Get single resource with id using special character
    Given Get single resource with id "<id>" using special character
    When Send request get resource
    Then Status code should be 404
    Examples:
      | id           |
      | !@#!@#@!     |
      | $^$%^$&%#$%# |

