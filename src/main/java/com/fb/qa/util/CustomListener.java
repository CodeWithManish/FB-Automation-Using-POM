package com.fb.qa.util;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.fb.qa.base.TestBase;

public class CustomListener extends TestBase implements ITestListener  {
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("FAILED Test");
		takeScreenshotAtEndOfTest(result.getMethod().getMethodName());
	}
}
