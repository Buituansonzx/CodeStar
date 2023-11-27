package org.example.testsuite;

import org.example.common.CommonBase;
import org.example.constant.CT_Account;
import org.example.page.Day13_homework;
import org.example.page.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Day13_btvn extends CommonBase {
    @BeforeMethod
    public void openChrome(){
        driver = initChromeDriver(CT_Account.BTVN_DAY13_URL);
    }
    @Test(priority = 1)
    public void LoginSuccessful(){
        Day13_homework login = new Day13_homework(driver);
        login.LoginFunction("student","Password123");
        assertTrue(driver.findElement(CT_Account.LOGIN_SUCESS).isDisplayed());
    }
    @Test(priority = 2)
    public void LoginFailIncorrectUsername(){
        Day13_homework login = new Day13_homework(driver);
        login.LoginFunction("student123","Password123");
        assertTrue(driver.findElement(CT_Account.ERROR_USERNAME).isDisplayed());
    }
    @Test(priority = 3)
    public void LoginFailIncorrectPass(){
        Day13_homework login = new Day13_homework(driver);
        login.LoginFunction("student","Password");
        assertTrue(driver.findElement(CT_Account.ERROR_PASS).isDisplayed());
    }
    @Test(priority = 4)
    public void LoginFailIncorrectBothUsernamePass(){
        Day13_homework login = new Day13_homework(driver);
        login.LoginFunction("student12323","Password231123");
        assertTrue(driver.findElement(CT_Account.ERROR_USERNAME).isDisplayed());
    }
    @Test(priority = 5)
    public void Logout(){
        Day13_homework login = new Day13_homework(driver);
        login.LoginFunction("student","Password123");
        login.LogoutFunction();
        assertTrue(driver.findElement(CT_Account.BT).isDisplayed());
    }
}
