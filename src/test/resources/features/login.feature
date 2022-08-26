@smoke
Feature: Login verification with an existing user credentials

  Scenario: Login functionality verification
    Given User navigates to 'url'
    And User clicks on login link on different viewports
    When User logs in with 'username' and 'password'
    Then User should see user dashboard
    Then Assert user is logged in via name displays in header