@smoke @regression
Feature: Verification protection plan availability for Florida, Alaska, Hawaii
  As a user, I should be able to see protection plan details and cost on cart page

  Scenario: User sets store as Florida store
    Given User navigates to "url"
    Then User finds closest store by "33606"
    Then  User searches for SKU "7500538" and clicks on it
    Then User verifies that FPP available on PDP
    And  User clicks on Add Item to Cart
    Then  User searches for SKU "P455-822" and clicks on it
    Then User verifies that OUTDoorPP available on PDP
    And  User clicks on Add Item to Cart
    Then  User searches for SKU "M9X732" and clicks on it
    Then User verifies that Adjustable PP available on PDP
    And  User clicks on Add Item to Cart
    Then  User searches for SKU "M9X742" and clicks on it
    And User Select King bed size
    Then User verifies that KingAdjustable available on PDP
    Then  User clicks on Add Item to Cart
    Then User navigate to cart page
    When User verifies that "protection plan" is added to cart
    Then User finds closest store by "99503"
    Then User verifies that Protection Plan is not available
    Then User finds closest store by "96818"
    Then User verifies that Protection Plan is not available
    Then User finds closest store by "33606"
    Then User verifies that protection plan is available on cart
    Then User verifies that protection plan is unselected
