package org.example.testsuite;

import org.example.common.CommonBase;
import org.example.constant.CT_Account;
import org.example.page.LoginPage;
import org.example.page.Login_Factory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTest_Factory extends CommonBase {

    @BeforeMethod
    public void openChrome(){
        driver = initChromeDriver(CT_Account.RISE_URL);
    }
    @Test(priority =1)
    public void LoginSuccess(){
        Login_Factory login = new Login_Factory(driver);
        login.LoginFunction("client@demo.com","riseDemo");
        assertTrue(driver.findElement(CT_Account.DASHBOARD).isDisplayed());
    }
    @Test(priority = 2)
    public void LoginFail(){
        Login_Factory login = new Login_Factory(driver);
        login.LoginFunction("client@demo.com","rise");
//        assertTrue(driver.findElement(CT_Account.DASHBOARD).isDisplayed());
        assertFalse(isElementPresent(CT_Account.DASHBOARD));
    }
    @Test(priority = 3)
    public void LoginFailnullPass(){
        Login_Factory login = new Login_Factory(driver);
        login.LoginFunction("lient@demo.com","sdasadsad");
        assertTrue(driver.findElement(CT_Account.AUTHEN_FAIL).isDisplayed());
    }
    @Test(priority = 4)
    public void Logout(){
        Login_Factory login = new Login_Factory(driver);
        login.LoginFunction("client@demo.com","riseDemo");
        login.LogoutFunction();
    }
}
