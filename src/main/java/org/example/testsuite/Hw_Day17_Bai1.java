package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hw_Day17_Bai1 extends CommonBase {
    @BeforeMethod
    public void openChrome(){
        driver = initChromeDriver("https://dienmaynhapkhaugiare.com.vn/");
    }
    @Test
    public void test_IframeMap(){
        int totalIframe = driver.findElements(By.tagName("iframe")).size();
        for(int i=0; i<totalIframe;i++){
            driver.switchTo().frame(i);
            int totalButtonXemBanDo = driver.findElements(By.xpath("//div[@class=\"default-card\"]")).size();
            System.out.println("totalButtonXemBanDo: "+ totalButtonXemBanDo);
            if(totalButtonXemBanDo != 0){
                click(By.xpath("//a[@aria-label=\"Xem bản đồ lớn hơn\"]"));
                isElementPresent(By.xpath("///div[@class=\"default-card\"]"));
                //Đóng iframe trước khi chuyển sang iframe kế tiếp
                driver.switchTo().defaultContent();
            }else {
                //Không thực thi lệnh, đóng iframe trước khi chuyển sang iframe kế tiếp
                driver.switchTo().defaultContent();
            }
        }
    }
}
