package org.example.constant;

import org.openqa.selenium.By;

public class CT_Account {
    public static String RISE_URL = "https://rise.fairsketch.com/signin";
    public static By TEXT_EMAIL = By.id("email");
    public static By TEXT_PASSWORD = By.id("password");
    public static By TEXT_BUTTON = By.xpath("//button[text()='Sign in']");
    public static By DASHBOARD = By.xpath("//span[text()='Dashboard' and @class='menu-text ']");
    public static By AUTHEN_FAIL = By.xpath("//div[@class=\"alert alert-danger\"]");
}
