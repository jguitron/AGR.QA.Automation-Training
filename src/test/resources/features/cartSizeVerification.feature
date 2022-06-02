@smoke
Feature: Verification of 3 Items added to cart is reflected in "mini cart logo" as 3 total items

  Scenario: User adds items to cart
    Given User navigates to "url"
    And   User search's "sofa" in search bar
    And   User chooses "Bladen Sofa, Coffee, large" in plp
    Then  User clicks on Add Item to Cart
    And   User search's "sofa" in search bar
    And   User chooses "Soletren Sofa, Stone, large" in plp
    Then  User clicks on Add Item to Cart
    Then  Assert total number of items in mini cart is "2"




