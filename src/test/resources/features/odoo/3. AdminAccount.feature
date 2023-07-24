@test-set:regression
Feature: Admin Account features | MAFAO Odoo Environment

  Background:
    Given The user access to MAFAO homepage
    When The user clicks on User icon
    Then the user logs in as an admin

  @user-type:admin
  Scenario: Approve Product as an Admin
    Given admin dashboard page displays correctly
    When admin clicks on Pending button from Marketplace Products section
    And chooses the first product from the list
    And clicks on approve button
    And clicks on Approve and Publish
    Then the product recently approved is no longer displayed in the list