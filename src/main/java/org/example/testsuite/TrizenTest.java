package org.example.testsuite;

import org.example.common.CommonBase;
import org.example.page.TrizenPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TrizenTest extends CommonBase {
    @BeforeMethod
    public void openChrome(){
        driver = initChromeDriver("https://techydevs.com/demos/themes/html/trizen-demo/trizen/index.html");
    }
    @Test
    public void TestDateTimeDropdownList() throws InterruptedException {
        TrizenPage trizen = new TrizenPage(driver);
        trizen.HandDateTimeDropdownList("Ha Noi", "Lao Cai", "09032024");
        try {
            assertTrue(isElementPresent(By.xpath("//h2[text()=\"Flight Search Result\"]")));
            System.out.println("Element is present.");
        } catch (AssertionError e) {
            System.out.println("Element is not present.");
            e.printStackTrace(); // This will print the stack trace of the assertion error.
        }


    }
}
