Feature: Login feature
  user can login to the app by entering the email and their password
  
  Background:
    Given  I will launch browser
  	And Enter the url
  	When home page is displayed I will click on sign in
  
  @SmokeTest @RegressionTest
  Scenario: As a valid user I will login to the app using valid credentials
  	 
  	When enter email and password
  	And click on sign in
  	Then User name should be displayed or not
  
  @RegressionTest	
  Scenario: As a user I will enter invalid credentials for login it should show error message
  	
  	When enter invalid email "yogita@gmail.com" and invalid password "abc"
  	And click on sign in
  	Then error message should be displayed "Invalid password."
  	
 @End2End
  Scenario: As a user I will not enter any username and password and I will click on login
  	
  	When click on signIn
  	Then I should get Error message "An email address required."
