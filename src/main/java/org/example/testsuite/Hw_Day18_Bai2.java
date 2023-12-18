package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Hw_Day18_Bai2 extends CommonBase {
    @Parameters("browser")
    @BeforeMethod
    public void openBrowser(String browser) {
        setupDriver(browser);
        driver.get("https://bepantoan.vn/");
    }
    @Test
    public void test_BepAnToan(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class=\"flex items-center space-x-0 transition duration-150 ease-in-out bg-gradient-access rounded-full text-white hover:scale-105 h-[40px]\"]")).click();
        String mainWindow = driver.getWindowHandle();
        //Lấy ra tất cả các tab Windows đang open bằng hàm getWindowHandle
        Set<String> windows = driver.getWindowHandles();
        //Set là 1 collection để lưu các phần tử giá trị ko trùng lặp
        //Dùng for each để duyệt phần từ không trùng lặp
        for (String window : windows) {
            System.out.println(window);
                //So sánh nếu window nào khác window Chính thì chuyển qua để thao tác
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
}
