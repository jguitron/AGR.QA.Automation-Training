@smoke @wip
Feature: Profile user Item search and add items to cart

  Scenario: User searches for Tv-stand and adds product to cart
  and purchases it. Then verifies total sum in cart.

    Given User navigates to "url"
    And User clicks on login link on different viewports
    When User logs in with "username" and "password"
    Then User should see user dashboard
    Then User clicks on Start Shopping link
    When  User hovers over to "Furniture" and clicks on "TV Stands"
    And User navigates to last page
#    Then User chooses last available product and clicks on it
#    And User adds 2 products to his cart
#    Then User checks his cart with total amount


  Scenario Outline: User randomly searches for available products and clicks on them.
  User heavily uses Search bar with many different product items
    Given User navigates to "url"
    Then User sends "<searchValue>" in search bar
    And   User clicks on search icon
    When  User should see url ending with "<expectedHeader>"
    Then  User should see total amount is more than 0

    Examples:
      | searchValue | expectedHeader |
      | table       | Table          |
      | sofa        | Sofa           |
      | mattress    | Mattress       |
      | loveseat    | LoveSeat       |
      | recliner    | Recliner       |
      | bed         | Bed            |
