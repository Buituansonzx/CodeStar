package org.example.testsuite;

import org.example.common.CommonBase;
import org.example.constant.CT_Account;
import org.example.page.Client_Page;
import org.example.page.LoginPage;
import org.example.page.Login_Factory;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClienTest extends CommonBase {
    @BeforeMethod
    public void openChrome(){
        driver = initChromeDriver(CT_Account.RISE_URL);
    }
    @Test
    public void AddClientSuccessfully() throws InterruptedException {
        Login_Factory login = new Login_Factory(driver);
        login.LoginFunction("admin@demo.com","riseDemo");
        Client_Page client = new Client_Page(driver);
        client.AddClientFunction("demo Company","Sara Ann");
        Thread.sleep(3000);
        isElementPresent(By.xpath("//a[text()='Demo Company']"));
    }
}
