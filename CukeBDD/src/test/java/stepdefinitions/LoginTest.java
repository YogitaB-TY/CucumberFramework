package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	@Given("I will launch browser")
	public void i_will_launch_browser() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("Enter the url")
	public void enter_the_url() {
	    driver.get("http://automationpractice.com/index.php");
	}

	@When("home page is displayed I will click on sign in")
	public void home_page_is_displayed_i_will_click_on_sign_in() {
	    driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
	}

	@When("enter email and password")
	public void enter_email_and_password() {
	    driver.findElement(By.id("email")).sendKeys("nitheshdemo@gmail.com");
	    driver.findElement(By.id("passwd")).sendKeys("nithesh1998");
	}

	@When("click on sign in")
	public void click_on_sign_in() {
	    driver.findElement(By.id("SubmitLogin")).click();
	}

	@Then("User name should be displayed or not")
	public void user_name_should_be_displayed_or_not() {
	   String username= driver.findElement(By.xpath("//a[@title='View my customer account']")).getText();
	   Assert.assertEquals(username, "Nithesh H",username+" is not matching");
	   driver.close();
	}
	
	@When("enter invalid email {string} and invalid password {string}")
	public void enter_invalid_email_and_invalid_password(String email, String password) {
		 driver.findElement(By.id("email")).sendKeys(email);
		    driver.findElement(By.id("passwd")).sendKeys(password);
	}
	@Then("error message should be displayed {string}")
	public void error_message_should_be_displayed(String error) {
	  String errorMsg =  driver.findElement(By.xpath("//div[@class='alert alert-danger']/descendant::li[text()]")).getText();
	  Assert.assertEquals(errorMsg, error);
	  driver.close();
	}
	
	@When("click on signIn")
	public void click_on_sign_in1() {
		driver.findElement(By.id("SubmitLogin")).click();
	}
	@Then("I should get Error message {string}")
	public void i_should_get_error_message(String expectedErrorMsg) {
	   String actualError= driver.findElement(By.xpath("//div[@class='alert alert-danger']/descendant::li")).getText();
	   Assert.assertEquals(actualError, expectedErrorMsg," Error msg not matching");
	}

}
