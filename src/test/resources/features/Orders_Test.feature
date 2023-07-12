@test-set:regression
Feature: Mobile App: Orders
  Test coverage:
  - Add product to cart
  - Remove product from cart
  - Purchase successfully

  Background:
    Given the user accesses to MAFAO application
    When the user enters valid credentials
    Then the user is logged in on MAFAO mobile application

  Scenario Outline: Add and remove a product from cart
    Given the user is on marketplace screen
    When taps on <product_1> from marketplace
    And taps on plus icon twice
    And taps on minus icon once
    And taps to add to cart icon
    And goes to orders screen
    Then <product_1> is displayed on Orders list
    And taps on trash icon to remove product from the list
    Then <product_1> is not longer displayed on the list
    Examples:
      | product_1    |
      | Baby clothes |


  Scenario Outline: Purchase successfully by Paypal
    Given the user is on marketplace screen
    When taps on <product_1> from marketplace
    And taps to add to cart icon
    And goes to orders screen
    And taps pay your order
    And the user logs into Paypal and confirm the payment
    Then your order has been registered screen should be displayed
    Examples:
      |  product_1     |
      | Football Ball  |

