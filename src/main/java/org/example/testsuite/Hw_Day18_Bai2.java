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
    public void openBrowser( String browser) {
        setupDriver(browser);
        driver.get("https://bepantoan.vn/");
    }
    @Test
    public void test_BepAnToan(){
        pause(5000);
        int totalIframe = driver.findElements(By.tagName("iframe")).size();
        for(int i=0; i<totalIframe;i++){
            driver.switchTo().frame(i);
            int totalChatNgayVoiChungToi = driver.findElements(By.xpath("//button[@class=\"tawk-custom-color tawk-custom-border-color tawk-button\"]")).size();
            System.out.println("totalChatNgayVoiChungToi: "+ totalChatNgayVoiChungToi);
            if(totalChatNgayVoiChungToi != 0){
                click(By.xpath("//button[@class=\"tawk-custom-color tawk-custom-border-color tawk-button\"]"));
                pause(5000);
                submitJs(By.xpath("//button[@class=\"tawk-margin-xsmall-left tawk-button-hover tawk-custom-color tawk-custom-border-color tawk-button\"]"));
                pause(5000);
                isElementPresent(By.xpath("//b[text()=\"CHÁT ONLINE NHẬN QUÀ KHUYẾN MÃI TRỊ GIÁ \"]"));
                //Đóng iframe trước khi chuyển sang iframe kế tiếp
                driver.switchTo().defaultContent();
            }else {
                //Không thực thi lệnh, đóng iframe trước khi chuyển sang iframe kế tiếp
                driver.switchTo().defaultContent();
            }
        }
    }
}
