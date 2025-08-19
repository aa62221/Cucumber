Feature: Add to cart

  Scenario: Add first search result to cart
    Given I am on the home page
    And I search for "mouse"
    When I open the first search result
    And I add it to the cart and open cart


