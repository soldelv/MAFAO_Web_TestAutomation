@test-set:regression
Feature: Mobile App: Bonus
  Test coverage:
  - Top-up via Paypal
  - Send Money by mobile number
  - Pending Transaction History
  - Completed Transaction History
  - Send Money by QR Code
  - Send Payment Request
  - Pay via QR

  Background:
    Given the user accesses to MAFAO application
    When the user enters valid credentials
    Then the user is logged in on MAFAO mobile application

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


  # NEXT IMPLEMENTATIONS
  # Send Money by mobile number
  # Pending Transaction History
  # Completed Transaction History
  # Send Money by QR Code
  # Send Payment Request