@smoke @maxk
Feature: Verification of 3 Items added to cart is reflected in "mini cart logo" as 3 total items

  Scenario: User adds items to cart
    Given User navigates to "url"
    And   User Hovers over header and clicks on "furniture/living-room/sofas/" category
    And   User clicks on PLP Show "80" per page button
    And   User chooses "Darcy Sofa, Cobblestone, large" in plp
    Then  User clicks on Add Item to Cart
    And   User Hovers over header and clicks on "furniture/living-room/sofas/" category
    And   User clicks on PLP Show "80" per page button
    And   User chooses "Soletren Sofa, Stone, large" in plp
    Then  User clicks on Add Item to Cart
    Then  Assert total number of items in mini cart is "2"




