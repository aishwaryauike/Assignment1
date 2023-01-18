package com.qa.testLayer;

import org.testng.annotations.Test;

import com.qa.testBase.TestBase;
import com.qa.utilities.UtilClass;

public class TestCase01 extends TestBase {

	@Test
	public void sortTheValue()
	{
		login.enterUserName("Aishwarya Uike");
		login.enterPassword("Aish1234");
		login.clickOnLoginButton();
		home.clickOnAmount();
		System.out.println("Amount");
		home.sortAmount();
	}
}
