Feature: Bonus features on Mobile Application | iOS Environment

    # USER ALREADY LOGGED IN
  Background:
    Given the user accesses to MAFAO iOS application
    When the user enters just pincode
    Then the user is logged in on MAFAO mobile application

  @Ignore @deprecated-soon
  Scenario: Bonus - Pending and Completed Transaction History
    Given the user is on bonus screen
    When the user taps on Upcoming transactions
    Then upcoming transactions are displayed
    And the user taps on Completed transactions
    Then completed transactions are displayed

  @Ignore @deprecated-soon
  Scenario Outline: Top-up money by paypal
    Given the user is on bonus screen
    When the user taps on refill button
    And taps on Top up my account
    And selects paypal as a top up method
    And enters <amount_to_top_up> and confirms
    And the user logs into Paypal and confirm the payment
    Then top-up completed screen should be displayed
    Examples:
      | amount_to_top_up |
      |       150        |