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

  @exclude:test-need-fix
  Scenario Outline: LOGIN | Reset pincode after a fail login
    When the user taps on Log in button
    Then the user is on the login screen
    And selects <country> from the list
    And enters a valid mobile number and taps on send code
    And enters a valid verification code and taps on send
    And taps on forgot pincode
    And selects <country> from the list
    And enters a valid mobile number and taps on send code
    And enters a valid verification code and taps on send
    And enter the <new_pincode> twice
    Examples:
      |   country | new_pincode |
      |   france  |   140686    |