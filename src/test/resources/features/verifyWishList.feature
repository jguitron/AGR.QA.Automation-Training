Feature: Verification of WishList Add to Cart from cart page
  @smoke @wip
  Scenario: User adds item to cart from wish list
    Given User navigates to "url"
    And   User search's "Darcy Sofa" in search bar
    And   User chooses "Darcy Sofa, Cobblestone, large" in plp
    And   User clicks on Heart Icon in pdp
    When  User logs in with "username" and "password"
    Then  User verifies that "Darcy Sofa, Cobblestone, large" in Wish List is clickable with url text "darcy"
    And   User clicks on "wishlist" in account tab
    And   User verify view details button for "Darcy Sofa" in Wish list
    And   User clicks on "wishlist" in account tab
    Then  User clicks on remove button in Wish List for "Darcy Sofa"
    Then  User Asserts "Darcy Sofa, Cobblestone, large" is not in wishlist

