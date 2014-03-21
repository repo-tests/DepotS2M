package com.e2a.examenenligne.fonctTests;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:9090/examenenligne";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSelenium() throws Exception {
    driver.get(baseUrl + "/examenenligne/acceuil.xhtml");
    driver.findElement(By.id("login:Login")).clear();
    driver.findElement(By.id("login:Login")).sendKeys("expert");
    driver.findElement(By.id("login:password")).clear();
    driver.findElement(By.id("login:password")).sendKeys("expert");
    driver.findElement(By.id("login:j_idt24")).click();
    driver.findElement(By.cssSelector("a")).click();
    driver.findElement(By.xpath("//div[@id='j_idt56:j_idt57']/ul/li[2]/a/span[2]")).click();
    driver.findElement(By.xpath("//div[@id='j_idt56:j_idt57']/ul/li[3]/a/span[2]")).click();
    driver.findElement(By.xpath("//div[@id='j_idt43:j_idt44']/ul/li[4]/a/span[2]")).click();
    driver.findElement(By.xpath("//div[@id='j_idt36:j_idt37']/ul/li[5]/a/span[2]")).click();
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
