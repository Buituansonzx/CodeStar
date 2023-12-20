package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Hw_Day18_Bai1 extends CommonBase {
    @Parameters("browser")
    @BeforeMethod
    public void openBrowser(String browser) {
        setupDriver(browser);
        driver.get("https://dienmaynhapkhaugiare.com.vn");
    }

    @Test
    public void test_Zalo() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id=\"zalo-vr\"]")).click();
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
                //Lấy text sau khi Submit
                System.out.println(driver.findElement(By.xpath("//h1")).getText());
                driver.close();
            }
        }
        //Switching to Parent window (Main window)
        driver.switchTo().window(mainWindow);
        System.out.println("Đã chuyển về Window chính: " + driver.getCurrentUrl());
    }
    @AfterMethod
    public void close(){
        driver.close();
    }
}
