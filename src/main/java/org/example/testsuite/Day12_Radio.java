package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day12_Radio extends CommonBase {
    @BeforeMethod
    public void openChrome() {
        driver = initChromeDriver("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
    }

    @Test
    public void checkRadio() {
        //Kiểm tra giá trị mặc định của radio Male và Female là chưa check
        WebElement radioMale = driver.findElement(By.xpath("//input[@value='Male']"));
        WebElement radioFemale = driver.findElement(By.xpath("//input[@value='Female']"));
        System.out.println("Trạng thái của radio Male: " + radioMale.isSelected());
        System.out.println("Trạng thái của radio Female: " + radioFemale.isSelected());
        //Kiểm tra radio chưa được check thì click vào
        if(!radioMale.isSelected() && radioMale.isEnabled()){
            radioMale.click();
        }
    }
}
