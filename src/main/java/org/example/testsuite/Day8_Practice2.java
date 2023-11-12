package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day8_Practice2 extends CommonBase {
    @BeforeMethod
    public void openChromeDriver(){
        driver = initChromeDriver("https://bepantoan.vn/");
    }
    @Test
    public void getLocatorByText(){
        WebElement ad = driver.findElement(By.linkText("Máy Rửa Chén Bát"));
        System.out.println(ad);
        WebElement ab = driver.findElement(By.partialLinkText("Máy Hút Mùi Cổ Điển"));
        System.out.println(ab);
    }
    @Test
    public void getLacatorBy_TagName() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.className("cursor-pointer")));
        System.out.println(driver.findElement(By.tagName("input")));
    }
    @AfterMethod
    public void close(){
        driver.close();
    }
}
