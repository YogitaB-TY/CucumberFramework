package stepdefinitions;

import com.demowebshop.pageobjects.HomePage;
import com.demowebshop.pageobjects.LoginPage;
import com.demowebshop.pageobjects.ProductPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Base;

public class DemoWebShopLoginTest extends Base{
	public Base base;
	public HomePage homepage;
	public LoginPage loginpage;
	public ProductPage productpage;
	public DemoWebShopLoginTest(Base base) {
		this.base=base;
	}
	
	@Given("already Browser is launched and I will enter the url")
	public void already_browser_is_launched_and_i_will_enter_the_url() throws Throwable {
	  String url= base.fileReader.getValueProperty("url");
	  base.driver.get(url);
	  
	}
	@Given("click on log in")
	public void click_on_log_in() {
	    homepage=new HomePage(base.driver);
	    homepage.clickOnLogin();
	}
	@Given("Enter username and password")
	public void enter_username_and_password() throws Throwable {
	   loginpage= new LoginPage(base.driver);
	 String email= base.fileReader.getValueProperty("email");
	 System.out.println(email);
	 String password= base.fileReader.getValueProperty("password");
	   loginpage.login(email, password);
	   loginpage.clickOnLogin();
	}
	@When("Home page is displayed I will do mouse hover on computers and I will click on desktops")
	public void home_page_is_displayed_i_will_do_mouse_hover_on_computers_and_i_will_click_on_desktops() {
	   homepage.clickOnDesktop();
	  
	}
	@When("In product page add any item to cart by clicking add to cart")
	public void in_product_page_add_any_item_to_cart_by_clicking_add_to_cart() {
		 productpage=new ProductPage(base.driver);
		   productpage.clickOnAddToCart();
		productpage.clickOnshippingCart();
	}
	@Then("Navigate to shopping cart and verify the count")
	public void navigate_to_shopping_cart_and_verify_the_count() {
	    homepage.clickOnShippingCart();
	}

}
