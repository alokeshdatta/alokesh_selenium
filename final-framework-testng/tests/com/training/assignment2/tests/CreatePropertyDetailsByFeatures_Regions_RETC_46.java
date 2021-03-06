package com.training.assignment2.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoggedInAdminPOM;
import com.training.pom.LoggedInPOM;
import com.training.pom.LoginRealEstatePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CreatePropertyDetailsByFeatures_Regions_RETC_46 {

	private WebDriver driver;
	private String baseUrl;
	private LoginRealEstatePOM login;
	private LoggedInAdminPOM loginAdmin;
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
		login = new LoginRealEstatePOM(driver);
		loginAdmin = new LoggedInAdminPOM(driver);
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
	public void profileDetailsTest() throws InterruptedException {
		login.clickLoginRegistar();
		login.sendUserName("admin");
		login.sendPassword("admin@123");
		login.clickSignInBtn(); 
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String e = "Test_New_Launches";
		loginAdmin.clickPropertiesLink();
		Thread.sleep(2000);
		loginAdmin.clickAddNewLink();
		Thread.sleep(2000);
		loginAdmin.sendPropertiesTitle("test_Prestige");
		loginAdmin.sendPropertiesTitle("test_Dumdum");
		driver.findElement(By.xpath("//ul[@id='property_featurechecklist']//label[contains(text(), 'Test - Central Kolkata')]")).click();
		driver.findElement(By.xpath("//ul[@id='regionchecklist']//label[contains(text(), 'Test - East India')]")).click();
		Thread.sleep(2000);
		loginAdmin.clickPublishButton();
		Assert.assertEquals(true, loginAdmin.viewPost.isDisplayed());
		loginAdmin.viewPost();
		System.out.println("TC is passed. ");
		
	}
}
