package com.training.pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class test2 {

	private WebDriver driver;
	private String baseUrl;
	private LoginRealEstatePOM loginRE;
	private static Properties properties;
	private ScreenShot screenShot;

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
		baseUrl = properties.getProperty("baseURL1");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
	//	driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		loginRE.clickLoginRegistar();
		loginRE.sendUserName("admin");
		loginRE.sendPassword("admin@123");
		loginRE.clickSignInBtn(); 
        String e = "Test_New_Launches";
		driver.findElement(By.xpath("//li[@id='menu-posts-property']//div[contains(text(),'Properties')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='edit-tags.php?taxonomy=property_feature&post_type=property' and contains(text(),'Features')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='tag-name']")).sendKeys(e);
		driver.findElement(By.xpath("//input[@name='slug' and @id='tag-slug']")).sendKeys("Test_launch");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Test_New Launches of villas, apartments, flats");
		driver.findElement(By.xpath("//input[@name='submit' and @value='Add New Feature']")).click();
		driver.findElement(By.xpath("//a[@href='post-new.php?post_type=property' and contains(text(),'Add New')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@id='title-prompt-text' and contains(text(),'Enter title here')]")).click();
		driver.findElement(By.xpath("//input[@name=\"post_title\"]")).sendKeys("test_prestige");
		driver.findElement(By.xpath("//textarea[@id='content']")).sendKeys("test_hometown");
		driver.findElement(By.xpath("//ul[@id='property_featurechecklist']//label[contains(text(), 'Test_New_Launches')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='publish']")).click();
		
		System.out.println("Test is passed");
	}
}