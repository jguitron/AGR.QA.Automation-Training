
@regression
Feature: Stages stability verification
  Verify if apollo URLS are up and running

  @smoke
  Scenario Outline: verify all apollo stages up and running
    When user navigates to "<url>"
    When user scrolls down to footer
    Then user scrolls to header
    Examples:
      | url                                          |
      | https://ecomm-mozart.dev.ashleyretail.com/   |
      | https://ecomm-mozart.stage.ashleyretail.com/ |
      | https://mfe-content.dev.ashleyretail.com/    |
      | https://www.ashleyfurniture.com/             |
