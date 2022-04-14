
@regression
Feature: Stages stability verification
  Verify if apollo URLS are up and running

  @smoke
  Scenario Outline: verify all apollo stages up and running
    When user navigates to "<URL>"
    When user scrolls down to footer
    Then user scrolls to header
    Examples:
      | URL       |
      | devURL    |
      | mfeURL    |
