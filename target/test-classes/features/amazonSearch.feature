
Feature: Amazon search
   Search an item and verify search functionality behavior.

  @wip
  Scenario: User enters value in Amazon search bar and checks search bar works correctly
    Given User is on Amazon home page
    When User clicks on amazon search bar
    And User types "selenium" in search bar and clicks enter icon
    Then User should see "selenium" within results page
