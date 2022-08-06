package com.fb.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class LoginPage extends TestBase {
	//page factory - or:
		@FindBy(name = "email")
		WebElement username;
		
		@FindBy(name = "pass")
		WebElement password;
		
		@FindBy(name = "login")
		WebElement loginBtn;
		
		@FindBy(xpath = "//a[text()='Create New Account']")
		WebElement CreateAccountbtn;
		
		//Initialize page objects
		public LoginPage() {
			PageFactory.initElements(driver, this);		
		}
		//Actions
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}
		
		public HomePage login(String un, String pwd) {
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			
			return new HomePage();
}
}
