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

public class UpdateProfileDetailsTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginRealEstatePOM loginRE;
	private LoggedInPOM loginRE2;
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
		loginRE2 = new LoggedInPOM(driver);
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
		loginRE.clickLoginRegistar();
		loginRE.sendUserName("manzoor123");
		loginRE.sendPassword("manzoor@1234");
		loginRE.clickSignInBtn(); 
		//screenShot.captureScreenShot("First");
		Dimension d = new Dimension(800,500);
		//Resize current window to the set dimension
		driver.manage().window().setSize(d);
		Thread.sleep(3000);
		loginRE2.clickUser();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Assert.assertEquals(true, loginRE2.myProfile.isDisplayed());
		Assert.assertEquals(true, loginRE2.bookmarks.isDisplayed());
		Assert.assertEquals(true, loginRE2.logOut.isDisplayed());
				
		loginRE2.myProfile.click();
		String actualTitle = driver.getCurrentUrl();
		String expectedTitle = "http://realestatem1.upskills.in/my-profile/";
		Assert.assertEquals(actualTitle, expectedTitle);
		
		if(actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");
	   
		loginRE2.sendAgentTitle("Mr.");
		loginRE2.sendPhone("1133557799");
		loginRE2.clickSaveChanges();
		
		String expectedMessage = "Your profile has been updated.";
		//WebElement message = driver.findElement(By.xpath("//div[contains(@class, 'notification success closeable margin-bottom-35')"));
		//String actualMessage1 = driver.findElement(By.xpath("//*[@id=\"post-133\"]/div[2]/div/div[1]/div/p")).getText();
		String actualMessage = loginRE2.getMessage();
		Assert.assertEquals(actualMessage, expectedMessage);
		System.out.println("TC is passed. ");
		
	}
}
