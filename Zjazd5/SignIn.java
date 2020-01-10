package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SignIn {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSignIn() throws Exception {
    driver.get("https://www.phptravels.net/home");
    // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
    driver.findElement(By.linkText("My Account")).click();
    driver.findElement(By.linkText("Login")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("demouser");
    // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Remember Me'])[1]/following::button[1]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot |  | ]]
    driver.findElement(By.linkText("Demo")).click();
    driver.findElement(By.linkText("Logout")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}