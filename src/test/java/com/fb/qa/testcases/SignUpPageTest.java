package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.fb.qa.base.TestBase;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.SignUpPage;
import com.fb.qa.util.CustomListener;
import com.fb.qa.util.TestUtil;

public class SignUpPageTest extends TestBase {
	SignUpPage signUpPage;
	LoginPage loginPage;
	TestUtil testUtil;

	public SignUpPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		signUpPage = new SignUpPage();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void signUpPageTitleTest() {
		String title = signUpPage.validateSignUpPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}

	@Test(priority = 2)
	public void SignUpTest() {
		loginPage = signUpPage.signUp(prop.getProperty("firstname"), prop.getProperty("lastname"),
				prop.getProperty("reg_email__"), prop.getProperty("reg_email_confirmation__"),
				prop.getProperty("reg_passwd__"), prop.getProperty("birthday_day"), prop.getProperty("birthday_month"),
				prop.getProperty("birthday_year"), prop.getProperty("gender"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
