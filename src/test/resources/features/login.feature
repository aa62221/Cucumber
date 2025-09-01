Feature: Login

  Scenario Outline: Login with configured user
    Given I am on the home page
    When I navigate to the sign in page
    And I log in with username "<username>" and password "<password>"
    Then I should be logged in successfully
   
   
   Examples:
      | username  | password  |
      | 9004999581| Amazon.in |
   

