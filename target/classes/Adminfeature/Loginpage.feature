Feature: AdminPageFeature

Scenario: checks for AdminLogin page title
Given User is on AdminLogin page
When User gets the Page Title
Then Page title should be "Smart Hospital : Hospital Management System"


Scenario: checks for avaliability of Forgot Password Link
Given User is on AdminLogin page
Then Forget password link should be displayed

Scenario: Login valid cerdentials

Given User is on AdminLogin page
When User Enters the username "triotend@gmail.com" 
And  User Enters the password "triotend"
And User click on signin button
Then User get the admin dashboard page title
And The page title should be "Smart Hospital Management System"