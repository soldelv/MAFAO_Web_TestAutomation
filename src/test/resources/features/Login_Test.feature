Feature: Login flows in MAFAO
  It also contains login features with Keyloack

  Background:
    Given The user access to MAFAO homepage
    When The user clicks on User icon
    Then The user is on Login Page

  @user-type:admin
  Scenario Outline: Login as an admin in MAFAO website
    Given The user enters email <email> and password <password>
    When The user is on the Seller Dashboard page
    Then The user logs out
    Examples:
      |            email         |     password     |
      | sebastien.michea@manaty.net | +h6SpQpuGcUq3@gC |


  Scenario Outline: Fail login as an admin in MAFAO website, invalid password
    And The user enters email <email> and password <password>
    Then An error message is displayed
    Examples:
      |      email         |     password     |
      | invalid@manaty.net | +h6xXxXxXxXx3@gC |


  Scenario Outline: Login with Keyloack in MAFAO website
    Given The user clicks on Login with Keycloak button
    When The user enters user <username> and password <password>
    And The user is on the Seller Dashboard page
    Then The user logs out
    Examples:
      |   username    | password |
      | +351913812319 |  290521  |

  Scenario Outline: Fail login with Keyloack in MAFAO website, invalid secret code
    Given The user clicks on Login with Keycloak button
    When The user enters user <username> and password <password>
    Then Invalid secret code error message is displayed
    Examples:
      |   username    | password |
      | +351913812319 |  111111  |