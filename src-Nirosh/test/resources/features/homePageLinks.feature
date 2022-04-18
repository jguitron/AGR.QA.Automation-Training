
@regression  @smoke
Feature: Verification of all links from main landing page
         As a user, I should be able to see and be able to click on all available links on page

  Scenario: AshleyFurniture main landing page links verification
    Given User is on AshleyFurniture's main home page
    When  User clicks on X-close button to close iframe popup
    And   User gets each available link from main page
    And   User hovers over each contentType items
    Then  User clicks on the "furniture" link




