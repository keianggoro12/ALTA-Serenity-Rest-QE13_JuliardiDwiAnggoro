Feature: Serenity Rest QE 13
    @Latihanget
    Scenario Outline: Get list user with valid param page
        Given Get list users with page <page>
        When Send request get list users
        Then Status code should be 200
        And Response body page should be <page>
        And Validate get list users json schema "ListUsersSchema.json"
        Examples:
        |page|
        |1   |
        |2   |
    
    @Latihanpost
    Scenario: Post create user with valid json
        Given Post create user with valid json "CreateUser.json"
        When Post request post create user
        Then Status code should be 201
        And Response body name was "pria misterius" and job was "QE dadakan"
        And Validate create user json schema "CreateUserSchema.json"

    @Latihanupdate
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

#    @Latihan
#    Scenario Outline: Update user with valid id and json
#        Given Update user with valid id <id> and json "<json>"
#        When Send request update user
#        Then Status code should be 200
#        And Response body name was "<name>" and job was "<job>"
#        And Validate update user json schema "UpdateUserSchema.json"
#        Examples:
#            | id | json             | name           | job                |
#            | 1  | UpdateUser.json  | Juli An Edit   | QA Engineer Edit   |
#            | 2  | UpdateUser2.json | Juli An Edit 2 | QA Engineer Edit 2 |

    @Latihandelete
    Scenario Outline: Delete user with valid id
        Given Delete user with valid id <id>
        When Send request delete user
        Then Status code should be 204
        Examples:
            | id |  |
            | 1  |  |
            | 2  |  |


