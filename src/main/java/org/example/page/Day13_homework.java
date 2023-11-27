package org.example.page;

import org.example.constant.CT_Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Day13_homework {
    private WebDriver driver;
    public Day13_homework(WebDriver _driver){
        this.driver = _driver;
    }
    public void LoginFunction( String emailX, String passX){
        WebElement email =  driver.findElement(CT_Account.USERNAME);
        if(email.isEnabled()){
            email.clear();
            email.sendKeys(emailX);
        }
        WebElement pass =  driver.findElement(CT_Account.PASS);
        if(pass.isEnabled()){
            pass.clear();
            pass.sendKeys(passX);
        }
        WebElement bt  = driver.findElement(CT_Account.BT);
        if(bt.isEnabled()){
            bt.click();
        }
    }
    public void LogoutFunction(){
        WebElement logout = driver.findElement(CT_Account.LOGOUT);
        if(logout.isEnabled()){
            logout.click();
        }
    }
}
