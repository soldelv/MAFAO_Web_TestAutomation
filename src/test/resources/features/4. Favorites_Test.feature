@test-set:regression
Feature: Favorites features in MAFAO APP Mobile for Android
  Test coverage: Add and remove products from favorites list

  Background:
    Given the user accesses to MAFAO application
    When the user enters valid credentials
    Then the user is logged in on MAFAO mobile application

  Scenario Outline: Add products as Favorite from marketplace list
    Given the user is on marketplace screen
    When chooses <product_1>, <product_2>, <product_3> from marketplace and taps as favorite
    And goes to favorite section
    Then <product_1>, <product_2>, <product_3> are displayed on Favorites list
    Examples:
      |   product_1   |   product_2  |     product_3    |
      | Football Ball | Baby clothes | Moto club tshirt |

  Scenario Outline: Add products as Favorite from product screen
    Given the user is on marketplace screen
    When scrolls down searching for <product_1>
    And taps on <product_1> from marketplace
    And taps on the heart icon to add the product as a favorite
    And goes to favorite section
    Then <product_1> is displayed on Favorites list
    Examples:
      | product_1     |
      | Inflatables for swimming pool |

  Scenario: Remove products from Favorite list
    Given the user is on favorite screen
    When the user has products on favorites list
    And taps on the heart icon to remove the product as a favorite
    Then the products are not longer displayed on favorites list
