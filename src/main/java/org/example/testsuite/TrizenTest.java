package org.example.testsuite;

import org.example.common.CommonBase;
import org.example.page.TrizenPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrizenTest extends CommonBase {
    @BeforeMethod
    public void openChrome(){
        driver = initChromeDriver("https://techydevs.com/demos/themes/html/trizen-demo/trizen/index.html");
    }
    @Test
    public void TestDateTimeDropdownList() throws InterruptedException {
        TrizenPage trizen = new TrizenPage(driver);
        trizen.HandDateTimeDropdownList();
    }
}
