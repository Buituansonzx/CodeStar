package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Day17_Practice extends CommonBase {
    @BeforeMethod
    public void openChrome() {
        driver = initChromeDriver("https://demo.guru99.com/popup.php");
    }

    @Test
    public void TestPopupWindow() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[text()=\"Click Here\"]")).click();
        String mainWindow = driver.getWindowHandle();
        //Lấy ra tất cả các tab Windows đang open bằng hàm getWindowHandle
        Set<String> windows = driver.getWindowHandles();
        //Set là 1 collection để lưu các phần tử giá trị ko trùng lặp
        //Dùng for each để duyệt phần từ không trùng lặp
        for (String window : windows) {
            System.out.println(window);
            if (!mainWindow.equals(window)) {
                //So sánh nếu window nào khác window Chính thì chuyển qua để thao tác
                driver.switchTo().window(window);
                pause(2000);
                System.out.println("Đã chuyển đến lớp Window con");
                //Một số hàm hỗ trợ
                System.out.println("Title: " + driver.switchTo().window(window).getTitle());
                System.out.println("CurrentTitle: " + driver.switchTo().window(window).getCurrentUrl());
                driver.findElement(By.name("emailid")).sendKeys("hehehe@gmail.com");
                driver.findElement(By.name("btnLogin")).click();
                //Lấy text sau khi Submit
                System.out.println(driver.findElement(By.xpath("//table//td//h2")).getText());
                driver.close();
            }
        }
        //Switching to Parent window (Main window)
        driver.switchTo().window(mainWindow);
        System.out.println("Đã chuyển về Window chính: " + driver.getCurrentUrl());
    }
}
