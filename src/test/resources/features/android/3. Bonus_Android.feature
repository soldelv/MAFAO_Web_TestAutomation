@test-set:regression
Feature: Bonus features on Mobile Application | Android Environment

  Background:
    Given the user accesses to MAFAO Android application
    When the user enters valid credentials - Android
    Then the user is logged in on MAFAO mobile application - Android

  Scenario Outline: Top-up money by paypal
    Given the user is on bonus section - Android
    When taps on refill button - Android
    And taps on Top up my account - Android
    And selects paypal as a top up method - Android
    And enters <amount_to_top_up> and confirms - Android
    And the user logs into Paypal and confirm the payment - Android
    Then top-up completed screen should be displayed - Android
    Examples:
      | amount_to_top_up |
      |       150        |