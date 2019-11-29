package com.training.assignment1.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoggedInPOM;
import com.training.pom.LoginRealEstatePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LogoutTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginRealEstatePOM loginRE;
	private LoggedInPOM loginRE4;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginRE = new LoginRealEstatePOM(driver);
		loginRE4 = new LoggedInPOM(driver);
		baseUrl = properties.getProperty("baseURL1");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void logoutTest() throws InterruptedException {
		loginRE.clickLoginRegistar();
		loginRE.sendUserName("manzoor123");
		loginRE.sendPassword("manzoor@1234");
		loginRE.clickSignInBtn(); 
		//screenShot.captureScreenShot("First");
		//Test No. 2
		Dimension d = new Dimension(800,500);
		//Resize current window to the set dimension
		driver.manage().window().setSize(d);
		Thread.sleep(3000);
		loginRE4.clickUser();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Assert.assertEquals(true, loginRE4.myProfile.isDisplayed());
		Assert.assertEquals(true, loginRE4.bookmarks.isDisplayed());
		Assert.assertEquals(true, loginRE4.logOut.isDisplayed());
		loginRE4.logOut.click();
		System.out.println("TC is passed.");
	}	
	
}
