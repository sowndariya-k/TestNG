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
public class DemoBlazeDP {

	    WebDriver driver;
	    
	    @DataProvider(name = "validData")
	    public Object[][] validData() {
	        return new Object[][] {
	            {"sowndariya", "Sow@911!"}
	        };
	    }

	    @DataProvider(name = "invalidData")
	    public Object[][] invalidData() {
	        return new Object[][] {
	            {"*sk", "Sow@911!", "User does not exist."},
	            {"sowndariya", "sow@911", "Wrong password."}
	        };
	    }

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

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        WebElement loginBtn = wait.until(
	                ExpectedConditions.elementToBeClickable(By.id("login2"))
	        );

	        loginBtn.click();

	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(username);
	        driver.findElement(By.id("loginpassword")).sendKeys(password);

	        driver.findElement(By.xpath("//button[text()='Log in']")).click();
	    }


	    
	    @Test(dataProvider = "validData")
	    public void validLoginTest(String username, String password) {

	        login(username, password);

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        String user = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))
	        ).getText();

	        Assert.assertTrue(user.contains("Welcome"));
	        System.out.println("Valid login passed");
	    }
	    
	    @Test(dataProvider = "invalidData")
	    public void invalidLoginTest(String username, String password, String expectedMessage) {

	        login(username, password);

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        String actualMsg = alert.getText();
	        alert.accept();

	        Assert.assertEquals(actualMsg, expectedMessage);
	        System.out.println("Invalid test passed: " + actualMsg);
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
