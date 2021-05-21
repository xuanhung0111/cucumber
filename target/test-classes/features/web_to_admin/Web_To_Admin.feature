Feature: E2E_WWW -> Admin
  There are test cases for scenario : web to admin feature

  Scenario: Verify successfully created Account will be shown in Admin
    Given Access Zinio Sign-Up Page
    When Fill in user name and password as info below then click Sign Up button
      | Email                        | Password  |
      | zinio_test+demo014@zinio.com | 123456789 |
    Then Verify that user is created in Zenith Admin successfully on Users Landing page
      | Email                        | ID                  | Directory ID | Gender  | Status |
      | zinio_test+demo014@zinio.com | 1685264636313600011 |            3 | Unknown | Enable |

  Scenario: Verify user still be able to use the old pass to sign in client apps after changed e-mail on Admin
    Given Go to Zenith Admin page
    And Login by Zinio Staff account
    And Go to Users landing page
    And Search out user by email "zinio_test+demo011@zinio.com"
    And Go to user details > General Information
    And Change email to "newzinio_test+demo011@zinio.com"
    And Click on Save
    Then Ensure user CANNOT sign in successfully
      | Email                        | Password  |
      | zinio_test+demo011@zinio.com | 123456789 |
    And Ensure user can sign in successfully
      | Email                           | Password  |
      | newzinio_test+demo011@zinio.com | 123456789 |

  Scenario: Verify user has status DISABLED is not able to sign in all client apps
    Given Go to Zenith Admin page
    And Login by Zinio Staff account
    And Go to Users landing page
    And Search out user by email "zinio_test+demo012@zinio.com"
    And Go to user details > General Information
    And Change Status to "Disabled"
    And Click on Save
    Then Ensure user CANNOT sign in successfully
      | Email                        | Password  |
      | zinio_test+demo012@zinio.com | 123456789 |

  Scenario: Verify after user has status MERGED is not able to sign in all client apps
  Given Go to Zenith Admin page
  And Login by Zinio Staff account
  And Go to Users landing page
  And Search out user by email "merge_user02@zinio.com"
  And Go to user details > General Information
  And Click on Merge button to proceed to MERGE INTO user as email "merge_user03@zinio.com"
  Then Ensure user CANNOT sign in successfully
  | Email                    | Password  |
  | merge_user02@zinio.com | 123456789 |
  
  Scenario: C39412_Verify successfully purchased Subscription will be shown in Admin (buy with Credit/ Debit Card)
    Given Access Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Fill in username and password as bellow
      | User Name                        | Password     |
      | xuanhung.nguyen+001252@zinio.com | zinioTest123 |
    When Search out magazine "Us Weekly"
    And Click to view "Us Weekly" publication
    And Click on only SUBSCRIBE button
    And Click on CHECKOUT button
    And On Payment check out page, add credit card information
    Then Click on Complete Purchase button to purchase
    And Verify that A Thankyou page is displayed with Order ID
    Given Go to Zenith Admin page
    And Login by Zinio Staff account
    And Go to Users landing page
    And Search out user by email "xuanhung.nguyen+001252@zinio.com"
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
    Then Verify that Order info is displayed correctly

  Scenario: C39429_Verify updated "Not allow adult content" value will be shown in Admin
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Fill in username and password as bellow
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Account Settings > Preferences
    When Check not allow show adult content while browsing Zinio then click on Save
    Given Go to Zenith Admin page
    And Login by Zinio Staff account
    And Go to Users landing page
    And Search out user by email "xuanhung.nguyen+li1@zinio.com"
    And Go to user details > Preferences, select project is "Zinio Newsstand"
    Then Verify option allow showing adult content is selected
    And Go back to WWW side
    Then Verify the magazine "The Girls of Penthouse" should NOT display when searching by keyword as below:
      | Key search   | Expected Issue           |
      | Playboy      | Playboy Portugal         |
      | Boy          | Playboy Portugal         |
      | Playboy plus | Playboy Interactive Plus |
    Then Verify category "Adult" is disappeared in shop menu
