package com.demowebshop.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Register")
	private WebElement registerLink;
	
	@FindBy(linkText = "Log in")
	private WebElement loginLink;
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingCartLink;
	
	@FindBy(xpath = "//span[text()='Wishlist']")
	private WebElement wishListLink;
	
	@FindBy(xpath="//ul[@class='top-menu']/descendant::a[contains(text(),'Computers')]")
	private WebElement computers;
	
	@FindBy(xpath="//ul[@class='top-menu']/descendant::a[contains(text(),'Desktops')]")
	private WebElement desktops;
	
	@FindBy(xpath="//span[@class='price actual-price']")
	private List<WebElement> prices;

	
	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}

	public WebElement getWishListLink() {
		return wishListLink;
	}

	public WebElement getComputers() {
		return computers;
	}

	public WebElement getDesktops() {
		return desktops;
	}

	public List<WebElement> getPrices() {
		return prices;
	}
	
	public void clickOnRegistration() {
		registerLink.click();
		
	}
	
	public void clickOnLogin() {
		getLoginLink().click();
	}
	
	public void clickOnShippingCart() {
		getShoppingCartLink().click();
	}
	
	public void clickOnWishList() {
		getWishListLink().click();
	}
	
	public void clickOnDesktop() {
		mouseHoverAndClick(driver, getComputers(), getDesktops());
	}
	
	

}
