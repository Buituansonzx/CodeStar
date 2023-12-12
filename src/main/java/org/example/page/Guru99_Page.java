package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99_Page {
    private WebDriver driver;
    public Guru99_Page(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(_driver, this);
    }

    @FindBy(xpath = "//input[@name=\"cusid\"]")
    WebElement textInput;

    @FindBy(xpath = "//input[@name=\"submit\"]")
    WebElement buttonSubmit;

    @FindBy(xpath = "//input[@name=\"res\"]")
    WebElement buttonReset;

    public void checkAlertSubmit(String value){
        textInput.clear();
        textInput.sendKeys(value);
        buttonSubmit.click();
    }
    public void checkAlertReset(String value){
        textInput.clear();
        textInput.sendKeys(value);
        buttonReset.click();
    }
}
