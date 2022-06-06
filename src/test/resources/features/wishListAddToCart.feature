Feature: Verification of WishList Add to Cart from cart page
@wip5
  Scenario: User adds item to cart from wish list
  Given User navigates to "url"
  And   User clicks on login link on different viewports
  When  User logs in with "username" and "password"
  And   User clicks on "Wish List" in account tab
  Then  User clicks add to cart from Wish List
  Then  User clicks on cart
  Then  User asserts "Honey-Can-Do 4 Piece Jar Storage Set" saved items in cart


