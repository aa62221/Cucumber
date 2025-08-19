Feature: Login

  Scenario: Login with configured user
    Given I am on the home page
    When I navigate to the sign in page
    And I login with configured credentials
    Then I should see that I am logged in


