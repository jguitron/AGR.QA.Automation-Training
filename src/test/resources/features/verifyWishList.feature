Feature: Verification of WishList Add to Cart from cart page
  @smoke
  Scenario: User adds item to cart from wish list
    Given User navigates to "url"
    And   User clicks on login link on different viewports
    When  User logs in with "username" and "password"
    And   User clicks on "Wish List" in account tab
    Then  User verifies that item in Wish List is clickable
    And   User clicks on "Wish List" in account tab
    And   User verify view details button in Wish list
    And   User clicks on "Wish List" in account tab
    Then  User verifies remove button in Wish List
    And   User clicks on "Wish List" in account tab
    Then  User asserts item removed from Wish List
