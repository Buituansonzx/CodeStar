package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Multilcheckbox extends CommonBase {
    @BeforeMethod
    public void openChrome() {
        driver = initChromeDriver("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
    }
    @Test
    public void clickOnMultipleCheckbox() throws InterruptedException {
        //lấy tổng số check box
         List<WebElement> list =  driver.findElements(By.xpath("//div[@class='panel-body']/child::div[@class='checkbox']//input"));
         for(int i=0; i<list.size();i++){
             WebElement checkbox = list.get(i);
             if(!checkbox.isSelected()){
                 checkbox.click();
                 Thread.sleep(3000);
                 System.out.println("Check box thứ "+(i+1)+" đã được checked!");
             }
         }
    }


}
