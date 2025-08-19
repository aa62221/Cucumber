package com.learnautomation.pages;

import com.learnautomation.utils.ConfigReader;
import org.openqa.selenium.By;

public class AmazonLoginPage extends BasePage {

  private final By emailField = By.id("ap_email");
  private final By continueBtn = By.id("continue");
  private final By passwordField = By.id("ap_password");
  private final By signInSubmit = By.id("signInSubmit");
  private final By accountName = By.id("nav-link-accountList-nav-line-1");

  public AmazonLoginPage loginWithConfiguredUser() {
    String email = ConfigReader.getProperty("amazon.email", "");
    String password = ConfigReader.getProperty("amazon.password", "");
    return login(email, password);
  }

  public AmazonLoginPage login(String email, String password) {
    type(emailField, email);
    click(continueBtn);
    type(passwordField, password);
    click(signInSubmit);
    return this;
  }

  public boolean isLoggedIn() {
    return isElementVisible(accountName);
  }
}


