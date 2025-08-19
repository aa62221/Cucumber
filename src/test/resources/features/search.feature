Feature: Search product

  Scenario: Search for a product
    Given I am on the home page
    And I search for "laptop"
    Then I should see search results


