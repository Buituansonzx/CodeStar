package org.example.page;

import org.example.constant.CT_Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver _driver){
        this.driver = _driver;
    }
    public void LoginFunction( String emailX, String passX){
        WebElement email =  driver.findElement(CT_Account.TEXT_EMAIL);
        if(email.isEnabled()){
            email.clear();
            email.sendKeys(emailX);
        }
        WebElement pass =  driver.findElement(CT_Account.TEXT_PASSWORD);
        if(pass.isEnabled()){
            pass.clear();
            pass.sendKeys(passX);
        }
        WebElement bt  = driver.findElement(CT_Account.TEXT_BUTTON);
        if(bt.isEnabled()){
            bt.click();
        }
    }
}
