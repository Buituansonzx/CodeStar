package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class day12Checkbox extends CommonBase {
    @BeforeMethod
    public void openChrome() {
        driver = initChromeDriver("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
    }

    @Test
    public void CkickOnCheckBox() {
        //Kiểm tra rằng sai khi page được mở thì Default checked đã được checked
        WebElement defaultChecked = driver.findElement(By.xpath("//label[normalize-space()='Default Checked']/descendant::input[@type='checkbox']"));
        boolean status = defaultChecked.isSelected();
        System.out.println("Status is: " + status);

        //Kiểm tra checkbox ten Click on this check box chưa được selected thì sẽ click
        WebElement clickOnThisCheckbox = driver.findElement(By.xpath("//label[normalize-space()='Click on this check box']/descendant::input[@type='checkbox']"));
        if (!clickOnThisCheckbox.isSelected()) {
            clickOnThisCheckbox.click();
            System.out.println("Check box 'Click on this check box' was checked!");
        }
        //Lấy xpath của Default Checkbox, tìm element này, element.isEnable(), element.isDisplay()
        WebElement defaultCheckbox = driver.findElement(By.xpath("//label[normalize-space()='Default Disabled']/descendant::input[@type='checkbox']"));
        System.out.println("Enable is: "+defaultCheckbox.isEnabled());
        System.out.println("Display : "+defaultCheckbox.isDisplayed());
    }

}
