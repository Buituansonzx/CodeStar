package org.example.testsuite;

import org.example.common.CommonBase;
import org.example.page.DemoAlert_Page;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoAlert_Test extends CommonBase {
    @BeforeMethod
    public void openChrome(){
        driver = initChromeDriver("https://demo.automationtesting.in/Alerts.html");
    }
    @Test
    public void checkAlertTextboxSuccessfully(){
        DemoAlert_Page demo = new DemoAlert_Page(driver);
        demo.checkAlertTextbox();
        String msg = driver.switchTo().alert().getText();
        Assert.assertEquals(msg, "Please enter your name");
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.id("demo1")).isDisplayed());


    }
}
