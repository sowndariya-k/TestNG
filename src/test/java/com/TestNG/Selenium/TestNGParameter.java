package com.TestNG.Selenium;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGParameter {

    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(new ChromeOptions());
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver(new FirefoxOptions());
        } else {
            throw new RuntimeException("Invalid browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoblaze.com/");
    }

    private void login(String username, String password) {
        driver.findElement(By.id("login2")).click();
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Test
    @Parameters({"username", "password", "testType"})
    public void loginTest(String username, String password, String testType) {

        login(username, password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (testType.equalsIgnoreCase("valid")) {

            String user = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))
            ).getText();

            Assert.assertTrue(user.contains("Welcome"));
            System.out.println("Valid login passed");

        } else {

            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String msg = alert.getText();
            alert.accept();

            if (testType.equalsIgnoreCase("invalidUser")) {
                Assert.assertEquals(msg, "User does not exist.");
            }

            if (testType.equalsIgnoreCase("invalidPassword")) {
                Assert.assertEquals(msg, "Wrong password.");
            }

            System.out.println(testType + " test passed");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}