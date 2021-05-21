Feature: E2E_Mobile_Android -> WWW
  There are test cases for E2E_Mobile_Android -> WWW

  Background: Create new user for all test cases
    Given Create new user

  Scenario: Verify that Sign Up form fields are filled in with valid entries and user can Sign In in WWW
    Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign Up
    And Fill in register username and password on android
    When Tap on the Sign UP button
    Given Go to Zinio Home page
    And Open login modal
    And Login with register username and password on web
    Then Verify register user can login successfully

  Scenario: Verify the positive scenario to Change Password and that the user can not Sign In in WWW with the old password
    Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign In
    And Login with existed username and password on android
    And Access Change Password screen
    And Change account user password on android
    Given Go to Zinio Home page
    And Open login modal
    And Login with existed username and password on web
    Then Verify user cannot login successfully
    And Fill in changed password user on web
    Then Verify user can login successfully
    And Reset default password for user on android

  Scenario: T193115_Purchase a Single Issue with Sign In and verify that entitlement appears in WWW user Library
    Given Launch Zinio app
    And Tap on Shop
    And Tap on issue cover
    When Tap on Buy Issue button
    Then Verify that A Sign Into Zinio screen should appear
    And Login with existed username and password on android
    When Tap on Buy Issue button
    Then Verify that the Payment Information screen should appear
    When Input correct credentials and proceed the payment
    Then Verify that Thank You Page should appear
    Given Go to Zinio Home page
    And Open login modal
    And Fill in correct credentials username and password
    And Go to Library page
    Then Ensure that there is an issues in Library

  Scenario: T193116_Purchase a Single Issue with Sign Up and verify that entitlement appears in WWW user Library
    Given Launch Zinio app
    And Tap on Shop
    And Tap on issue cover
    When Tap on Buy Issue button
    Then Verify that A Sign Into Zinio screen should appear
    And Sign up a new account
    When Tap on Buy Issue button
    Then Verify that the Payment Information screen should appear
    When Input correct credentials and proceed the payment
    Then Verify that Thank You Page should appear
    Given Go to Zinio Home page
    And Open login modal
    And Login correct credentials NEW username and password
    And Go to Library page
    Then Ensure that there is an issues in Library

  Scenario: T193117_Purchase a Single Issue with an already logged in user and verify that entitlement appears in WWW user Library
    Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign In
    And Login with existed username and password on android
    And Tap on Shop
    And Tap on issue cover
    When Tap on Buy Issue button
    Then Verify that the Payment Information screen should appear
    When Input correct credentials and proceed the payment
    Then Verify that Thank You Page should appear
    Given Go to Zinio Home page
    And Open login modal
    And Fill in correct credentials username and password
    And Go to Library page
    Then Ensure that there is an issues in Library

  Scenario: T193118_Purchase a Subscription with Sign In and verify that Subscription entitlements appears in WWW
    Given Launch Zinio app
    And Tap on Shop
    And Tap on subcrition cover
    When Tap on Subscribe button
    Then Verify that A Sign Into Zinio screen should appear
    And Login with existed username and password on android
    When Tap on Subscribe button
    And Tap on confirm Subscribe button
    Then Verify that the Payment Information screen should appear
    When Input correct credentials and proceed the payment
    Then Verify that Thank You Page should appear
    Given Go to Zinio Home page
    And Open login modal
    And Fill in correct credentials username and password
    And Go to Library page
    Then Ensure that there is an subcribe in Library

  Scenario: T193119_Purchase a Subscription with Sign Up and verify that Subscription entitlements appears in WWW
    Given Launch Zinio app
    And Tap on Shop
    And Tap on subcrition cover
    When Tap on Subscribe button
    Then Verify that A Sign Into Zinio screen should appear
    And Sign up a new account
    When Tap on Subscribe button
    And Tap on confirm Subscribe button
    Then Verify that the Payment Information screen should appear
    When Input correct credentials and proceed the payment
    Then Verify that Thank You Page should appear
    Given Go to Zinio Home page
    And Open login modal
    And Login correct credentials NEW username and password
    And Go to Library page
    Then Ensure that there is an subcribe in Library

  Scenario: T193120_Purchase a Subscription with an already logged in user and verify that Subscription entitlements appears in WWW
    Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign In
    And Login with existed username and password on android
    And Tap on Shop
    And Tap on subcrition cover
    When Tap on Subscribe button
    And Tap on confirm Subscribe button
    Then Verify that the Payment Information screen should appear
    When Input correct credentials and proceed the payment
    Then Verify that Thank You Page should appear
    Given Go to Zinio Home page
    And Open login modal
    And Fill in correct credentials username and password
    And Go to Library page
    Then Ensure that there is an subcribe in Library

  Scenario: Verify the user of Library in other platforms syncs with Android per an existing account
    Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign In
    And Login with existed username and password on android
    And Tap on Shop
    And Tap on subcrition cover
    When Tap on Subscribe button
    And Tap on confirm Subscribe button
    Then Verify that the Payment Information screen should appear
    When Input correct credentials and proceed the payment
    Then Verify that Thank You Page should appear
    And Tap on Account
    And Tab on Subscriptions tab
    Then Verify that subcription is shown in Subscriptions tab
    Given Go to Zinio Home page
    And Open login modal
    And Fill in correct credentials username and password
    And Go to Account Settings > Subscriptions
    Then Verify that that there is an active subscription in subscription tab

  Scenario: Verify display price is shown right in a newsstand has tax=0 when user has not signed in yet
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    When Search out any magazine
    And Click to view publication product page
    Then Get all information about price product
    Given Launch Zinio app
    And Change newsstand to "USA" Store
    And Search out any magazine on android app
    Then Verify product page displays price correctly on android app

  Scenario: Verify display price is shown right in a newsstand has tax=!0 when user has not signed in yet
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    When Search out any magazine
    And Click to view publication product page
    Then Get all information about price product
    Given Launch Zinio app
    And Change newsstand to "United Kingdom" Store
    And Search out any magazine on android app
    Then Verify product page displays price correctly on android app on different newsstand

  Scenario: User add payment method from Settings Menu and verifies info in WWW
    Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign In
    And Login with existed username and password on android
    And Tap on Payment Information tab in Settings menu
    And Tap on the 'Add Payment Method' button
    Then Complete the form with correct values and Hit 'Save' button
    Given Go to Zinio Home page
    And Open login modal
    And Fill in correct credentials username and password
    And Go to Account Settings > Payment Information
    Then Verify that payment info is shown correctly as it was set in Mobile

  Scenario: User add payment method from Subscription Purchase and verify info in WWW
    Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign In
    And Login with existed username and password on android
    And Tap on Shop
    And Tap on subcrition cover
    When Tap on Subscribe button
    And Tap on confirm Subscribe button
    When Complete the form with correct values and Hit 'Save' button
    Given Go to Zinio Home page
    And Open login modal
    And Fill in correct credentials username and password
    And Go to Account Settings > Payment Information
    Then Verify that payment info is shown correctly as it was set in Mobile

  Scenario: User add payment method from Single Issue Purchase and verifies info in WWW
    Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign In
    And Login with existed username and password on android
    And Tap on Shop
    And Tap on issue cover
    When Tap on Buy Issue button
    When Complete the form with correct values and Hit 'Save' button
    Given Go to Zinio Home page
    And Open login modal
    And Fill in correct credentials username and password
    And Go to Account Settings > Payment Information
    Then Verify that payment info is shown correctly as it was set in Mobile

  Scenario: Verify updated Credit Card in Payment Information page will be shown in Admin
    Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign In
    And Login with existed username and password on android
    And Tap on Payment Information tab in Settings menu
    And Tap on the 'Add Payment Method' button
    Then Complete the form with correct values and Hit 'Save' button
    Given Go to Zinio Home page
    And Open login modal
    And Fill in correct credentials username and password
    And Go to Account Settings > Payment Information
    Then Verify that payment info is shown correctly as it was set in Mobile
    When Edit Payment Information on Android then hit 'Save' button
    And Go to Account Settings > Payment Information
    Then Verify that payment info is updated correctly as it was set in Mobile

  Scenario: Update the payment method to Paypal and verify that the info appears in WWW
		Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign In
    And Login with existed username and password on android
    And Tap on Payment Information tab in Settings menu
    And Tap on the 'Add Payment Method' button
    Then Complete the form with paypal account and Hit 'Save' button
