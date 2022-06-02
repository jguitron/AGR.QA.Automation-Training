@smoke
Feature: Verification of Save for Later button in mini cart

  Scenario: User saves for later in Mini Cart
    Given User navigates to "url"
    And   User search's "Honey-Can-Do 4 Piece Jar Storage Set" in search bar
    Then  User chooses "Honey-Can-Do 4-Piece Glass Jar Storage Set with Bamboo Lids, , large" in plp
    And   User clicks on Add Item to Cart
    And   User clicks on save for later mini cart
    And   User logs in with "username" and "password" mobile skip
    Then  User clicks on cart icon
    Then  User asserts "Honey-Can-Do 4 Piece Jar Storage Set" saved items in cart mobile skip
