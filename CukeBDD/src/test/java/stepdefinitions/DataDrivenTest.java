package stepdefinitions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest {
	WebDriver driver;
	@Given("I will launch browser {string}")
	public void i_will_launch_browser(String browserName) {
	    if(browserName.equalsIgnoreCase("chrome")) {
	    	WebDriverManager.chromedriver().setup();
	    	driver=new ChromeDriver();
	    }
	    else if(browserName.equalsIgnoreCase("firefox")) {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();
	    }
	    else {
	    	System.out.println("provide valid browser "+ browserName);
	    }
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Given("I will enter the url {string}")
	public void i_will_enter_the_url(String url) {
	   driver.get(url);
	}
	@Given("enter username {string} and password {string}")
	public void enter_username_and_password(String username, String password) {
	    driver.findElement(By.name("user_name")).sendKeys(username);
	    driver.findElement(By.name("user_password")).sendKeys(password);
	}
	@Given("click on login")
	public void click_on_login() {
	    driver.findElement(By.id("submitButton")).click();
	}
	@When("login page is dispalyed I will click on organization link")
	public void login_page_is_dispalyed_i_will_click_on_organization_link() {
	    driver.findElement(By.linkText("Organizations")).click();
	}
	@When("In organization click on create new organization")
	public void in_organization_click_on_create_new_organization() {
	    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	}
	@When("enter organization name {string} and email {string} and phone number {int}")
	public void enter_organization_name_and_email_and_phone_number(String orgName, String email, Integer phNo) {
	    int random=new Random().nextInt(1000);
	    driver.findElement(By.name("accountname")).sendKeys(orgName+"_"+random);
	    driver.findElement(By.id("phone")).sendKeys(phNo+"");
	    driver.findElement(By.id("email1")).sendKeys(email);
	}
	@When("click on save")
	public void click_on_save() {
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	@Then("validate organization {string} is created or not")
	public void validate_organization_is_created_or_not(String org) {
	  String orgname=  driver.findElement(By.id("dtlview_Organization Name")).getText();
	  Assert.assertTrue(orgname.contains(org), org+ " is not exist");
	  driver.close();
	}

}
