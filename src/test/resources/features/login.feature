
@smoke
Feature: Login verification

  @login
  Scenario: Login functionality verification
    Given User navigates to "url"
    And user clicks on login link on expected platform
    When user enters username and password as below
      | username | maxjon.kayumov@gmail.com |
      | password | TestingPassword123$      |
    Then user should see user dashboard







