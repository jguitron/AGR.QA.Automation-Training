Feature: Verification of Mini Cart after adding 1 item and items from "shop the collection" to cart

  @glitterglamgarrett
  Scenario: User Adds item to cart and adds items from shop the collection to cart

    Given User navigates to "url"
    When  User clicks on search bar
    And   User search's "Macleary Sofa" in search bar
    And   User clicks search icon
    Then  User chooses "Macleary Sofa, Moss, large" in plp
    And   User Clicks plus button for "8900620" in shop the collection
    And   User Clicks Add to Cart in Shop the Collection for "8900620"
    Then  User clicks on Add Item to Cart PDP scroll
    Then  User asserts qty in mini cart is "3"





