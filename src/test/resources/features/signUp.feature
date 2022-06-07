@smoke
Feature: New user signup/create new account

  Scenario: User creates new user account and verifies if new account created.
    Given User navigates to "url"
    When  User clicks on login button
    Then  User then clicks on Login link
    And   User clicks Create account link
    Then  User enters personal information
    Then User confirms age
#    And  User clicks on Submit button
