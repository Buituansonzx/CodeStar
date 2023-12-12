package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HW_Day16_Test extends CommonBase {
    @BeforeMethod
    public void openChrome(){
        driver = initChromeDriver("http://seleniumpractise.blogspot.com/2019/01/alert-demo.html");
    }
    @Test
    public void checkAlert(){
        driver.findElement(By.xpath("//button[@onclick=\"myFunction()\"]")).click();
        pause(10000);
        String msg = driver.switchTo().alert().getText();
        Assert.assertEquals(msg, "Welcome to Selenium WebDriver Tutorials");
        driver.switchTo().alert().accept();
    }
}
