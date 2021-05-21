$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/Users/xuanhung.nguyen/git/qa/zinio-automation/e2eAutomationTest/src/test/resources/features/identity/WebAdmin.feature");
formatter.feature({
  "line": 1,
  "name": "E2E_WWW -\u003e Admin",
  "description": "This is web admin feature",
  "id": "e2e-www--\u003e-admin",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1866305908,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "[Create Account page] Verify successfully created Account will be shown in Admin",
  "description": "",
  "id": "e2e-www--\u003e-admin;[create-account-page]-verify-successfully-created-account-will-be-shown-in-admin",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Access Zinio Sign-Up Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Fill in user name and password as info below the click Sign Up button",
  "rows": [
    {
      "cells": [
        "Email",
        "Password"
      ],
      "line": 7
    },
    {
      "cells": [
        "zinio_ete002@zinio.com",
        "123456789"
      ],
      "line": 8
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Verify that user is created in Zenith Admin successfully on Users Landing page",
  "rows": [
    {
      "cells": [
        "Email",
        "ID",
        "Directory ID",
        "Gender",
        "Status"
      ],
      "line": 10
    },
    {
      "cells": [
        "zinio_ete002@zinio.com",
        "1685264636313600011",
        "3",
        "Unknown",
        "Enable"
      ],
      "line": 11
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "FunctionalTest.access_Zinio_Sign_Up_Page()"
});
formatter.result({
  "duration": 5894886477,
  "status": "passed"
});
formatter.match({
  "location": "FunctionalTest.fill_in_user_name_and_password_as_info_below(DataTable)"
});
formatter.result({
  "duration": 1031930206,
  "status": "passed"
});
formatter.match({
  "location": "FunctionalTest.verify_that_user_is_displayed_in_Zenith_Admin_successfully_on_Users_Landing_page(DataTable)"
});
formatter.result({
  "duration": 12968591845,
  "error_message": "java.lang.AssertionError: Can find created user in Zenith Admin Page expected [true] but found [false]\n\tat org.testng.Assert.fail(Assert.java:94)\n\tat org.testng.Assert.failNotEquals(Assert.java:513)\n\tat org.testng.Assert.assertTrue(Assert.java:42)\n\tat com.zinio.web.data.AssertResult.pass(AssertResult.java:16)\n\tat com.zinio.web.testcase.FunctionalTest.verify_that_user_is_displayed_in_Zenith_Admin_successfully_on_Users_Landing_page(FunctionalTest.java:65)\n\tat ✽.Then Verify that user is created in Zenith Admin successfully on Users Landing page(/Users/xuanhung.nguyen/git/qa/zinio-automation/e2eAutomationTest/src/test/resources/features/identity/WebAdmin.feature:9)\n",
  "status": "failed"
});
formatter.after({
  "duration": 373264,
  "status": "passed"
});
});