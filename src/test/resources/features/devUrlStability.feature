
  Feature: Stages stability verification

    @wip
    Scenario Outline: verify all stages up and running
      Given user goes to "<URL>"
      When user scrolls down the page to footer
      Then user scrolls up the page back to header

      @desctop
      Examples: Expected URLs to be checked is as below
        | URL                                          |
        | https://ecomm-mozart.dev.ashleyretail.com/   |
        | https://ecomm-mozart.stage.ashleyretail.com/ |
        | https://mfe-content.dev.ashleyretail.com/    |


