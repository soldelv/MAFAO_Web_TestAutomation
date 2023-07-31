Feature: Product features on Mobile Application | iOS Environment

  Background:
    Given the user accesses to MAFAO iOS application
    When checks if user is already logged in
    And enters a valid secret code and taps on confirm
    Then the user is logged in on MAFAO mobile application

    Scenario: PRODUCT PAGE | Product detailed page viewing
      Given the user accesses to MAFAO iOS application
      When checks if user is already logged in
      Then the user is logged in on MAFAO mobile application

    Scenario: PRODUCT PAGE | Similar Products list

      # PRODUCT PAGE | Similar Products list --> API
      # PRODUCT PAGE | Seller icon screen (Auchan logo)
  # PRODUCT PAGE | Report this product