@smoke  @regression
Feature: Verification of available payment types in cart page
  As a user, I should be able to choose desired payment method; CC, AA, PL or PP

  Scenario: User sets store as Florida store, search for an item, add item to cart and navigate to Cart Page
    Given User navigates to "url"
    Then User finds closest store by "33544"
    Then User searches for SKU "K600002651" and clicks on it
    Then User clicks on Add Item to Cart
    Then User navigate to cart page
    Then User clicks on Secure Check out button
    Then User enters customer info on Secure Checkout Delivery Page
      | FName         |
      | LName         |
      | 100 Main St   |
      | Apt 12        |
      | Wesley Chapel |
      | Florida       |
      | 33544         |
      | 6126543265    |
      | qa@test.com   |

    Then User clicks on Continue as Guest button
    Then User clicks on Use Original button on PopUp window
    Then User clicks on continue to billing and payment button
    Given User is on Billing and Payment Page
    Then Credit card Payment option is available
    And Credit card Payment option fields are displayed
    Then Ashley Advantage Payment option is available
    Then User clicks on Ashley Advantage Payment option
    And Ashley Advantage Payment option logos and fields are displayed
    Then Progressive leasing Payment option is available
    Then User clicks on Progressive leasing Payment option
    And Progressive leasing Payment option logos and fields are displayed
    Then Paypal Payment option is available
    Then User clicks on Paypal Payment option
    And User verifies that Paypal login page is launched


