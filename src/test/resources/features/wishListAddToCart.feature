@smoke

Feature: Verification of WishList Add to Cart from cart page

  Scenario: User adds item to cart from wish list
    Given User navigates to 'url'
    And   User clicks on login link on different viewports
    When  User logs in with 'username' and 'password'
    And   User clicks on 'wishlist' in account tab
    Then  User clicks 'Honey-Can-Do 4-Piece Glass Jar Storage Set with Bamboo Lids' add to cart from Wish List
    Then  User clicks on cart icon
    Then  User clicks on Confirm button to confirm the zip code
    Then  User asserts 'Honey-Can-Do 4 Piece Jar Storage Set' saved items in cart