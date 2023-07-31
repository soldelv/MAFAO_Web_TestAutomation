Feature: Favorites features on Mobile Application | iOS Environment

  Background:
    Given the user accesses to MAFAO iOS application
    When checks if user is already logged in
    And enters a valid secret code and taps on confirm
    Then the user is logged in on MAFAO mobile application

  Scenario Outline: FAVORITES | Add product to Favorites
    Given the user is on marketplace screen
    When taps on <product_name> from marketplace
    And taps on the heart icon to add the product as a favorite
    And goes to favorite section
    Then <product_name> is displayed on Favorites list
    Examples:
      |  product_name  |
      |  Baby clothes  |

    Scenario Outline: FAVORITES | Create and remove an Alert
    Given the user is on marketplace screen
    When the user searches for <keyword> on the searchbar
    And products related to product <keyword> are displayed
    And taps on create an alert
    And goes to favorite section
    And taps on Alerts
    Then <keyword> alert is displayed
    And tap on delete alert
    Then alert was successfully deleted
    Examples:
      |  keyword   |
      |  Football  |
