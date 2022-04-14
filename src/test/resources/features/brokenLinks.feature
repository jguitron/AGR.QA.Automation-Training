@regression
Feature: Broken links capture
  Check all available "links" and verify if all functional

  @smoke
  Scenario:  Verify if all URLs in page are valid
    Given user navigates to "devURL"
    Then user clicks on each link on page to verify


