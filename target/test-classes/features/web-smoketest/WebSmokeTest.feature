Feature: WWW Smoke Test scenarios
  This feature will execute all smoke test cases on WWW

  Scenario: Verify that user can create new account successfully
    Given Go to Zinio Home page
    And Open login modal
    And Click on the Create your ZINIO account
    And Fill in register username and password as bellow
      | User Name            | Password |
      | hai.ha+030@zinio.com | 12345678 |
    When Click on Sign Up button
    Then Verify user can create new account successfully
    And Log out
    Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the user "hai.ha+030@zinio.com"
    Then There is created user

  Scenario: Verify successfully purchased Issue will be shown in Admin (buy with Credit/ Debit Card)
    Given Go to Zinio Home page
    And Open login modal
    And Fill in username and password as bellow
      | User Name            | Password |
      | hai.ha+021@zinio.com | 12345678 |
    And Go to newsstand "USA"
    When Search out magazine "Us Weekly"
    And Click to view "Us Weekly" publication
    And Click on only SUBSCRIBE button
    And Click on CHECKOUT button
    And On Payment check out page, add credit card information
    Then Click on Complete Purchase button to purchase
    And Verify that A Thankyou page is displayed with Order ID
    Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the user "hai.ha+021@zinio.com"
    And Go to user details > General Information
    And Click on Orders tab
    Then In Orders tab, there is an order record about the order that user has just purchased
    And Click on Issue Subscriptions tab
    Then In Issue Subscriptions tab, there is an subscription record about the order that user has just purchased
    And Go to Orders page
    And Open Orders page and search for the order that user has just purchased
    And At Order detail, click on Payment tab to verify payment info
    Then Verify Payment info is displayed correctly as credit card info
    And At Order detail, click on Order Items tab to verify order detai
    Then Verify an order item is displayed and Order items are displayed one by one
    And At Order detail, click on General Information tab to verify order info

  Scenario: Verify updated Credit Card in Payment Information page will be shown in Admin
    Given Go to Zinio Home page
    And Open login modal
    And Fill in username and password as bellow
      | User Name                  | Password |
      | hai.ha+payment01@zinio.com | 12345678 |
    And Go to Account Settings > Payment Information
    And On Payment Information page, add credit card information
    Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the user "hai.ha+payment01@zinio.com"
    And Go to user details > Payment Profile
    Then Verify that payment information is displayed as default
    Given Go back Zinio page
    And On Payment Information page, edit credit card information
    Given Go back Admin page
    Then Verify that payment information is displayed after edited
    Given Go back Zinio page
    And On Payment Information page, delete credit card information
    Then User has no payment information
    Given Go back Admin page
    Then Verify that payment information is displayed after deleted

  Scenario: Verify user is able to change and save Email Preferences
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Fill in username and password as bellow
      | User Name       | Password   |
      | hung1@zinio.com | 1234567890 |
    And Go to Account Settings > Preferences
    When Check send me email updates then click on Save
    And Go to Account Settings > Preferences
    Then Verify send me email updates is checked
    Given From Admin side
    And Go to Zenith Admin page
    And Open Users Landing page
    When Search for the user "hung1@zinio.com"
    And Go to user details > Preferences, select project is "Zinio Newsstand"
    Then Verify that update email preferences is checked
    Given Go back Zinio page
    When Uncheck send me email updates then click on Save
    And Go to Account Settings > Preferences
    Then Verify send me email updates is unchecked
    Given Go back Admin page
    When Select project is "Zinio Newsstand"
    Then Verify that update email preferences is NOT checked

  Scenario: Verify that Sign Up form fields are filled in with valid entries and user can Sign In in WWW
    Given Launch Zinio app, tap on Account > User Profile > Sign In > Sign Up
    And Fill in register username and password android as bellow
      | User Name                           | Password   |
      | xuanhung.nguyen+android18@zinio.com | 1234567890 |
    When Tap on the Sign UP button
    Given Go to Zinio Home page
    And Open login modal
    And Fill in username and password as bellow
      | User Name                           | Password   |
      | xuanhung.nguyen+android18@zinio.com | 1234567890 |
    
    Scenario: Verify language mapping
     Given Go to Zinio Home page
     Then Change current language to "Svenska" and veriry that it is displayed correctly
     
     
