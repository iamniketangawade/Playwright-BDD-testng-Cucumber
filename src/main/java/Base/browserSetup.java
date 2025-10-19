package Base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class browserSetup {
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
	
	@After
	public void teardown() {
		page.close();
		browsercontext.close();
		playwright.close();
	}
	
	
}
