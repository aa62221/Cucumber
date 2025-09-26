package com.learnautomation.hooks;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import Base.Base;
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
  
  // Add Threadlocal<ScenarioContext> if you want to share data between steps
 //  Shared objects like WebDriver, API responses, or user details can be injected.
  
//
//  @Before
//  public void setUp() {
//      synchronized (DRIVER_LOCK) {
//          if (DRIVER.get() != null) return;
//
//          String executionType = System.getProperty("execution", "local"); // default local
//          WebDriver driver;
//
//          try {
//              if (executionType.equalsIgnoreCase("grid")) {
//                  ChromeOptions options = new ChromeOptions();
//                  options.addArguments("--remote-allow-origins=*");
//                  String gridUrl = System.getProperty("gridUrl", "http://localhost:4444/wd/hub");
//
//                  driver = new RemoteWebDriver(new URL(gridUrl), options);
//              } else {
//                  WebDriverManager.chromedriver().setup();
//                  ChromeOptions options = new ChromeOptions();
//                  driver = new ChromeDriver(options);
//              }
//
//              driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//              driver.manage().window().maximize();
//              DRIVER.set(driver);
//
//          } catch (Exception e) {
//              throw new RuntimeException("Failed to start WebDriver", e);
//          }
//      }
//  }
//  Local run: mvn clean test
//  Grid run: mvn clean test -Dexecution=grid -DgridUrl=http://localhost:4444/wd/hub


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


