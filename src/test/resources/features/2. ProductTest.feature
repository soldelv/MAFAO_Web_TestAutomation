@regressions
Feature: Product features | MAFAO Odoo Environment

  Background:
    Given The user access to MAFAO homepage

  Scenario: Add Pickup Location
    When the user clicks on Login with Keycloak button
    And the user logs in as a seller with valid credentials
    And seller dashboard page displays correctly
    And the seller goes to Seller Pickup Location screen
    When clicks on create
    And fills Merchants Pick up Location form and clicks on save
    Then the new location is on pick up list

  Scenario: Add products
    When the user clicks on Login with Keycloak button
    And the user logs in as a seller with valid credentials
    And seller dashboard page displays correctly
    And the seller goes to New Product screen
    And fills information of new product form
    And fills variants details of new product form
    And uploads images for the new product
    And fills inventory of new product form
    And selects pick up location
    And creates a group of discounts
    And clicks on Request To Approve button
    Then the new product is on Pending list

  Scenario: Approve Product as an Admin
    Given The user clicks on User icon
    When the user logs in as an admin
    And admin dashboard page displays correctly
    And admin clicks on Pending button from Marketplace Products section
    And chooses the first product from the list
    And clicks on approve button
    And clicks on Approve and Publish
    Then the product recently approved is no longer displayed in the list