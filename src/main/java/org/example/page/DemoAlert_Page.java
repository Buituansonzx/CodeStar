package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoAlert_Page {
    private WebDriver driver;
    public DemoAlert_Page(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(_driver, this);
    }

    @FindBy(xpath = "//a[text()=\"Alert with Textbox \"]")
    WebElement alertWithTextbox;

    @FindBy(xpath = "//button[text()=\"click the button to demonstrate the prompt box \"]")
    WebElement clickButton;


    public void checkAlertTextbox(){
        alertWithTextbox.click();
        clickButton.click();
    }
}
