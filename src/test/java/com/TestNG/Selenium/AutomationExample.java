package com.TestNG.Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AutomationExample {
	
  @Test
  public void f() {
	  System.out.println("------@Test-------");
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("------Before Method--------");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("------after Method--------");
  }


  @BeforeClass
  public void beforeClass() {
	  System.out.println("------before class--------");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("------after class--------");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("------Before Test--------");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("------After Test--------");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This will execute before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This will execute after suite");
  }
  

}
