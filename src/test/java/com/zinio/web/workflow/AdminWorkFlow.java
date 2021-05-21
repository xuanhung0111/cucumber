
package com.zinio.web.workflow;

import org.openqa.selenium.WebDriver;

import com.zinio.admin.pages.AdminLoginPage;
import com.zinio.admin.pages.AdminOrdersPage;
import com.zinio.admin.pages.AdminUsersPage;
import com.zinio.web.data.UserData;
import com.zinio.web.utilities.Logging;

public class AdminWorkFlow {
	
    private WebDriver driver;
    private AdminLoginPage adminLoginPage;
    private AdminUsersPage adminUsersPage;
    private AdminOrdersPage adminOrdersPage;

	public AdminWorkFlow(WebDriver driver) {
		this.driver = driver;
		adminLoginPage = new AdminLoginPage(this.driver);
		adminUsersPage = new AdminUsersPage(this.driver);
		adminOrdersPage = new AdminOrdersPage(this.driver);
	}
	
	public void loginZenithAdminPage ()
	{
		Logging.info("Login Zenith Admin Page");
		driver.get("https://sbx-admin.zinio.com");
		adminLoginPage.enterUserName(UserData.USER_EMAIL);
		adminLoginPage.enterPassWord(UserData.PASSWORD);
		adminLoginPage.clickOnSignInButton();
	}
	
	public void searchEmail(String userName)
	{
		adminUsersPage.clickOnUserTab();
		adminUsersPage.enterSearchEmail(userName);
	}
	
	public void searchOrdersId(String Id)
	{
		adminOrdersPage.goToOrdersMenu();
		adminOrdersPage.enterOrderId(Id);
	}
	
}
