Feature: Android to Admin
  There are test cases for scenario : android to Admin

 	Background: Create new user for all test cases
    Given Create new user
    
  Scenario: Verify that Sign Up form fields are filled in with valid entries and user has been created in Admin
    Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign Up
    And Fill in register username and password on android
    When Tap on the Sign UP button
    Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the register user 
    Then There is registered user in the table

	Scenario: Admin is able to identify which PLATFORM User was registered on
	 Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign Up
    And Fill in register username and password on android
    When Tap on the Sign UP button
    Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the register user 
    And Go to user details > General Information
    Then Verify 'Registered on' field should be populated with correct flatform code
    
	Scenario: Admin is able to identify which PLATFORM User was registered on
	  Given Launch Zinio app
    And Change newsstand to "USA" Store
		And Tap on Account > User Profile > Sign In > Sign Up
    And Fill in register username and password on android
    When Tap on the Sign UP button
    Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the register user 
    And Go to user details > General Information
    Then Verify 'Registered on' field should be populated with correct country
    
    Scenario: User signs up via Facebook and has been created in Admin
	  Given Launch Zinio app
		And Tap on Account > User Profile > Continue With Facebook
		When Fill in facebook account
    Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the facebook account
    And Go to user details > General Information
    Then Verify 'Registered on' field should be populated with facebook account
    
    Scenario: Purchase a Single Issue with Sign In and verify that entitlement and order appears in Admin
    Given Launch Zinio app
    And Tap on Shop
    And Search out any magazine on android app
    When Tap on Buy Issue button
    Then Verify that A Sign Into Zinio screen should appear
    And Login with existed username and password on android
    When Tap on Buy Issue button
    Then Verify that the Payment Information screen should appear
    When Input correct credentials and proceed the payment
    Then Verify that Thank You Page should appear
  	 	Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the created user 
    And Go to user details > General Information
    And Click on Entitlements tab
    Then In Entitlements tab, there is an entitlements record about the order that user has just purchased
    
    Scenario: Purchase a Single Issue with Sign Up and verify that entitlement and order appears in Admin
    Given Launch Zinio app
    And Tap on Shop
    And Search out any magazine on android app
    When Tap on Buy Issue button
    Then Verify that A Sign Into Zinio screen should appear
    And Sign up a new account
    When Tap on Buy Issue button
    Then Verify that the Payment Information screen should appear
    When Input correct credentials and proceed the payment
    Then Verify that Thank You Page should appear
  	 	Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the register user
    And Go to user details > General Information
    And Click on Entitlements tab
    Then In Entitlements tab, there is an entitlements record about the order that user has just purchased
    
    Scenario: Purchase a Single Issue with an already logged in user and verify that entitlement and order appears in Admin
    Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign In
    And Login with existed username and password on android
    And Search out any magazine on android app
    When Tap on Buy Issue button
    Then Verify that the Payment Information screen should appear
    When Input correct credentials and proceed the payment
    Then Verify that Thank You Page should appear
  	 	Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the created user
    And Go to user details > General Information
    And Click on Entitlements tab
    Then In Entitlements tab, there is an entitlements record about the order that user has just purchased
    
     Scenario: Purchase a Subscription with Sign In and verify that entitlement, order and subscription appears in Admin
    Given Launch Zinio app
    And Search out any magazine on android app
    When Tap on Subscribe button
    Then Verify that A Sign Into Zinio screen should appear
    And Login with existed username and password on android
    When Tap on Subscribe button
    And Tap on confirm Subscribe button
    Then Verify that the Payment Information screen should appear
    When Input correct credentials and proceed the payment
    Then Verify that Thank You Page should appear
    	Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the created user
    And Go to user details > General Information
    And Click on Entitlements tab
    Then In Entitlements tab, there is an entitlements record about the order that user has just purchased
    And Click on Issue Subscriptions tab
		Then In Issue Subscriptions tab, there is an subscription record about the order that user has just purchased
		
		Scenario: Purchase a Subscription with Sign Up and verify that entitlement, order and subscription appears in Admin
    Given Launch Zinio app
    And Search out any magazine on android app
    When Tap on Subscribe button
    Then Verify that A Sign Into Zinio screen should appear
    And Sign up a new account
    When Tap on Subscribe button
    And Tap on confirm Subscribe button
    Then Verify that the Payment Information screen should appear
    When Input correct credentials and proceed the payment
    Then Verify that Thank You Page should appear
    	Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the register user
    And Go to user details > General Information
    And Click on Entitlements tab
    Then In Entitlements tab, there is an entitlements record about the order that user has just purchased
    And Click on Issue Subscriptions tab
		Then In Issue Subscriptions tab, there is an subscription record about the order that user has just purchased
		
		Scenario: Purchase a Subscription with an already logged in user and verify that entitlement, order and subscription appears in Admin
    Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign In
    And Login with existed username and password on android
    And Search out any magazine on android app
    When Tap on Subscribe button
    And Tap on confirm Subscribe button
    Then Verify that the Payment Information screen should appear
    When Input correct credentials and proceed the payment
    Then Verify that Thank You Page should appear
    	Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the created user
    And Go to user details > General Information
    And Click on Entitlements tab
    Then In Entitlements tab, there is an entitlements record about the order that user has just purchased
    And Click on Issue Subscriptions tab
		Then In Issue Subscriptions tab, there is an subscription record about the order that user has just purchased
		
		Scenario: User add payment method from Settings Menu and verify that user payment profile was created in Braintree
		Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign In
    And Login with existed username and password on android
    And Tap on Payment Information tab in Settings menu
    And Tap on the 'Add Payment Method' button
    Then Complete the form with correct values and Hit 'Save' button
    	Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the created user
    And Go to user details > General Information
    And Go to user Payment Profile tab 
    Then Verify Payment Profile info as credit card info
    
    Scenario: User add payment method from Single Issue Purchase and verify that user payment profile was created in Braintree
    Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign In
    And Login with existed username and password on android
    And Search out any magazine on android app
    When Tap on Buy Issue button
    When Complete the form with correct values and Hit 'Save' button
		Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the created user
    And Go to user details > General Information
    And Go to user Payment Profile tab 
    Then Verify Payment Profile info as credit card info
    
    Scenario: User add payment method from Subscription Purchase and verify that user payment profile was created in Braintree
    Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign In
    And Login with existed username and password on android
    And Search out any magazine on android app
    When Tap on Subscribe button
    And Tap on confirm Subscribe button
    When Complete the form with correct values and Hit 'Save' button
		Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the created user
    And Go to user details > General Information
    And Go to user Payment Profile tab 
    Then Verify Payment Profile info as credit card info