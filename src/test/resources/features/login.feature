
Feature: Login verification

  Scenario Outline: Login functionality verification
    Given user is on landing page
      | https://www.ashleyfurniture.com |
    And user clicks on login link on "<value>" page
    When user enters username and password as below
      | username  | maxjon.kayumov@gmail.com  |
      | password  | TestingPassword123$       |
    Then user should see user dashboard

    @desktop
    Examples:
      | value   |
      | desktop |

    @mobile @tablet
    Examples:
      | value  |
      | mobile |