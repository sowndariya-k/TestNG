package com.TestNG.Selenium;

import org.testng.annotations.DataProvider;

public class DPDemo {
	@DataProvider(name="testData")
	public Object[][] dataProvFunc(){
		return new Object[][] {{"selenium"},{"TestNG"},{"Automation"}};
	}

}
