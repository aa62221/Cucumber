package com.learnautomation.pages;

import org.openqa.selenium.By;

public class AmazonProductPage extends BasePage {

  private final By addToCartButton = By.id("add-to-cart-button");
  private final By goToCartButton = By.id("nav-cart");

  public AmazonProductPage addToCart() {
    click(addToCartButton);
    return this;
  }

  public AmazonProductPage goToCart() {
    click(goToCartButton);
    return this;
  }
}


