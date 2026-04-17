package com.TestNG.Selenium;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class DemoBlaze {

	    WebDriver driver;
	    SoftAssert sa=new SoftAssert();

	    @BeforeMethod
	    public void beforeMethod() {
	  	  System.out.println("Start the test");
	  	  ChromeOptions options=new ChromeOptions();
	  	  driver=new ChromeDriver(options);
	  	  options.addArguments("--start-maximize");
	  	  options.addArguments("--headless");
	  	  driver.get("https://demoblaze.com/");
	  	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }
	    
	    @Test(priority = 2)
	    public void validation() {
	  	  driver.findElement(By.id("login2")).click();
	  	  driver.findElement(By.id("loginusername")).sendKeys("sowndariya");
	  	  driver.findElement(By.id("loginpassword")).sendKeys("Sow@911");
	      driver.findElement(By.xpath("//button[text()='Log in']")).click();
	      
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	      String actualUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))).getText();
	      Assert.assertEquals(actualUser, "Welcome sowndariya", "Login failed");
	      System.out.println("Login successful:"+actualUser);
	      String actual = driver.getTitle();
	      String expected="STORE";
	      sa.assertEquals(actual, expected, "Page title mismatch");
	      sa.assertAll();
	      System.out.println("Page Title: "+actual);
	    }
	    
	    
	    
	    @Test(dependsOnMethods = "validation", priority = 1)
	    public void invaliduser() {
	    	driver.findElement(By.id("login2")).click();
		  	driver.findElement(By.id("loginusername")).sendKeys("*sk");
		  	driver.findElement(By.id("loginpassword")).sendKeys("Sow@911!");
		    driver.findElement(By.xpath("//button[text()='Log in']")).click();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		    String alertMessage = alert.getText();
		    System.out.println(alertMessage);
		    Assert.assertEquals(alertMessage, "User does not exist.");
		    alert.accept();
	    }
	    
	    @Test(priority = 3)
	    public void invalidpassword() {
	    	driver.findElement(By.id("login2")).click();
		  	driver.findElement(By.id("loginusername")).sendKeys("sowndariya");
		  	driver.findElement(By.id("loginpassword")).sendKeys("sow@911!");
		    driver.findElement(By.xpath("//button[text()='Log in']")).click();
		    
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		    String alertMessage = alert.getText();
		    System.out.println(alertMessage);
		    Assert.assertEquals(alertMessage, "Wrong password.");
		    alert.accept();
	    }

	    @AfterMethod
	    public void after() {
	        driver.quit();
	    }

}
