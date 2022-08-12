package com.fb.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hwpf.model.PropertyNode.StartComparator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;

import com.fb.qa.util.CustomListener;
import com.fb.qa.util.TestUtil;



@Listeners(CustomListener.class)

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public static Logger log = Logger.getLogger(TestBase.class);
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"D:\\Bridgelabz Program\\TestingAPI\\SeleniumJavaFramework\\src\\main\\java\\com\\fb\\qa\\config\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\kmani\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\kmani\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	
	}

	public void takeScreenshotAtEndOfTest(String testMethodName) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyFile(scrFile, new File("D:\\Bridgelabz Program\\TestingAPI\\SeleniumJavaFramework\\screenshots\\"+testMethodName+"_"+".png"));
		}catch(IOException exp) {
			exp.printStackTrace();
		}
	}
	
}