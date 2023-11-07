package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day8_Practice extends CommonBase {
    @BeforeMethod
    public void openChromeBrowser(){
        driver = initChromeDriver("https://rise.fairsketch.com/signin");
    }
    @Test
    public void getLocatorById(){
        WebElement email =  driver.findElement(By.id("email"));
        System.out.println(email);
        WebElement pass = driver.findElement(By.id("password"));
        System.out.println(pass);
    }
    @AfterMethod
    public void closeChromeDriver(){
        driver.close();
    }
}
