package com.learnautomation.hooks;

import java.time.Duration;
import Base.Base;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHooks extends Base{
  private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
  private static final Object DRIVER_LOCK = new Object();

  @Override
  public WebDriver getDriver() {
    return DRIVER.get();
  }

  @Before
  public void setUp() {
    synchronized (DRIVER_LOCK) {
      if (DRIVER.get() != null) return;

      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      WebDriver driver = new ChromeDriver(options);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().window().maximize();

      DRIVER.set(driver);
    }
  }

  @After
  public void tearDown(Scenario scenario) {
    WebDriver driver = DRIVER.get();
    if (driver != null) {
      if (scenario.isFailed()) {
        try {
          byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
          scenario.attach(screenshot, "image/png", "Failure Screenshot");
        } catch (Exception ignored) {}
      }
//      driver.quit();
      DRIVER.remove();  //--This is used to ensure the memory is cleaned up after the test run
    }
  }
}


