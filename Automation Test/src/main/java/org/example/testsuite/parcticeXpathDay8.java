package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class parcticeXpathDay8 extends CommonBase {
    @BeforeMethod
    public void openChromeDriver(){
        driver = initChromeDriver("https://automationfc.github.io/basic-form/index.html");
    }
    @Test
    public void Locator(){
        //0
        System.out.println(driver.findElement(By.linkText("Quảng Nam")));
        //1
        System.out.println(driver.findElement(By.id("mail")));
        //2
        System.out.println(driver.findElement(By.className("slider-1")));
        //3
        System.out.println(driver.findElement(By.partialLinkText("Element is display")));
        //4
        System.out.println(driver.findElement(By.linkText("FACEBOOK")));
        //5
        System.out.println(driver.findElement(By.tagName("label")));
        //6
        System.out.println(driver.findElement(By.tagName("label")));
        //7
        System.out.println(driver.findElement(By.className("number")));
        //8
        System.out.println(driver.findElement(By.linkText("Hover over me")));
        //9
        System.out.println(driver.findElement(By.id("demo")));
        //10
        System.out.println(driver.findElement(By.className("example")));
        //11
        System.out.println(driver.findElement(By.id("name")));
    }
}
