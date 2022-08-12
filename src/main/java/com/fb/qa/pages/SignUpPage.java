package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class SignUpPage extends TestBase{
	@FindBy(linkText = "Create New Account")
	WebElement signUp;

	@FindBy(xpath = "//input[@placeholder='First name']")
	WebElement firstname;

	@FindBy(name = "lastname")
	WebElement lastname;

	@FindBy(name = "reg_email__")
	WebElement reg_email__;

	@FindBy(name = "reg_email_confirmation__")
	WebElement reg_email_confirmation__;

	@FindBy(id = "password_step_input")
	WebElement reg_passwd__;

	@FindBy(name = "birthday_day")
	WebElement birthday_day;

	@FindBy(name = "birthday_month")
	WebElement birthday_month;

	@FindBy(name = "birthday_year")
	WebElement birthday_year;

	@FindBy(name = "sex")
	WebElement gender;

	@FindBy(name = "websubmit")
	WebElement signUpBtn;

	public SignUpPage() {
		PageFactory.initElements(driver, this);
		signUp.click();
	}

	public String validateSignUpPageTitle() {
		return driver.getTitle();
	}

	public LoginPage signUp(String fn, String ln,
			String em, String vem, String pwd, String bd, String bm, String by,
			String g) {
		firstname.sendKeys("Rohit");
		lastname.sendKeys("sharma");
		reg_email__.sendKeys("manish@gmail.com");
		reg_email_confirmation__.sendKeys("manish@gmail.com");
		reg_passwd__.sendKeys("qwerty123");
		birthday_day.sendKeys("12");
		birthday_month.sendKeys("Jan");
		birthday_year.sendKeys("2003");
		gender.sendKeys("Male");
		signUpBtn.click();
		return new LoginPage();
	}
}
