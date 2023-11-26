package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Btvn_day12 extends CommonBase {
    @BeforeMethod
    public void openChrome(){
        driver = initChromeDriver("https://demo.seleniumeasy.com/input-form-demo.html");
    }
    @Test
    public void  checkDropDownList() throws InterruptedException {
        WebElement selectTag = driver.findElement(By.name("state"));
        Select dropdownlist = new Select(selectTag);
        selectTag.click();
        dropdownlist.selectByVisibleText("Texas");
        System.out.println("First option is : "+dropdownlist.getFirstSelectedOption().getText());
        Thread.sleep(3000);
    }
    @Test
    public void checkRadio(){
        WebElement radioYes = driver.findElement(By.xpath("//input[@value=\"yes\"]"));
        if(!radioYes.isSelected()){
            radioYes.click();
        }
        System.out.println("Radio yes was selected!");
    }

}
