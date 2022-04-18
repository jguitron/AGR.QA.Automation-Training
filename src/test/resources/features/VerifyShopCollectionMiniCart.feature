Feature: Verification of Mini Cart Changes Qty After Adding From Shop The Collection
  Scenario: User Adds Items To Cart From Shop The Collection
    Given User is on AshleyFurniture's main home page
    When  User clicks on X-close button to close iframe popup
    And   User clicks on the search bar
    And   User search's sofa in search bar
    Then  User clicks on Darcy Sofa
    And   User asserts zero items in mini cart
    Then  User clicks on Add to Cart for "Darcy Loveseat" to Cart from Shop the Collection
    Then  User Clicks Add Item to Cart
    Then  User Asserts Mini Cart 2 items in cart
