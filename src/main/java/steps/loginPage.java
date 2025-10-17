package steps;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginPage {
	
	Playwright playwright =Playwright.create();
	Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(java.util.Arrays.asList("--start-maximized")));
	
	BrowserContext browsercontext =browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
	Page page=browsercontext.newPage();
	
	@Given("User navigate to website")
	public void user_navigate_to_website() {
		
		page.navigate("https://practice.expandtesting.com/login");
	}

	@When("user validates the website title")
	public void user_validates_the_website_title() {
	   String title =page.title();
	   System.out.println("Page title: "+ title);
	}

	@Then("user enters username")
	public void user_enters_username() {
	   page.locator("//input[@id=\"username\"]").fill("practice");
	}

	@And("user enters Password")
	public void user_enters_password() {
		 page.locator("//input[@id=\"password\"]").fill("SuperSecretPassword!");
	}

	@And("user clicks on the submit button")
	public void user_clicks_on_the_submit_button() {
		   page.click("//button[@id=\"submit-login\"]");
	}
	
	
}
