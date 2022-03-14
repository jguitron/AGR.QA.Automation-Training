
    Feature: Etsy search
      User should be able o use Search bar to look for items needed

    @smoke
    Scenario: User heads to etsy,con and searches for an item and sees expected item in search result
      Given User is on Etsy home page
      When User clicks on main search bar
      And User types "decor" in search bar
      And User clicks on search icon
      Then User should be able to see "decor" in results page