package com.learnautomation.steps;

import com.learnautomation.pages.AmazonHomePage;
import com.learnautomation.pages.AmazonLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

  @When("I navigate to the sign in page")
  public void i_navigate_to_sign_in() {
    new AmazonHomePage().goToSignIn();
  }

  @And("I login with configured credentials")
  public void i_login_with_configured_credentials() {
    new AmazonLoginPage().loginWithConfiguredUser();
  }

  @Then("I should see that I am logged in")
  public void i_should_see_logged_in() {
    if (!new AmazonLoginPage().isLoggedIn()) {
      throw new AssertionError("User is not logged in");
    }
  }
}


