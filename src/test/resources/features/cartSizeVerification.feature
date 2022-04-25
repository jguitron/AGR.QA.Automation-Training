@test
Feature: Verification of 3 Items added to cart is reflected in "mini cart logo" as 3 total items
  @glitterglamgarrett
  Scenario: User adds items to cart
    Given User navigates to "url"
    When  User clicks on search bar
    And   User search's "sofa" in search bar
    And   user clicks on search icon
    And   User chooses "Bladen Sofa, Coffee, large" in plp
    Then  User clicks on Add Item to Cart
    When  User clicks on search bar
    And   User search's "sofa" in search bar
    And   user clicks on search icon
    And   User chooses "Soletren Sofa, Stone, large" in plp
    Then  User clicks on Add Item to Cart
    Then  Assert total number of items in cart is 2



