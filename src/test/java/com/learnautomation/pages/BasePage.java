package com.learnautomation.pages;

import com.learnautomation.hooks.TestHooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

  protected final WebDriver driver;
  protected final WebDriverWait wait;

  protected BasePage() {
    this.driver = TestHooks.getDriver();
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
  }

  protected WebElement waitForVisible(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  protected void click(By locator) {
    waitForVisible(locator).click();
  }

  protected void type(By locator, String text) {
    WebElement element = waitForVisible(locator);
    element.clear();
    element.sendKeys(text);
  }

  protected String getText(By locator) {
    return waitForVisible(locator).getText();
  }

  protected boolean isElementVisible(By locator) {
    try {
      waitForVisible(locator);
      return true;
    } catch (TimeoutException e) {
      return false;
    }
  }

  protected List<WebElement> findElements(By locator) {
    return driver.findElements(locator);
  }
}


