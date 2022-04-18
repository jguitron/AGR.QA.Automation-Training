@regression  @smoke
Feature: Verification protection plan availability for Florida, Alaska, Hawaii
  As a user, I should be able to see protection plan details and cost on cart page

  Scenario: User sets store as Florida store
    Given User is on AshleyFurniture's main home page
    When  User clicks on X-close button to close iframe popup
    Then user set the closet store by "33606"

  Scenario: User adds items to cart
    Then  User search for a SKU "7500538" and clicks on it
    Then User verifies that FPP available on PDP
    And  User adds items to cart
    Then  User search for a SKU "P455-822" and clicks on it
    Then User verifies that OUTDoorPP available on PDP
    And  User adds items to cart
    Then  User search for a SKU "M9X732" and clicks on it
    Then User verifies that Adjustable PP available on PDP
    And  User adds items to cart
    Then  User search for a SKU "M9X742" and clicks on item 1 in result set
    And User Select King bed size
    Then User verifies that KingAdjustable available on PDP
    Then  User adds items to cart

  Scenario: User validates protection plans are added in the cart by default and prices are shown
    Given User navigate to cart page
    When User verifies that "protection plan" is added to cart

  Scenario: User sets store as Alaska store / Zipcode and verifies that protection plans are not available
    Then user set the closet store by "99503"
    Then User verifies that Protection Plan is not available


  Scenario: User sets store as Hawaii store / Zipcode and verifies that protection plans are not available
    Then user set the closet store by "96818"
    Then User verifies that Protection Plan is not available


  Scenario: User sets store back to Florida / Zipcode and verifies that protection plans are available to choose
    Then user set the closet store by "33606"
    Then user verifies that protection plan is available on cart
    Then user verifies that protection plan is unselected
    And User closes browser
