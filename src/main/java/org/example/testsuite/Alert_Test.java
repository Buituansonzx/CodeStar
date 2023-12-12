package org.example.testsuite;

import org.example.common.CommonBase;
import org.example.constant.CT_Account;
import org.example.page.Guru99_Page;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Alert_Test extends CommonBase {

    @BeforeMethod
    public void openChrome(){
        driver = initChromeDriver("https://demo.guru99.com/test/delete_customer.php");
    }
    @Test
    public void deleteCustomerSuccessfully(){
        Guru99_Page guru99Page = new Guru99_Page(driver);
        guru99Page.checkAlertSubmit("1234");
        String msg = driver.switchTo().alert().getText();
        Assert.assertEquals(msg, "Do you really want to delete this Customer?");
        driver.switchTo().alert().accept();
        String msgNoti = driver.switchTo().alert().getText();
        Assert.assertEquals(msgNoti, "Customer Successfully Delete!");

    }
}
