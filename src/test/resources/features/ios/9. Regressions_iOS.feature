Feature: Priority features on Mobile Application | iOS Environment

  Background:
    Given the user accesses to MAFAO iOS application
    When checks if user is already logged in
    And enters a valid secret code and taps on confirm
    Then the user is logged in on MAFAO mobile application

  Scenario: LOGIN | Successful login via pincode
    Then the user should be logged in successfully

  Scenario: HOME | Display/Scroll products in Marketplace
    Given the user is on marketplace screen
    When scrolls down on the home
    Then the user can see the products listed

  Scenario Outline: HOME | Search Products by keyword
    Given the user is on marketplace screen
    When the user searches for <keyword> on the searchbar
    Then products related to product <keyword> are displayed
    Examples:
      |   keyword   |
      |   Football  |

  Scenario: HOME | Filter products by category
    Given the user is on marketplace screen
    When taps on Informatique from Home
    Then products related to the category are displayed
    And taps on Hardware from Home
    Then products related to the category are displayed
    And taps on Sport from Home
    Then products related to the category are displayed
    And taps on Toys and Accessories from Home
    Then products related to the category are displayed
    And taps on Home, Kitchen and Office from Home
    Then products related to the category are displayed
    And taps on Hypermarket from Home
    Then products related to the category are displayed
    And taps on Equipement from Home
    Then products related to the category are displayed
    And taps on Fêtes from Home
    Then products related to the category are displayed

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

  Scenario Outline: ORDERS | Add and remove a product from cart
    Given the user is on marketplace screen
    When taps on <product_name> from marketplace
    And taps on plus icon
    And taps on minus icon
    And add <product_name> to cart
    And goes to orders screen
    Then <product_name> is displayed on Orders list
    And taps on trash icon to remove product from the list
    Then the product was removed successfully
    Examples:
      |  product_name   |
      | 3 in 1 Multipod |

  Scenario Outline: ORDERS | Check out successfully by Paypal
    Given the user is on marketplace screen
    When taps on <product_name> from marketplace
    And add <product_name> to cart
    And goes to orders screen
    And taps pay your order
    And the user logs into Paypal and confirm the payment
    Then your order has been registered screen should be displayed
    Examples:
      |  product_name  |
      | Football Ball  |

  Scenario Outline: ORDERS | Check out successfully by MAFAO wallet
    Given the user is on marketplace screen
    When scrolls down and taps on <product_name> from marketplace
    And add <product_name> to cart
    And goes to orders screen
    And taps on change payment method
    And selects MAFAO wallet as a payment method
    And taps pay your order to finish the purchase
    Then your order has been registered screen should be displayed
    Examples:
      | product_name |
      |   Postcards  |

  Scenario Outline: ORDERS | Paid Order tab display after checkout & Transaction Details
    Given the user is on marketplace screen
    And goes to orders screen
    And user goes to Pay Order tab
    Then the order with <product_name> is on the list
    And taps on the order with <product_name>
    Then paid order transaction details are displayed
    Examples:
      |  product_name |
      |   Postcards   |

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

  Scenario: PROFILE | Notifications
    Given user goes to profile screen
    When taps on notifications
    Then all the notifications received are displayed
    And goes to home section
    And taps on notification icon
    Then all the notifications received are displayed

  Scenario: PROFILE | My Shop (Seller’s Dashboard, Odoo view)
    Given user goes to profile screen
    When clicks on My Shop option
    Then seller dashboard from Odoo view is displayed successfully

  Scenario: PROFILE | Settings | Account Settings | Change Secret Code
    Given user goes to profile screen
    When taps on settings
    And taps on Secret code to change it
    And enters the current secret code
    And taps on Change my secret code
    And enters the current secret code
    And enters the new secret code twice
    And the pincode was successfully changed
    And logins again with the new secret code
    Then the user is logged in on MAFAO mobile application
    And user goes to profile screen
    Then reset pincode to default secret code
    Then the user is logged in on MAFAO mobile application

  Scenario: PROFILE | Settings | Account Settings | Edit Profile
    Given user goes to profile screen
    When taps on settings
    And taps on profile option
    And changes the display name
    Then the display name was successfully changed

  Scenario: PROFILE | Settings | Support | Backup Account
    Given user goes to profile screen
    When taps on settings
    And taps on backup account option
    And taps backup button to confirm the backup
    Then backup success message is displayed

  Scenario: PROFILE | Log out from iOS
    Given the user is on marketplace screen
    When user goes to profile screen
    And clicks on log out
    Then the user is logged out successfully