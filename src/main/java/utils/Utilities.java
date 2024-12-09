package utils;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Utilities {


	public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public static void waitUntilElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void clickElement(WebDriver driver, WebElement element) throws ElementClickInterceptedException {
		try {
			element.click();
		} catch (ElementNotInteractableException el) {
			System.out.println("clicking via JavaScript click.");
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
	}
	
	public static void clearElement(WebElement element) {
		element.clear();
	}

}
