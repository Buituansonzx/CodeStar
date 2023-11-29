package org.example.testsuite;

import org.example.common.CommonBase;
import org.example.constant.CT_Account;
import org.example.page.Register_Factory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RegisterTest_Factory extends CommonBase {
    @BeforeMethod
    public void openChrome(){
        driver = initChromeDriver(CT_Account.BTVN_DAY14_URL);
    }
    @Test(priority = 1)
    public void registerSuccessfully(){
        Register_Factory register = new Register_Factory(driver);
        register.RegisterFunction("Bùi Tuấn Sơn", "son12344@gmail.com", "son12344@gmail.com", "Sonheozx1@","Sonheozx1@","0981112223");
        assertTrue(isElementPresent(CT_Account.KHOAHOCCUATOI));
    }
}
