package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day17_HandleIframe extends CommonBase {
    @BeforeMethod
    public void openChrome(){
        driver= initChromeDriver("https://codestar.vn/");
    }
    @Test
    public void test_DangKyNgay_iframe(){
        pause(5000);
        int totalIframe = driver.findElements(By.tagName("iframe")).size();
        for(int i=0; i<totalIframe;i++){
            driver.switchTo().frame(i);
            int totalButtonGuiNgay = driver.findElements(By.xpath("//button[text()='Gửi ngay']")).size();
            System.out.println("totalButtonGuiNgay: "+ totalButtonGuiNgay);
            if(totalButtonGuiNgay != 0){
                type(By.id("account_phone"), "0912331112");
                click(By.xpath("//button[text()='Gửi ngay']"));
                isElementPresent(By.xpath("//button[text()='Gửi ngay']"));
                //Đóng iframe trước khi chuyển sang iframe kế tiếp
                driver.switchTo().defaultContent();
            }else {
                //Không thực thi lệnh, đóng iframe trước khi chuyển sang iframe kế tiếp
                driver.switchTo().defaultContent();
            }
        }
    }
}
