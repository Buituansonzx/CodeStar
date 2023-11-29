package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Factory {
    private WebDriver driver;
    @FindBy(id = "email")
    WebElement textEmail;

    @FindBy(id = "password")
    WebElement textPassword;

    @FindBy(xpath = "//button[text()='Sign in']")
    WebElement buttonSignin;

    @FindBy(xpath = "//span[@class=\"user-name ml10\"]")
    WebElement user;

    @FindBy(xpath = "//a[text()=\" Sign Out\"]")
    WebElement buttonSignOut;

    public Login_Factory(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(_driver, this);
    }
    public void LoginFunction(String email, String pass){
        textEmail.clear();
        textEmail.sendKeys(email);

        textPassword.clear();
        textPassword.sendKeys(pass);

        buttonSignin.click();
    }

    public void LogoutFunction(){
        user.click();

        buttonSignOut.click();
    }
}
