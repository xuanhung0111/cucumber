package com.zinio.admin.page.methods;

import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.zinio.admin.ui.LoginPageObject;

import com.zinio.web.utilities.Logging;

public class LoginAdminPage {

	WebDriver driver;
	public String parentWindow, currentWindow;
	LoginPageObject loginPageObject;

	public LoginAdminPage(WebDriver driver) {
		this.driver = driver;
		loginPageObject = new LoginPageObject(this.driver);
	}

	public void login(String username, String password) {
		loginPageObject.userNameTextBox.setText(username);
		loginPageObject.passwordTextBox.setText(password);
		loginPageObject.submitButton.click();
	}
	
	public String loginWithAPI(String email, String password){
		Logging.info("Login with [" + email + "]");

        Map<String,String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        String access_token =
                given()
                        .contentType("application/json")
                        .body(params).
                when()
                        .post("http://dev-be.zen-admin-dev.xen.int/v1/identity/authentication").
                then()
                        .statusCode(200).extract().path("data.access_token");
        Logging.info("Access Token assigned : [" + access_token + "]");
        return access_token;
    }

    public void checkResetPasswordForm() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        parentWindow = tabs.get(0);
        currentWindow = tabs.get(tabs.size()-1);

        driver.switchTo().window(currentWindow);

        loginPageObject.loginTitle.shouldHaveText("");
        loginPageObject.passwordTextBox.shouldBeBlank();
        loginPageObject.confirmPasswordTextbox.shouldBeBlank();
        loginPageObject.createPasswordButton.shouldBeDisabled();
    }

}
