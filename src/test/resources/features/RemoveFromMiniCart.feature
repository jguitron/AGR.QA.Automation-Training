@smoke
Feature: Verification of Item removed from cart
  Scenario: User Adds item to cart and removes from mini cart
    Given User navigates to "url"
    And   User clicks on the search bar
    Then  User search's Boise 24" Single Bathroom Vanity Set in search bar
    Then  user clicks on search icon
    Then  User clicks on Boise 24" Single Bathroom Vanity Set
    Then  User clicks Add Item to Cart DeskTop
    Then  User Removes item from mini cart
    Then  User asserts items removed from mini cart and is 0 qty
