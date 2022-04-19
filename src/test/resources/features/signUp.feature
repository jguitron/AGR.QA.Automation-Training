
@smoke
Feature: New user signup and shopping feature.
         As a user I should be able to sign up for a new account
         and search for furniture and add them to my cart

  Scenario: User creates new user account and verifies if new account created.
    Given User navigates to "url"
    When  user clicks on login button
    Then  user then clicks on Login link
    And   user clicks Create account link
    Then  user enters personal information
    Then user confirms age
    And  user clicks on Submit button


  Scenario: User searches for Tv-stand and adds product to cart
            and purchases it. Then verifies total sum in cart.
    Given user clicks on "start shopping" link
    When  user hovers over to "Furniture", chooses "Tv-Stand" and clicks
    And   user navigates to last page
    Then  user chooses last available product and clicks on it
    And   user adds 2 products to his cart
    Then  user checks his cart with total amount


  Scenario Outline: User randomly searches for available products and clicks on them.
                    User heavily uses Search bar with many different product items
    Given user sends "<searchValue>" in search bar
    And   user clicks on search icon
    When  user should see url ending with "<expectedHeader>"
    Then  user should see total amount is more than 0

    Examples:
      | searchValue | expectedHeader |
      | table       | Table          |
      | sofa        | Sofa           |
      | mattress    | Mattress       |
      | loveseat    | LoveSeat       |
      | recliner    | Recliner       |
      | bed         | Bed            |
