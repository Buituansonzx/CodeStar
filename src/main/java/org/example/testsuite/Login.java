package org.example.testsuite;

import org.example.common.CommonBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Login extends CommonBase {
    @BeforeTest
    public void openChrome(){
        driver = initChromeDriver("https://www.facebook.com/");
    }
    @Test
    public void Test(){
        System.out.println("Hello my first project!");
    }
}
