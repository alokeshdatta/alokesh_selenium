
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedInPOM {
	private WebDriver driver; 
	
	public LoggedInPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='user-name']")
	public WebElement dropdown;
	
	//div[@class='user-menu active']//a[contains(text(), 'My Profile')]
	@FindBy(xpath="//div[@class='user-menu active']//a[@href='http://realestatem1.upskills.in/my-profile/']")
	public WebElement myProfile;
	
	@FindBy(xpath="//div[@class='user-menu active']//a[@href='http://realestatem1.upskills.in/my-bookmarks/']")
	public WebElement bookmarks;
	
	@FindBy(xpath="//div[@class='user-menu active']//a[contains(text(),'Log Out')]")
	public WebElement logOut;
	
	@FindBy(xpath="//span[contains(text(),'manzoor')]")
	public WebElement user;
		
	@FindBy(id="agent_title")
	private WebElement agentTitle; 
	
	@FindBy(id="phone")
	private WebElement phone; 
	
	@FindBy(id="user_login")
	private WebElement userName;
	
	@FindBy(xpath="//button[contains(text(),'Save Changes')]")
	//@FindBy(xpath="//*[@id='edit_user']/button")
	private WebElement saveChanges;
	
	
	//@FindBy(xpath="//div[contains(@class,'notification success closeable margin-bottom-35')")
	@FindBy(xpath="//*[@id=\"post-133\"]/div[2]/div/div[1]/div/p")
	private WebElement message;
	
	//@FindBy(xpath="//a[contains(text(),' Change Password')]")
	@FindBy(xpath="//*[@id='post-133']/div[1]/div/div/ul[2]/li[1]/a")
	public WebElement changePwd;
	
	@FindBy(xpath="//input[@name='current_pass']")
	public WebElement currentPwd;
	
	@FindBy(xpath="//input[@name='pass1']")
	public WebElement newPwd;
	
	@FindBy(xpath="//input[@name='pass2']")
	public WebElement confirmPwd;
	
	@FindBy(id="wp-submit")
	private WebElement saveChanges1;
		
	
	public void clickUser() {
		this.dropdown.click();
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendAgentTitle(String agentTitle) {
		this.agentTitle.clear();
		this.agentTitle.sendKeys(agentTitle);
	}
	
	public void sendPhone(String phone) {
		this.phone.clear();
		this.phone.sendKeys(phone);
	}
	
	public void clickSaveChanges() {
		this.saveChanges.click();
	}
	
	public String getMessage() {
		return this.message.getText();
	}
	
	public void clickChangePwd() {
		this.changePwd.click();
	}
	
	public void sendCurrentPwd(String crntPwd) {
		this.currentPwd.clear();
		this.currentPwd.sendKeys(crntPwd);
	}
	public void sendNewPwd(String newPwd) {
		this.newPwd.clear();
		this.newPwd.sendKeys(newPwd);
	}
	public void sendConfirmPwd(String confirmPwd) {
		this.confirmPwd.clear();
		this.confirmPwd.sendKeys(confirmPwd);
	}
	public void clickSaveChanges1() {
		this.saveChanges1.click();
	}
	
	
	
	
	
	
}
