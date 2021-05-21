Feature: WWW scenarion
  This feature will execute all test cases on WWW

  Scenario: Check load Home Page
    Given Go to Zinio Home page
    Then Verify that user can access Zinio Home Page successfully

  Scenario: Check load Shop All page
    Given Go to Shop All page
    Then Verify that user can access Shop All Page successfully

  Scenario Outline: Check load ShopOption page
    Given Access <Page> page
    Then Verify that user can redirect to <Header> Page successfully

    Examples: 
      | Page               | Header        |	
      | Top Sellers        | Top Sellers   |
      | Featured Magazines | Featured      |
      | News Weeklies      | News Weeklies |

  Scenario: Verify that user can create new account successfully
    Given Go to Zinio Home page
    And Open login modal
    And Click on the Create your ZINIO account
    And Fill in register username and password on web
    When Click on Sign Up button
    Then Verify user can create new account successfully
    And Log out

  Scenario: Verify that user can login with registered Zinio account and log out successfully
    Given Go to Zinio Home page
    And Open login modal
    And Login with existed username and password on web
    Then Verify user can login successfully
    And Log out

  Scenario: User can login with registered Facebook account and log out successfully
    Given Go to Zinio Home page
    And Open login modal
    And Click on Facebook button
    And Fill in username and password facebook as bellow
    When Click on Sign In Facebook Button
    Then Verify that user can login

  Scenario: Purchase Single Issue with Credit Card
    Given Go to Zinio Home page
    And Open login modal
    And Login with existed username and password on web
    And Go to newsstand "USA"
    And Go to a Category page "Sports"
    And Click to view "Slam" publication
    When Click on BUY ISSUE to add issue to cart
    And Click on CHECKOUT button
    And On Payment check out page, add credit card information
    Then Click on Complete Purchase button to purchase
    And On Thank you page, click on Start Reading button

  Scenario: Verify user is able to sign in/out properly with an existing account
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
    Then Ensure user "xuanhung.nguyen+2001" should sign in properly
    And Log out
    And Open login modal
    And Login with existed username and password on web
    Then Ensure user "xuanhung.nguyen+2001" should sign in properly
    And Log out

  #// This case need to disable 2-steps verification on gmail account
  Scenario: Verify user is able to reset password successfully for an existing account
  Given Go to Zinio Home page
  And Go to newsstand "USA"
  And Open login modal
  And Click on Forgot Password link
  And Fill in Enter your Email: "xuanhung.nguyen+2001@zinio.com"
  When Click on Reset Password button
  And Go to inbox of email
  And Open Reset password email
  And Go to Create New Password page through hyper-link in email
  And Fill in confirm password form and submit new password as below:
  | Password | Confirm password |
  | 12345678 |         12345678 |
  Then Sign in account with old password "12345678"
  Then Verify user can login successfully
  Then Sign in account with new password "1234567890"
  Then Verify user cannot login successfully
  Scenario: T186143_Verify all purchased issues include both single and subscription display in Library
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
    When Search out any magazine
    And Click to view "T3" publication
    And Proceed to purchase subscription
    When Search out any magazine
    And Click to view "T3" publication
    And Proceed to purchase single issue "December 2017"
    And Go to Library page
    Then Ensure that there are 2 issues in Library
    And Go to Account Settings > Subscriptions
    Then Ensure that there is an active subscription of "T3"

  Scenario: Verify all issues are grouped by Date
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    Then Verify all issues are grouped by Date

  Scenario: Verify all issues are grouped by Title
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Select Group by "Title A-Z"
    Then Verify all issues are grouped "Title A-Z"

  Scenario: Verify user is able to search out Adult content if checked allow show adult content while browsing Zinio
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Account Settings > Preferences
    When Check allow show adult content while browsing Zinio then click on Save
    Then Verify the magazine "Playboy Portugal" should display when searching by keyword as below:
      | Key search   | Expected Issue           |
      | Playboy      | Playboy Portugal         |
      | Boy          | Playboy Portugal         |
      | Playboy plus | Playboy Interactive Plus |
    Then Verify category "Adult" is displayed in shop menu

  Scenario: Verify user is NOT able to search out Adult content if checked allow show adult content while browsing Zinio
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Account Settings > Preferences
    When Check not allow show adult content while browsing Zinio then click on Save
    Then Verify the magazine "The Girls of Penthouse" should NOT display when searching by keyword as below:
      | Key search   | Expected Issue           |
      | Playboy      | Playboy Portugal         |
      | Boy          | Playboy Portugal         |
      | Playboy plus | Playboy Interactive Plus |
    Then Verify category "Adult" is disappeared in shop menu

  Scenario: T186392_Verify open an issue in reader
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    Then Verify that the issue is opened in reader

  Scenario: T186344_Verify reader layout
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    Then Verify reader layout

  Scenario: T18634_Verify tooltips on reader
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    Then Verify tooltip for each element on panel of reader page

  Scenario: T186346_Verify user can close the browser tab of the reader
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Close the browser tab of the reader
    Then Verify that the browser tab of the reader is closed successfully

  Scenario: T186324_Verify section list when click on table of content icon
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on the table of contents icon
    Then Verity that section list is shown

  Scenario: T186326_Verify section list layout
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on the table of contents icon
    Then Verify the layout of section list

  Scenario: T186327_Verify closing section list when click out side the panel
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on the table of contents icon
    And Click outside the section list panel
    Then Verify the section list is closed

  Scenario: T186328_Verify closing section list when click on the table of content icon again
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on the table of contents icon
    And Click on the table of contents icon
    Then Verify the section list is closed

  Scenario: T186330_Verify scrolling on the article list
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on the table of contents icon
    And Click on a section name on the section list
    Then Verify user can scroll up and down on the article list

  Scenario: T186331_Verify article list layout
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on the table of contents icon
    And Click on a section name on the section list
    Then Check the article list layout

  Scenario: T186339_Verify close Page Navigation list by clicking out side the list
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on the Page Navigation icon
    And Click outside the section list panel
    Then Verify Page Navigation list is closed

  Scenario: T186338_Verify close the Page Navigation list when click on the Page Navigation icon again
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on the Page Navigation icon
    And Click on the Page Navigation icon
    Then Verify Page Navigation list is closed

  Scenario: T186334_Verify closing article list when click out side the panel
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on the table of contents icon
    And Click on a section name on the section list
    And Click outside the section list panel
    Then The article list and section list are closed

  Scenario: T186343_Verify Page Navigation list is expanded when click on the > button
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on the Page Navigation icon
    And Click on the > at the right edge of the Page Navigation panel
    Then Verify Page Navigation list is expanded
    And Click on the < at the right edge of the Page Navigation panel
    Then Verify Page Navigation list is smaller

  Scenario: T186391_Verify the left arrow icon, right arrow icon will disappear after 5 seconds on inactivity on SVG mode
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click outside the section list panel
    And Click next page button
    Then Left arrow icon, right arrow icon will disappear after 5 seconds on inactivity

  Scenario: T186287_Verify Bookmarks list layout
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on Bookmarks icon
    Then Verify the layout of Bookmarks list

  Scenario: T186288_Verify Bookmark dialog
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on Bookmarks icon
    And Click add bookmark on the Bookmarks list
    Then Verify the bookmark dialog appears

  Scenario: T186289_Verify bookmark a spread
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on Bookmarks icon
    And Click add bookmark on the Bookmarks list
    And Add description for the bookmark
    And Click on Submit bookmark button
    Then Verify the bookmarked pages appear on the Bookmark list with correct thumbnail and description

  Scenario: TEST_PROCEDD_PURCHASING_Purchase Single Issue with Credit Card
    Given Go to Zinio Home page
    And Open login modal
    And Login with existed username and password on web
      | User Name              | Password   |
      | merge_user02@zinio.com | 1234567890 |
    And Go to newsstand "USA"
    And Go to a Category page "Sports"
    And Click to view "Slam" publication
    When Click on BUY ISSUE to add issue to cart
    And Click on CHECKOUT button
    And On Payment check out page, add credit card information
    Then Click on Complete Purchase button to purchase
    And On Thank you page, click on Start Reading button

  Scenario: T186290_Verify "add bookmark" link is hidden when left and right page of a spread are bookmarked
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on Bookmarks icon
    Then Verify that add bookmark link is shown
    And Click add bookmark on the Bookmarks list
    And Add description for the bookmark
    And Click on Submit bookmark button
    And Click outside the section list panel
    And Click next page button
    And Click on Bookmarks icon
    Then Verify that add bookmark link is shown
    And Click on Bookmarks icon
    And Click outside the section list panel
    And Click previous page button
    And Click on Bookmarks icon
    Then Verify that add bookmark link is NOT shown

  Scenario: T186294_Verify enter special character into bookmark description
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on Bookmarks icon
    And Click add bookmark on the Bookmarks list
    And Add description with special characters
    And Click on Submit bookmark button
    Then Verify the bookmarked page appears on the Bookmark list with correct description with special characters

  Scenario: T186295_Verify submit bookmark with blank description
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on Bookmarks icon
    And Click add bookmark on the Bookmarks list
    And Leave the description blank
    And Click on Submit bookmark button
    Then Verify the bookmarked page appears on the Bookmark list with blank description

  Scenario: T186297_Verify click Delete button on bookmark thumbnail on Bookmark list
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Click on Bookmarks icon
    And Click add bookmark on the Bookmarks list
    And Add description for the bookmark
    And Click on Submit bookmark button
    Then Verify the bookmarked pages appear on the Bookmark list with correct thumbnail and description
    When Click x button of any bookmark thumbnail
    Then Verify the bookmarked is removed

  Scenario: T186299_Verify delete all bookmarks on Bookmark list
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Library page
    When Mouse over on any issue to have the Read Issue with Eye icon appear and click on it
    And Add more bookmark pages
    And Remove all the bookmarked pages
    And Click on Bookmarks icon
    Then Verify the all bookmarked  pages are removed

  Scenario: Verify user is able to search out Adult content if checked allow show adult content while browsing Zinio
    Given Go to Zinio Home page
    And Go to newsstand "USA"
    And Open login modal
    And Login with existed username and password on web
      | User Name                     | Password   |
      | xuanhung.nguyen+li1@zinio.com | 1234567890 |
    And Go to Account Settings > Preferences

  Scenario: For my test only
    Given Step test one
    When Step test two
    Then Step test three

  Scenario: We are one team
    Given Zenith: Access Zenith Admin home page sau
    And Zenith: Open Users Landing page
    When Zenith: Search for the user that has just been created
