@smoke
Feature: Verify Pop up message is displayed if Progressive payment is selected with a Handy Item

  Scenario: User sets store as Florida store
    Given User navigates to "url"
    Then User finds closest store by "33606"
    Then  User searches for SKU "D631-01" and clicks on it
    Then User verifies that FPP available on PDP
    Then  User clicks on Add Item to Cart
    Then User navigate to cart page
    Then User uncheck Protection Plan check box
    Then User check Handy Item check box
    Then User clicks on Secure Check out button
    Then User enters customer info on Secure Checkout Delivery Page
      | FName       |
      | LName       |
      | 100 Main St |
      | Apt 12      |
      | Tampa       |
      | Florida     |
      | 33606       |
      | 6126543265  |
      | qa@test.com |
    Then User clicks on Continue as Guest button
    Then User clicks on Use Original button on PopUp window
    Then User clicks on continue to billing and payment button
    Then User clicks on Progressive leasing Payment option
    Then User verifies that Progressive Popup for Handy Item is displayed
    Then User click on Continue with Progressive Leasing button in Progressive popup msg
    Then User navigate back to cart page
    Then User Removes item from cart
