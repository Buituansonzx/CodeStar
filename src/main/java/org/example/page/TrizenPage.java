package org.example.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrizenPage {
    private WebDriver driver;
    public TrizenPage(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(_driver, this);
    }
    @FindBy(xpath="(//label[text()='Departing'])[1]/following-sibling::div/input")
    WebElement textDepartingDate;

    @FindBy(xpath = "(//div[@class=\"dropdown dropdown-contain gty-container\"])[1]")
    WebElement dropboxPassenger;

    @FindBy(xpath = "(//label[text()=\"Adults\"])[1]/following-sibling::div//i[@class=\"la la-plus\"]")
    WebElement addAdult;
    public void HandDateTimeDropdownList() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('readonly', 'readonly')", textDepartingDate);
        textDepartingDate.clear();
        textDepartingDate.sendKeys("09032024");
        textDepartingDate.sendKeys(Keys.TAB);
        Thread.sleep(3000);
        dropboxPassenger.click();
        addAdult.click();

    }
}
