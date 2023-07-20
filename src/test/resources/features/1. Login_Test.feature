@test-set:regression
Feature: Login features in MAFAO APP Mobile for Android
  Test coverage: Successful login, invalid credentials, password recovery, and account lockout.

  Background:
    Given the user accesses to MAFAO application
    When the user taps on Log in button
    Then the user is on the login screen

  Scenario: Successful login with valid credentials
    When the user taps on flag icon and searches a country
    And taps on searched country flag
    And enters a registered mobile number and taps on send code
    And enters the verification code and taps on send
    And enters a valid secret code and taps on confirm
    Then the user should be logged in successfully

  Scenario Outline: Invalid login with incorrect secret code
    When the user taps on flag icon and searches a country
    And taps on searched country flag
    And enters a registered mobile number and taps on send code
    And enters the verification code and taps on send
    And enters incorrect <secret_code> and taps on confirm
    Then the user should see an error message
    Examples:
      | secret_code |
      |    111111   |

  Scenario Outline: Reset pincode after a fail login
    When the user taps on flag icon and searches for <country>
    And taps on searched country flag
    And enters a valid mobile number and taps on send code
    And enters a valid verification code and taps on send
    And taps on forgot pincode
    And the user taps on flag icon and searches for <country>
    And taps on searched country flag
    And enters a valid mobile number and taps on send code
    And enters a valid verification code and taps on send
    And enter the <new_pincode> twice
    Examples:
      |   country | new_pincode |
      |   france  |   140686    |