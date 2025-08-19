package com.learnautomation.pages;

import org.openqa.selenium.By;

public class AmazonHomePage extends BasePage {

  private final By signInNav = By.id("nav-link-accountList");
  private final By searchBox = By.id("twotabsearchtextbox");
  private final By searchSubmit = By.id("nav-search-submit-button");

  public AmazonHomePage goToSignIn() {
    click(signInNav);
    return this;
  }

  public AmazonHomePage search(String query) {
    type(searchBox, query);
    click(searchSubmit);
    return this;
  }
}


