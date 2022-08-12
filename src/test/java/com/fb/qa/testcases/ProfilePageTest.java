package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.ProfilePage;
import com.fb.qa.util.CustomListener;
import com.fb.qa.util.TestUtil;


public class ProfilePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ProfilePage profilePage;

	public ProfilePageTest() {
		super();
	}

	// Avoid dependency between TC. Relaunch Browser after each TC.
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		profilePage = new ProfilePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void checkProfilePageTest() {
		profilePage.checkProfile();
	}

	

	@Test(priority = 2)
	public void checkBioDataEntryTest() {
		profilePage.checkBioDataEntry();
	}
	
	@Test(priority = 3)
	public void seeAllPhotosTest() {
		profilePage.seeAllPhotos();
	}
	
	@Test(priority = 4)
	public void editProfileTest() {
		profilePage.editProfile();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}