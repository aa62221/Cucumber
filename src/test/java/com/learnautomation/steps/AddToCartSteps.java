package com.learnautomation.steps;

import com.learnautomation.pages.AmazonProductPage;
import com.learnautomation.pages.AmazonSearchResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class AddToCartSteps {

  @When("I open the first search result")
  public void i_open_first_search_result() {
    new AmazonSearchResultsPage().openFirstResult();
  }

  @And("I add it to the cart and open cart")
  public void i_add_it_to_cart_and_open_cart() {
    new AmazonProductPage().addToCart().goToCart();
  }
}


