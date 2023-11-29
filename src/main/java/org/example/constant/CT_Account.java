package org.example.constant;

import org.openqa.selenium.By;

public class CT_Account {
    public static String RISE_URL = "https://rise.fairsketch.com/signin";
    public static By TEXT_EMAIL = By.id("email");
    public static By TEXT_PASSWORD = By.id("password");
    public static By TEXT_BUTTON = By.xpath("//button[text()='Sign in']");
    public static By DASHBOARD = By.xpath("//span[text()='Dashboard' and @class='menu-text ']");
    public static By AUTHEN_FAIL = By.xpath("//div[@class=\"alert alert-danger\"]");
    //DAY13 HOMEWORK
    public static String BTVN_DAY13_URL = "https://practicetestautomation.com/practice-test-login/";
    public static By USERNAME = By.xpath("//input[@id=\"username\"]");
    public static By PASS = By.xpath("//input[@id=\"password\"]");
    public static By BT = By.xpath("//button[@id=\"submit\"]");
    public static By LOGIN_SUCESS = By.xpath("//h1[text()=\"Logged In Successfully\"]");
    public static By ERROR_USERNAME = By.xpath("//div[text()=\"Your username is invalid!\"]");
    public static By ERROR_PASS = By.xpath("//div[text()=\"Your password is invalid!\"]");
    public static By LOGOUT = By.xpath("//a[text()=\"Log out\"]");

    //DAY14 HOMEWORK
    public static String BTVN_DAY14_URL = "https://alada.vn/tai-khoan/dang-ky.html";
    public static By KHOAHOCCUATOI = By.xpath("//a[text()=\"Khóa học của tôi\" and @class=\"fleft martop20 khct\"]");
}
