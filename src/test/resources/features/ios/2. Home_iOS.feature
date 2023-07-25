@test-set:regression
Feature: Home features on Mobile Application | iOS Environment

  Background:
    Given the user accesses to MAFAO iOS application
    When checks if user is already logged in
    And enters a valid secret code and taps on confirm
    Then the user is logged in on MAFAO mobile application


  Scenario: Display/Scroll products in Marketplace
    Given the user is on marketplace screen
    When scrolls down on the home
    Then the user can see the products listed

  Scenario Outline: Search products by keyword
    Given the user is on marketplace screen
    When the user searches for <keyword> on the searchbar
    Then products related to <keyword> are displayed
    Examples:
      |   keyword   |
      |   Football  |

  @Ignore
  Scenario Outline: Filter products by category
    Given the user is on marketplace screen
    When taps on <category> from Home
    Then products related to <category> are displayed
    Examples:
      |   category   |
      |   Sport      |