package com.learnautomation.steps;

import com.learnautomation.pages.AmazonHomePage;
import com.learnautomation.pages.AmazonSearchResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SearchSteps {

  @And("I search for {string}")
  public void i_search_for(String term) {
    new AmazonHomePage().search(term);
  }

  @Then("I should see search results")
  public void i_should_see_results() {
    if (new AmazonSearchResultsPage().getResultCount() <= 0) {
      throw new AssertionError("No search results found");
    }
  }
}


