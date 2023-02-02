Feature: Data driven testing

@End2End
  Scenario Outline: As valid user I want to create multiple organization
    Given I will launch browser "chrome"
    And I will enter the url "http://localhost:8888/"
    And enter username "admin" and password "manager"
    And click on login
    When login page is dispalyed I will click on organization link
    And In organization click on create new organization
    And enter organization name "<organization name>" and email "<email>" and phone number <phNo>
    And click on save
    Then validate organization "<organization name>" is created or not

    Examples: 
      | organization name | email              | phNo   |
      | Test Yantra       | www.testyantra.com |  12345 |
      | Google            | www.google.com     | 123456 |
      | Amazon            | www.amazon.in      |  45678 |
