package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_Factory {
    private WebDriver driver;

    @FindBy(id = "txtFirstname")
    WebElement textName;

    @FindBy(id = "txtEmail")
    WebElement textEmail;

    @FindBy(xpath = "//input[@placeholder=\"Nhập lại địa chỉ email\"]")
    WebElement textCEmail;

    @FindBy(id = "txtPassword")
    WebElement textPass;

    @FindBy(id = "txtCPassword")
    WebElement textCPass;

    @FindBy(id = "txtPhone")
    WebElement textPhone;

    @FindBy(id = "chkRight")
    WebElement CRight;

    @FindBy(xpath = "//button[text()=\"ĐĂNG KÝ\" and @style=\"width:120px\"]")
    WebElement buttonSignup;

    @FindBy(xpath = "//div[@class='avatar2']")
    private WebElement avatar;

    @FindBy(xpath = "//a[text()=\"Chỉnh sửa thông tin\"]")
    WebElement update;

    @FindBy(id = "txtpassword")
    WebElement textOldPass;

    @FindBy(id = "txtnewpass")
    WebElement textNewPass;

    @FindBy(id = "txtrenewpass")
    WebElement textReNewPass;

    @FindBy(xpath = "//button[text()=\"Lưu mật khẩu mới\"]")
    WebElement saveUpdate;

    @FindBy(xpath = "//a[text()=\"Thoát\"]")
    WebElement buttonLogout;

    @FindBy(id = "txtLoginUsername")
    WebElement textLoginUsername;

    @FindBy(id = "txtLoginPassword")
    WebElement textLoginPass;

    @FindBy(xpath = "//button[text()=\"ĐĂNG NHẬP\" and @class=\"btn btn-lg btn_pink fs18 fleft w100per pass btn_submit\"]")
    WebElement buttonLogin;


    public Register_Factory(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(_driver, this);
    }

    public void RegisterFunction(String name, String email, String cEmail, String password, String cPassword, String phone){
        textName.clear();
        textName.sendKeys(name);

        textEmail.clear();
        textEmail.sendKeys(email);

        textCEmail.clear();
        textCEmail.sendKeys(cEmail);

        textPass.clear();
        textPass.sendKeys(password);

        textCPass.clear();
        textCPass.sendKeys(cPassword);

        textPhone.clear();
        textPhone.sendKeys(phone);

        if (!CRight.isSelected()){
            CRight.click();
        }

        buttonSignup.click();
    }
    public void UpdateFunction(String oldPass, String newPass, String reNewPass){
        avatar.click();

        update.click();

        textOldPass.clear();
        textOldPass.sendKeys(oldPass);

        textNewPass.clear();
        textNewPass.sendKeys(newPass);

        textReNewPass.clear();
        textReNewPass.sendKeys(reNewPass);

        saveUpdate.click();

    }
    public void LogoutFunction(){
        avatar.click();

        buttonLogout.click();

    }

    public void LoginFunction(String username, String password){
        textLoginUsername.clear();
        textLoginUsername.sendKeys(username);

        textLoginPass.clear();
        textLoginPass.sendKeys(password);

        if(buttonLogin.isDisplayed()){
            buttonLogin.click();
        }
    }

}
