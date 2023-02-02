Feature: Demo WebShop Home page 
	 user can search for a product, login and also registration
	Background: 
	Given browser already opened and I will enter the url
	
	#@SmokeTest
	Scenario: User can able view all the products in Home page
	When Home page is dispayed I want capture all the product Names
	Then Print the count of thr product
	
	##Scenario: As a user I will search for computer and I will sort the product based on price
	##When Home page is displayed mouse hover on computer and click on desktop
	##Then sort the computers price low to high 
	##And sort the computer price high to low