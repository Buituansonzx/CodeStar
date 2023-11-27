package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.Command;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day13_Login extends CommonBase {
    @BeforeMethod
    public void openChrome(){
        driver = initChromeDriver("https://www.facebook.com/?locale=vi_VN");
    }
    @Test
    public void checkLoginFB(){
        //Điền email
        WebElement email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
        email.clear();
        email.sendKeys("0392730906");
        //Điền password
        WebElement password = driver.findElement(By.xpath("//input[@id=\"pass\"]"));
        password.clear();
        password.sendKeys("Sonheozx1@");
        //NHấp nút đăng nhập
        WebElement bt = driver.findElement(By.xpath("//button[@name=\"login\"]"));
        if(bt.isDisplayed() && bt.isEnabled()){
            bt.click();
        }

    }
}
