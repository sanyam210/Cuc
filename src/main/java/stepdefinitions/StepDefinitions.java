package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.HomePage;

public class StepDefinitions {

	HomePage hmpage;
	Logger log = LogManager.getLogger("StepDefinitions");

	@Given("user enters the name {string} in the search box")
	public void user_enters_the_in_the_search_box(String string) {
		try {
			hmpage = new HomePage(Hooks.getDriver());
			hmpage.enterTextInEmailField(string);
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}
	}

	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
		try {
			hmpage = new HomePage(Hooks.getDriver());
			hmpage.clickSerchButton();
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}
	}


	@Then("user verifies the name of searched item")
	public void user_verifies_the_name_of_searched_item() {
		try {
			hmpage= new HomePage(Hooks.getDriver());
			Assert.assertEquals(hmpage.getProductName(),"Tomato");
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}
	}


	@When("user clicks on add to cart button")
	public void user_clicks_add_to_cart() {
		try {
			hmpage= new HomePage(Hooks.getDriver());
			hmpage.clickAddToCart();
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}
	}

	@Then("user clicks on cart button and verify item")
	public void user_clicks_car_button_verify() {
		try {
			hmpage= new HomePage(Hooks.getDriver());
			Assert.assertEquals(hmpage.clickOnCarTButtonAndVerify(),"Tomato");
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}
	}


}
