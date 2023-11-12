package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day8_Practice3 extends CommonBase {
    @BeforeMethod
    public void openChromeDriver(){
        driver = initChromeDriver("https://selectorshub.com/xpath-practice-page/");
    }
    @Test
    public void getLocator(){
        System.out.println(driver.findElement(By.id("userId")));
        System.out.println(driver.findElement(By.id("pass")));
        System.out.println(driver.findElement(By.name("company")));
        System.out.println(driver.findElement(By.name("mobile number")));
    }
}
