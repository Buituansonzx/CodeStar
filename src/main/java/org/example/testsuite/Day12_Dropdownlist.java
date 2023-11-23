package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day12_Dropdownlist extends CommonBase {
    @BeforeMethod
    public void openChrome(){
        driver = initChromeDriver("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
    }
    @Test
    public void SelectOneOptionFromFropList() throws InterruptedException {
        WebElement selectTag = driver.findElement(By.id("select-demo"));
        Select dropdownlist = new Select(selectTag);
        System.out.println("Dropdown List Multiple: "+ dropdownlist.isMultiple());
        System.out.println("Dropdown List Size: "+ dropdownlist.getOptions().size());
        selectTag.click();
        dropdownlist.selectByValue("Sunday");
        System.out.println("First option is : "+dropdownlist.getFirstSelectedOption().getText());
        Thread.sleep(3000);
        selectTag.click();
        dropdownlist.selectByVisibleText("Monday");
        System.out.println("First option is : "+dropdownlist.getFirstSelectedOption().getText());
    }

}
