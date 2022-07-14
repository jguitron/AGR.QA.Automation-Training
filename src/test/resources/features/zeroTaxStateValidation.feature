@smoke  @regression
Feature: Zero tax state validation
  As a customer in no sales tax state (Oregon), my order should not have any taxes.

  Scenario: User sets store as Florida store, search for an item, add item to cart and navigate to Cart Page
    Given User navigates to "url"
    Then User finds closest store by "33606"
    Then User searches for SKU "9510438" and clicks on it
    Then User clicks on Add Item to Cart
    Then User navigate to cart page
    Then User validates the tax amount on CartPage
    Then User changes the delivery "97304" by clicking on zipcode link from Cart Page
    Then User validates the tax amount on CartPage
    Then User clicks on Secure Check out button
    Then User validates the tax amount on SecureCheckout CustomerInfo Page
    Then User enters customer info on Secure Checkout Delivery Page
      | FName         |
      | LName         |
      | 100 Main St   |
      | Apt 12        |
      | Salem         |
      | Oregon        |
      | 97304         |
      | 6126543265    |
      | qa@test.com   |
    Then User clicks on Continue as Guest button
    Then User validates the tax amount on SecureCheckout Shipping Page
    Then User clicks on Use Original button on PopUp window
    Then User clicks on continue to billing and payment button
    Then User validates the tax amount on SecureCheckout Billing Page
