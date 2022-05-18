
@regression
Feature: Stages stability verification
  Verify if apollo URLS are up and running

  Scenario Outline: verify all apollo stages up and running
    When User navigates to "<url>"
    When User scrolls down to footer
    Then User scrolls to header
    Examples:
      | url                                          |
      | https://ecomm-mozart.dev.ashleyretail.com/   |
      | https://ecomm-mozart.stage.ashleyretail.com/ |
      | https://mfe-content.dev.ashleyretail.com/    |
      | https://www.ashleyfurniture.com/             |
