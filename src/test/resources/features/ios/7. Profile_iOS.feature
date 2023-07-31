@test-set:regression
Feature: Profile features on Mobile Application | iOS Environment

  Background:
    Given the user accesses to MAFAO iOS application
    When checks if user is already logged in
    And enters a valid secret code and taps on confirm
    Then the user is logged in on MAFAO mobile application

  @SmokeTest @RegressionTest
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

  @SmokeTest @RegressionTest
  Scenario: PROFILE | Settings | Account Settings | Edit Profile
    Given user goes to profile screen
    When taps on settings
    And taps on profile option
    And changes the display name
    Then the display name was successfully changed

  @SmokeTest @RegressionTest
  Scenario: PROFILE | Notifications
    Given user goes to profile screen
    When taps on notifications
    Then all the notifications received are displayed
    And goes to home section
    And taps on notification icon
    Then all the notifications received are displayed

  @SmokeTest @RegressionTest
  Scenario: PROFILE | Log out from iOS
    Given the user is on marketplace screen
    When user goes to profile screen
    And clicks on log out
    Then the user is logged out successfully

  #PROFILE | Display Profile Photo
  #PROFILE | Profile Page - View Display Name
  #PROFILE | My Shop (Seller’s Dashboard, Odoo view)
  #PROFILE | Seller Mobile Registration
  #PROFILE | Settings | Account Settings | Edit Profile
  #PROFILE | Settings | Account Settings | Change Secret Code
  #PROFILE | Settings | General Settings | Location
  #PROFILE | Settings | General Settings | Languages
  #PROFILE | Settings | Support | Backup Account
  #PROFILE | Settings | Support | Request Account Deletion
