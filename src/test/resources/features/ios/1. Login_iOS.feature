@test-set-regression
Feature: Login features on Mobile Application | iOS Environment

  Background:
    Given the user accesses to MAFAO iOS application

  Scenario: LOGIN | Successful login via pincode
    When the user taps on Log in button
    Then the user is on the login screen
    And selects a country - iOS
    And enters a registered mobile number and taps on send code
    And enters the verification code and taps on send
    And enters a valid secret code and taps on confirm
    Then the user should be logged in successfully

  Scenario Outline: Invalid login with incorrect secret code
    When the user taps on Log in button
    Then the user is on the login screen
    And selects a country - iOS
    And enters a registered mobile number and taps on send code
    And enters the verification code and taps on send
    And enters incorrect <secret_code> and taps on confirm
    Then the user should see an error message
    Examples:
      | secret_code |
      |    111111   |

  Scenario Outline: Invalid login with incorrect secret code
    When the user taps on Log in button
    Then the user is on the login screen
    And selects a country - iOS
    And enters a registered mobile number and taps on send code
    And enters the verification code and taps on send
    And enters incorrect <secret_code> and taps on confirm
    Then the user should see an error message
    Examples:
      | secret_code |
      |    111111   |

  Scenario: LOGIN | Reset pincode after a fail login
    Given taps on forgot pincode
    When selects a country - iOS
    And enters a registered mobile number and taps on send code
    And enters the verification code and taps on send
    And enters the new secret code twice
    And the pincode was successfully changed
    And logins again with the new secret code
    Then the user is logged in on MAFAO mobile application