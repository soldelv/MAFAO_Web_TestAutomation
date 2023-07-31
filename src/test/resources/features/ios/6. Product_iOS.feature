Feature: Product features on Mobile Application | iOS Environment

  Background:
    Given the user accesses to MAFAO iOS application
    When checks if user is already logged in
    And enters a valid secret code and taps on confirm
    Then the user is logged in on MAFAO mobile application

  Scenario Outline: PRODUCT PAGE | Product detailed page viewing
    Given the user is on marketplace screen
    When taps on <product_name> from marketplace
    Then <product_name> information are displayed correctly
    Examples:
      |  product_name  |
      |  Baby clothes  |

  Scenario Outline: PRODUCT PAGE | Seller icon screen (Auchan logo)
      Given the user is on marketplace screen
      When taps on <product_name> from marketplace
      And taps on Auchan logo to see seller info
      Then seller info is displayed correctly
      Examples:
        |  product_name  |
        |  Baby clothes  |

  Scenario Outline: PRODUCT PAGE | Report this product
    Given the user is on marketplace screen
    When taps on <product_name> from marketplace
    And taps on Report this product
    And fills the report the product form
    And report to validate message are displayed
    Then taps on Ok to send the report
    Examples:
      |  product_name  |
      |  Baby clothes  |

  Scenario Outline: PRODUCT PAGE | Similar Products list
    Given the user is on marketplace screen
    When taps on <product_name> from marketplace
    And goes to similar products section
    Then similar products for <product_name> are displayed
    Examples:
      |  product_name  |
      |  Baby clothes  |