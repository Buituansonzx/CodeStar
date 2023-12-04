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


    @FindBy(xpath = "(//input[@placeholder=\"City or airport\"])[1]")
    WebElement textFlyFrom;

    @FindBy(xpath = "(//input[@placeholder=\"City or airport\"])[2]")
    WebElement textFlyTo;

    @FindBy(xpath = "(//button[@class=\"btn dropdown-toggle btn-light\" and @role=\"combobox\"])[3]")
    WebElement selectCoach;

    @FindBy(id = "bs-select-3-2")
    WebElement coachFirstClass;

    @FindBy(xpath = "(//a[text()=\"Search Now\"])[1]")
    WebElement buttonSearch;

    public void HandDateTimeDropdownList(String from, String to, String departingDate) throws InterruptedException {
        textFlyFrom.sendKeys(from);
        textFlyTo.sendKeys(to);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('readonly', 'readonly')", textDepartingDate);
        textDepartingDate.clear();
        textDepartingDate.sendKeys(departingDate);
        textDepartingDate.sendKeys(Keys.TAB);
        Thread.sleep(3000);
        dropboxPassenger.click();
        Thread.sleep(3000);
        addAdult.click();
        selectCoach.click();
        coachFirstClass.click();
        buttonSearch.click();
    }
}
