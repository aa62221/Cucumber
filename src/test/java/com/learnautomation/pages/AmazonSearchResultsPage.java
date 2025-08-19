package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonSearchResultsPage extends BasePage {

  private final By results = By.xpath("//div[@class='s-main-slot']//div[@data-component-type='s-search-result']");
  private final By firstResultLink = By.xpath("//div[@class='s-main-slot']//div[@data-component-type='s-search-result'][1]//h2//a");

  public AmazonSearchResultsPage openFirstResult() {
    click(firstResultLink);
    return this;
  }

  public AmazonSearchResultsPage openResultByIndex(int index) {
    List<WebElement> items = findElements(results);
    if (index < items.size()) {
      items.get(index).findElement(By.xpath(".//h2//a")).click();
    }
    return this;
  }

  public int getResultCount() {
    return findElements(results).size();
  }
}


