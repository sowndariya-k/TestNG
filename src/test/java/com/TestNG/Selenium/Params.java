package com.TestNG.Selenium;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Params {
	@Test
	@Parameters ({"val1", "val2"})
	public void sum(int v1, int v2) {
		int finalSum=v1+v2;
		System.out.print("sum: "+finalSum);
		
	}
	@Test
	@Parameters({"val1","val2"})
	public void sum1(int v1, int v2){
		int finalsum=v1-v2;
		System.out.println("sub:"+finalsum);
	}

}
