package org.example.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Client_Page {
    private WebDriver driver;
    @FindBy(xpath = "//span[text()='Clients']")
    WebElement clientLinks;

    @FindBy(xpath="//a[@data-title='Add client']")
    WebElement clientButton;

    @FindBy(id="type_person")
    WebElement radioPerson;

    @FindBy(id="company_name")
    WebElement textboxClientName;

    @FindBy(id="s2id_created_by")
    WebElement ownerDropdownlist;

    @FindBy(xpath = "//ul[@id='select2-results-3']//div[text()='Sara Ann']")
    WebElement ownerItem;

    @FindBy(xpath="//button[@type='submit' and normalize-space()='Save']")
    WebElement buttonSave;

    @FindBy(xpath="//a[text()='Clients']")
    WebElement clientsTab;

    @FindBy(xpath="//input[@type='search' and @placeholder='Search']")
    WebElement textboxSearch;

    public Client_Page(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(_driver, this);
    }
    public void AddClientFunction(String companyName, String Owner) throws InterruptedException {
        clientLinks.click();
        clientButton.click();
        Thread.sleep(3000);
        radioPerson.click();
        textboxClientName.sendKeys(companyName);
        ownerDropdownlist.click();
        ownerItem.click();
        buttonSave.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clientsTab);
        Thread.sleep(3000);
        textboxSearch.sendKeys(companyName);
    }
}

