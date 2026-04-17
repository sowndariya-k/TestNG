package com.TestNG.Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;
 
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Start the test");
	  ChromeOptions options=new ChromeOptions();
	  driver=new ChromeDriver(options);
	  options.addArguments("--start-maximize");
	  //options.addArguments("--headless");
	  driver.get("https://demoblaze.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  @Test
  public void validation() {
	  driver.findElement(By.id("login2")).click();
	  driver.findElement(By.id("loginusername")).sendKeys("sowndariya");
	  driver.findElement(By.id("loginpassword")).sendKeys("Sow@911!");
      driver.findElement(By.xpath("//button[text()='Log in']")).click();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  @Test
  public void b() {
	  System.out.println("hi");
  }
  @Test
  public void a() {
	  System.out.println("hello");
  }
  @Test
  public void c() {
	  System.out.println("welcome");
  }

}
