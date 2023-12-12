package org.example.testsuite;

import org.example.common.CommonBase;
import org.example.constant.CT_Account;
import org.example.page.Register_Factory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UpdatePass_Factory extends CommonBase {
    @BeforeMethod
    public void openChrome() {
        driver = initChromeDriver("https://alada.vn/tai-khoan/dang-nhap.html");
    }
    @Test(priority = 1)
    public void updatePassword(){
        Register_Factory register = new Register_Factory(driver);
        register.LoginFunction("nam1234444@gmail.com", "Sonheozx1@");
        register.UpdateFunction("Sonheozx1", "Sonheozx123", "Sonheozx123");
        String actual = driver.switchTo().alert().getText();
        assertEquals(actual, "Cập nhật mật khẩu thành công!");
        driver.switchTo().alert().accept();
    }
    @Test(priority = 2)
    public void LoginByNewPass(){
        Register_Factory register = new Register_Factory(driver);
        register.LoginFunction("nam1234444@gmail.com", "Sonheozx123");
        assertTrue(isElementPresent(CT_Account.KHOAHOCCUATOI));
    }
}
