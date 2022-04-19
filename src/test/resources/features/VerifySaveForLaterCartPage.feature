Feature: Verification of Save for Later button in cart page

  Scenario: User adds Honey-Can-Do 4 Piece Jar Storage Set to cart and clicks save for later
    Given User navigates to "url"
    And   User clicks on the search bar
    Then  User search's Honey-Can-Do 4 Piece Jar Storage Set in search bar
    And   User clicks search icon
    Then  User clicks on Honey-Can-Do 4 Piece Jar Storage Set
    And   User clicks on Add Item to Cart
    And   User is in cart page
    Then  User clicks save for later button
    And   User Logs in
    Then  User asserts total items in cart after save for later
