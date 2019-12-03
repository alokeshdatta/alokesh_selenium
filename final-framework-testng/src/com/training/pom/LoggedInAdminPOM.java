
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedInAdminPOM {
	private WebDriver driver; 
	
	public LoggedInAdminPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@id='menu-posts-property']//div[contains(text(),'Properties')]")
	private WebElement properties;
	
	//div[@class='user-menu active']//a[contains(text(), 'My Profile')]
	@FindBy(xpath="//a[@href='post-new.php?post_type=property' and contains(text(),'Add New')]")
	private WebElement addNew;
	
	@FindBy(xpath="//input[@name=\"post_title\"]")
	private WebElement enterTitle_Properties;
	
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement textbox_Properties;
	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement publish;
		
	@FindBy(xpath="//a[contains(text(), 'View post')]")
	public WebElement viewPost;
	
	@FindBy(xpath="//div[@class='property-title']/h2")
	private WebElement propertyTitle; 
	
	@FindBy(xpath="//a[@href='edit-tags.php?taxonomy=property_feature&post_type=property' and contains(text(),'Features')]")
	private WebElement features;
	
	@FindBy(xpath="//input[@name='tag-name']")
	private WebElement featuresName;
	
	
	@FindBy(xpath="//input[@name='slug' and @id='tag-slug']")
	private WebElement featuresSlug;
	
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement featuresDescription;
	
	@FindBy(xpath="//input[@name='submit' and @value='Add New Feature']")
	private WebElement addNewFeatureButton;
	
	public void clickPropertiesLink() {
		this.properties.click();
	}
	public void clickAddNewLink() {
		this.addNew.click();
	}
	
	public void sendPropertiesTitle(String title) {
		this.enterTitle_Properties.clear();
		this.enterTitle_Properties.sendKeys(title);
	}
	
	public void sendPropertiesContent(String content) {
		//this.textbox_Properties.clear();
		this.textbox_Properties.sendKeys(content);
	}
	
	public void clickPublishButton() {
		this.publish.click();
	}
	
	public void viewPost() {
		this.viewPost.click();
	}
	
	public String getPropertyTitle() {
		return this.propertyTitle.getText();
	}
	
	public void clickFeatures() {
		this.features.click();
	}
	
	public void sendFeaturesName(String name) {
		this.featuresName.clear();
		this.featuresName.sendKeys(name);
	}
	
	public void sendFeaturesSlug(String slug) {
		this.featuresSlug.clear();
		this.featuresSlug.sendKeys(slug);
	}
	
	public void sendFeaturesDescription(String description) {
		this.featuresDescription.clear();
		this.featuresDescription.sendKeys(description);
	}
	
	public void clickAddNewFeatureButton() {
		this.addNewFeatureButton.click();
	}
	
	
	
}
