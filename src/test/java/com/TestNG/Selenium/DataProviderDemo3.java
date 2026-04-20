package com.TestNG.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProviderDemo3 {
	private static final ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Start the test");
		driver.set(new ChromeDriver());
		}
	
	@Test(dataProvider = "testData" ,dataProviderClass=DPDemo.class)
	public void search(String keyWord1) throws InterruptedException {
		WebDriver driver1=driver.get();
		driver1.get("https://www.bing.com/");
		WebElement txBoxElement=driver1.findElement(By.id("sb_form_q"));
		txBoxElement.sendKeys(keyWord1);
		System.out.println("KeyWord entered is : "+keyWord1);
		txBoxElement.sendKeys(Keys.ENTER);
		System.out.println("search result is displayed");
	}
	
	@AfterMethod
	public void tearDown() {
		WebDriver driver1=driver.get();
		System.out.println("After method thread is: "+Thread.currentThread());
		if(driver1!=null) {
            driver1.quit();
		}
        }

}
