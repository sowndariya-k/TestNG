package com.TestNG.Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {

    WebDriver driver;

    @BeforeTest
    public void beforeTest() {

        System.out.println("Start the test");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);

        driver.get("https://demoblaze.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void validation() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        ((JavascriptExecutor) driver).executeScript(
                "document.querySelector('.carousel').style.display='none';");

        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("login2")));
        loginBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")))
                .sendKeys("sowndariya");

        driver.findElement(By.id("loginpassword")).sendKeys("Sow@911!");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));

        System.out.println("Login completed");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void a() {
        System.out.println("hello");
    }

    @Test
    public void b() {
        System.out.println("hi");
    }

    @Test
    public void c() {
        System.out.println("welcome");
    }
}