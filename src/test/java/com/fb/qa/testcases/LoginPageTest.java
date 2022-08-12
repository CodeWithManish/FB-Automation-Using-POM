package com.fb.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public static Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
		log.info("loginPageTitle"+title);
	}

	@Test(priority = 2)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Proper login "+homePage);
	}

	@AfterMethod
	public void tearDown() {
		 driver.quit();
	}

}
