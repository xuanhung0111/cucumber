$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/Users/xuanhung.nguyen/git/qa/zinio-automation/e2eAutomationTest/src/test/resources/features/web_to_admin/registerNewUser.feature");
formatter.feature({
  "line": 1,
  "name": "E2E_WWW -\u003e Admin",
  "description": "This is title of Demo",
  "id": "e2e-www--\u003e-admin",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1883333193,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Verify successfully created Account will be shown in Admin",
  "description": "",
  "id": "e2e-www--\u003e-admin;verify-successfully-created-account-will-be-shown-in-admin",
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
        "zinio_e2e02@zinio.com",
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
        "zinio_e2e02@zinio.com",
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
  "duration": 8926271020,
  "status": "passed"
});
formatter.match({
  "location": "FunctionalTest.fill_in_user_name_and_password_as_info_below(DataTable)"
});
formatter.result({
  "duration": 969028027,
  "status": "passed"
});
formatter.match({
  "location": "FunctionalTest.verify_that_user_is_displayed_in_Zenith_Admin_successfully_on_Users_Landing_page(DataTable)"
});
formatter.result({
  "duration": 18311263022,
  "status": "passed"
});
formatter.after({
  "duration": 897949,
  "status": "passed"
});
formatter.before({
  "duration": 1385644836,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Verify that user can login with valid account successful",
  "description": "",
  "id": "e2e-www--\u003e-admin;verify-that-user-can-login-with-valid-account-successful",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "Access zinio page",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "Fill in valid user name",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "Fill in valid password",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Verify that user login successful",
  "keyword": "Then "
});
formatter.match({
  "location": "FunctionalTest.access_zinio_page()"
});
formatter.result({
  "duration": 11524990107,
  "status": "passed"
});
formatter.match({
  "location": "FunctionalTest.fill_in_valid_name()"
});
formatter.result({
  "duration": 15092421873,
  "error_message": "org.openqa.selenium.NoSuchElementException: Timed out after 5 seconds. Element not found\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.4.0\u0027, revision: \u0027unknown\u0027, time: \u0027unknown\u0027\nSystem info: host: \u0027C02QT908G8WN.local\u0027, ip: \u0027fe80:0:0:0:8d8:bc61:2ec:567c%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.12.6\u0027, java.version: \u00279.0.1\u0027\nDriver info: driver.version: unknown\n\tat net.thucydides.core.annotations.locators.SmartAjaxElementLocator.ajaxFindElement(SmartAjaxElementLocator.java:151)\n\tat net.thucydides.core.annotations.locators.SmartAjaxElementLocator.findElement(SmartAjaxElementLocator.java:103)\n\tat net.serenitybdd.core.pages.WebElementResolverByElementLocator.resolveForDriver(WebElementResolverByElementLocator.java:27)\n\tat net.serenitybdd.core.pages.WebElementFacadeImpl.getElement(WebElementFacadeImpl.java:173)\n\tat net.serenitybdd.core.pages.WebElementFacadeImpl.withTimeoutOf(WebElementFacadeImpl.java:309)\n\tat net.serenitybdd.core.pages.WebElementFacadeImpl.waitUntilElementAvailable(WebElementFacadeImpl.java:707)\n\tat net.serenitybdd.core.pages.WebElementFacadeImpl.click(WebElementFacadeImpl.java:946)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:564)\n\tat net.thucydides.core.annotations.locators.AbstractSingleItemHandler.invoke(AbstractSingleItemHandler.java:45)\n\tat com.sun.proxy.$Proxy29.click(Unknown Source)\n\tat com.zinio.web.pages.SignInPage.click_signin_bt(SignInPage.java:80)\n\tat com.zinio.web.testcase.FunctionalTest.fill_in_valid_name(FunctionalTest.java:80)\n\tat ✽.When Fill in valid user name(/Users/xuanhung.nguyen/git/qa/zinio-automation/e2eAutomationTest/src/test/resources/features/web_to_admin/registerNewUser.feature:15)\n",
  "status": "failed"
});
formatter.match({
  "location": "FunctionalTest.fill_in_valid_password()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "FunctionalTest.verify_user_loggin()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 528510,
  "status": "passed"
});
formatter.before({
  "duration": 1469649411,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Demo test report failure",
  "description": "",
  "id": "e2e-www--\u003e-admin;demo-test-report-failure",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "This is first step",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "This is second step",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "This is third step",
  "keyword": "Then "
});
formatter.match({
  "location": "FunctionalTest.step_1()"
});
formatter.result({
  "duration": 75776,
  "status": "passed"
});
formatter.match({
  "location": "FunctionalTest.step_2()"
});
formatter.result({
  "duration": 462016,
  "error_message": "junit.framework.AssertionFailedError: Compare miss matches\n\tat junit.framework.Assert.fail(Assert.java:57)\n\tat junit.framework.Assert.assertTrue(Assert.java:22)\n\tat com.zinio.web.testcase.FunctionalTest.step_2(FunctionalTest.java:104)\n\tat ✽.When This is second step(/Users/xuanhung.nguyen/git/qa/zinio-automation/e2eAutomationTest/src/test/resources/features/web_to_admin/registerNewUser.feature:21)\n",
  "status": "failed"
});
formatter.match({
  "location": "FunctionalTest.step_3()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 401662,
  "status": "passed"
});
formatter.before({
  "duration": 1442388620,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Demo test report pass",
  "description": "",
  "id": "e2e-www--\u003e-admin;demo-test-report-pass",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "This is first step pass",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "This is second step pass",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "This is third step pass",
  "keyword": "Then "
});
formatter.match({
  "location": "FunctionalTest.step_4()"
});
formatter.result({
  "duration": 37436,
  "status": "passed"
});
formatter.match({
  "location": "FunctionalTest.step_5()"
});
formatter.result({
  "duration": 44540,
  "status": "passed"
});
formatter.match({
  "location": "FunctionalTest.step_6()"
});
formatter.result({
  "duration": 72865,
  "status": "passed"
});
formatter.after({
  "duration": 425401,
  "status": "passed"
});
});