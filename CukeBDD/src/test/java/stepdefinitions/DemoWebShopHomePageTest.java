package stepdefinitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Base;

public class DemoWebShopHomePageTest extends Base{
	
	public Base base;
	
	public DemoWebShopHomePageTest(Base base) {
		this.base = base;
	}
	@Given("browser already opened and I will enter the url")
	public void browser_already_opened_and_i_will_enter_the_url() throws Throwable {
		
	   String url=base.fileReader.getValueProperty("url");
	   base.driver.get(url);
	}
	List<WebElement> products;
	@When("Home page is dispayed I want capture all the product Names")
	public void home_page_is_dispayed_i_want_capture_all_the_product_names() {
	 products
	 = base.driver.findElements(By.xpath("//div[@class='item-box']/descendant::h2[@class='product-title']")); 
	Iterator<WebElement> itr = products.iterator();
	while(itr.hasNext()) {
		System.out.println(itr.next().getText());
	}
	}
	@Then("Print the count of thr product")
	public void print_the_count_of_thr_product() {
	    System.out.println("Total number of product in Home page: "+products.size());
	    Assert.fail();
	}

	@When("Home page is displayed mouse hover on computer and click on desktop")
	public void home_page_is_displayed_mouse_hover_on_computer_and_click_on_desktop() {
	  WebElement computer= base.driver.findElement(By.xpath("//ul[@class='top-menu']/descendant::a[contains(text(),'Computers')]"));
	 WebElement desktops= base.driver.findElement(By.xpath("//ul[@class='top-menu']/descendant::a[contains(text(),'Desktops')]"));
	 Actions action=new Actions(base.driver);
	 action.moveToElement(computer).click(desktops).build().perform();
	}
	@Then("sort the computers price low to high")
	public void sort_the_computers_price_low_to_high() {
	   //first capture all the price
		List<WebElement> prices=base.driver.findElements(By.xpath("//span[@class='price actual-price']"));
		ArrayList<Double> beforeSortPrice=new ArrayList<Double>();
		for(WebElement pr:prices) {
			beforeSortPrice.add(Double.parseDouble(pr.getText()));
		}
		WebElement sortOption=base.driver.findElement(By.id("products-orderby"));
		Select select=new Select(sortOption);
		select.selectByVisibleText("Price: Low to High");
		
		ArrayList<Double> afterSortPrice=new ArrayList<Double>();
		for(WebElement pr:prices) {
			afterSortPrice.add(Double.parseDouble(pr.getText()));
		}
		Collections.sort(beforeSortPrice);//sorted in ascending order
		Assert.assertEquals(beforeSortPrice, afterSortPrice,"Prices were not sorted");
		//sort
		// sort the computer in webpage
		
		//capture all the price
		//validate
	}
	@Then("sort the computer price high to low")
	public void sort_the_computer_price_high_to_low() {
		List<WebElement> prices=base.driver.findElements(By.xpath("//span[@class='price actual-price']"));
		ArrayList<Double> beforeSortPrice=new ArrayList<Double>();
		for(WebElement pr:prices) {
			beforeSortPrice.add(Double.parseDouble(pr.getText()));
		}
		WebElement sortOption=base.driver.findElement(By.id("products-orderby"));
		Select select=new Select(sortOption);
		select.selectByVisibleText("Price: High to Low");
		
		ArrayList<Double> afterSortPrice=new ArrayList<Double>();
		for(WebElement pr:prices) {
			afterSortPrice.add(Double.parseDouble(pr.getText()));
		}
		Collections.sort(beforeSortPrice, Collections.reverseOrder());//sorted in ascending order
		Assert.assertEquals(beforeSortPrice, afterSortPrice,"Prices were not sorted");	}
}
