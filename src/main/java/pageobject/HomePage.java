package pageobject;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.Utilities;

public class HomePage {
	private WebDriver driver;

	Logger log = LogManager.getLogger("HomePage");


	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchField;
	
	
	@FindBy(xpath = "//button[@class='search-button']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//h4[@class='product-name']")
	private WebElement productName;
	
	@FindBy(xpath = "//button[text()='ADD TO CART']")
	private WebElement addToCart;
	
	@FindBy(xpath = "//a[@class='cart-icon']")
	private WebElement cartButton;
	
	@FindBy(xpath = "//p[@class='product-name']")
	private WebElement itemInCart;
	
	public void enterTextInEmailField(String text) {
		Utilities.waitForElementToBeVisible(driver, searchField);
		Utilities.clickElement(driver,searchField);
		searchField.sendKeys(text);
		log.info("Entered the text in search field");
	}
	
	public void clickSerchButton() {
		Utilities.waitForElementToBeVisible(driver, searchButton);
		Utilities.clickElement(driver, searchButton);
		log.info("clicked search button");
	}

	public String getProductName() {
		Utilities.waitForElementToBeVisible(driver, productName);
		log.info("Looking for the productname");
		return productName.getText().substring(0, 6);
	}
	

	public void clickAddToCart() {
		try {
			Utilities.waitForElementToBeVisible(driver, addToCart);
			Utilities.clickElement(driver, addToCart);
			log.info("Clicked on add to cart");
		} catch (StaleElementReferenceException e) {
			Utilities.waitForElementToBeVisible(driver, addToCart);
			Utilities.clickElement(driver, addToCart);
			log.info("Clicked on add to cart");
		}
		
		
	}
	
	public String clickOnCarTButtonAndVerify() {
		Utilities.waitForElementToBeVisible(driver, cartButton);
		log.info("Looking for the productname");
		Utilities.clickElement(driver, cartButton);
		log.info("Clicked on cart button");
		Utilities.waitForElementToBeVisible(driver, itemInCart);
		log.info(itemInCart.getText().substring(0,6));
		return itemInCart.getText().substring(0,6);
	}


	
}
