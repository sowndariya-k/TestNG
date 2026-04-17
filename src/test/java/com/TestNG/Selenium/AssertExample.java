package com.TestNG.Selenium;

import org.testng.Assert;
import org.testng.annotations.Test;



public class AssertExample {
	@Test
	public void testAssessment() {
		String str1=new String("TestNG");
		String str2=new String("TestNG");
		String str3=null;
		String str4="TestNG";
		String str5="TestNG";
		String str6=new String("Not_TestNG");
		
		int val1=5;
		int val2=6;
		
		Assert.assertEquals(str1, str2);
		System.out.println("Equal Assertion is successful");
		
		Assert.assertNotEquals(str1, str6);
		System.out.println("Not Equals Assertion is successful");
		
		Assert.assertTrue(val1<val2);
		System.out.println("Test Assertion is successful");
		
		Assert.assertFalse(val1>val2);
		System.out.println("Test Assertion is successful");
		
		Assert.assertNotNull(str1);
		System.out.println("Not Null Assertion is successful");
		
		Assert.assertNull(str3);
		
		Assert.assertSame(str4, str5);
		System.out.println("same Assertion is successful");
		
		Assert.assertNotSame(str1, str3);
		System.out.println("Not same Assertion is successful");
	}

}
