@regression
Feature: Login verification

  @smoke
  Scenario: Login functionality verification
    Given user navigates to "url"
    And user clicks on login link on platform
    When user enters username and password as below
      | username | maxjon.kayumov@gmail.com |
      | password | TestingPassword123$      |
    Then user should see user dashboard







