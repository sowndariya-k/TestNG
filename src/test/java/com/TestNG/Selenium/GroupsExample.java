package com.TestNG.Selenium;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GroupsExample {
	
	@BeforeTest
	public void starting_point() {
		System.out.println("this is the start");
	}
	
	
	  @Test(groups = "groupA")
	    public void testMethod1ForGroupA() {
	        System.out.println("Running test method1 of groupA");
	    }

	    @Test(groups = "groupA")
	    public void testMethod2ForGroupA() {
	        System.out.println("Running test method2 of groupA");
	    }

	    @Test(groups = "groupB")
	    public void testMethod1ForGroupB() {
	        System.out.println("Running test method1 of groupB");
	    }

	    @Test(groups = "groupB")
	    public void testMethod2ForGroupB() {
	        System.out.println("Running test method2 of groupB");
	    }
	     
	    @Test(dependsOnGroups = "groupA")
	    public void dependsOnGroupA() {
	        System.out.println("Running the dependent test");
	    }

}
