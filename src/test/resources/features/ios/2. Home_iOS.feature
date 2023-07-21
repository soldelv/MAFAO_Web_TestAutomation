@test-set:regression
Feature: Home features on Mobile Application | iOS Environment

    # USER ALREADY LOGGED IN
  Background:
    Given the user accesses to MAFAO iOS application
    When the user enters just pincode
    Then the user is logged in on MAFAO mobile application


  Scenario: Display products in Marketplace
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