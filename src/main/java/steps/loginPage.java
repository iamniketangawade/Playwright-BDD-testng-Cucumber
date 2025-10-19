package steps;

import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginPage {
	public Playwright playwright;
	public Browser browser;
	public BrowserContext browsercontext;
	public Page page;
	
	@Before
	 public void setup() {
		  playwright =Playwright.create();
		  browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(java.util.Arrays.asList("--start-maximized")));
		  browsercontext =browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		  page=browsercontext.newPage();
	 }
	
	@Before(order =0)
	public void message1(){
		System.out.println("First execute");
	}
	@Before(order =1)
	public void message2(){
		System.out.println("S execute");
	}
	

	@BeforeStep
	public static void messagestp(){
		System.out.println("Start step..........");
	}
	
	
	@Given("User navigate to website {string}")
	public void user_navigate_to_website(String URL) {
		
		page.navigate(URL);
	}

	@When("user validates the website title")
	public void user_validates_the_website_title() {
	   String title =page.title();
	   System.out.println("Page title: "+ title);
	}

	@Then("user enters {string} username")
	public void user_enters_username(String username) {
	   page.locator("//input[@id=\"username\"]").fill(username);
	   
	}

	@And("user enters {string} Password")
	public void user_enters_password(String password) {
		 page.locator("//input[@id=\"password\"]").fill(password);
	}

	@And("user clicks on the submit button")
	public void user_clicks_on_the_submit_button() {
		   page.click("//button[@id=\"submit-login\"]");
	}
	
	@BeforeStep
	public static void messagestp1(){
		System.out.println("END step..........");
	}
	
	
	
	
	@After
	public void teardown() {
		page.close();
		browsercontext.close();
		playwright.close();
	}
	
}
