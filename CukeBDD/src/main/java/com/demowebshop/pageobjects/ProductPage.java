package com.demowebshop.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@value='Add to cart']")
	private List<WebElement> addTocartButton;

	@FindBy(id="add-to-cart-button-72")
	private WebElement shippingAddToCart;
	
	public List<WebElement> getAddTocartButton() {
		return addTocartButton;
	}
	
	public WebElement getShippingAddToCart() {
		return shippingAddToCart;
	}

	public void clickOnAddToCart() {
		getAddTocartButton().get(0).click();
	}
	public void clickOnshippingCart() {
		getShippingAddToCart().click();
	}
}
