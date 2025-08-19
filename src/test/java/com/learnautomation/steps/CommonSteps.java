package com.learnautomation.steps;

import com.learnautomation.hooks.TestHooks;
import com.learnautomation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CommonSteps {

  @Given("I am on the home page")
  public void i_am_on_the_home_page() {
    WebDriver driver = TestHooks.getDriver();
    String baseUrl = ConfigReader.getProperty("amazon.base.url", "https://www.amazon.in/");
    driver.get(baseUrl);
  }
}


