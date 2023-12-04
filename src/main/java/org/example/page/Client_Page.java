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

    @FindBy(id = "address")
    WebElement textAddress;

    @FindBy(id = "city")
    WebElement textCity;

    @FindBy(id = "state")
    WebElement textState;

    @FindBy(id = "zip")
    WebElement textZip;

    @FindBy(id = "country")
    WebElement textCountry;

    @FindBy(id = "phone")
    WebElement textPhone;

    @FindBy(id = "website")
    WebElement textWebsite;

    @FindBy(id = "vat_number")
    WebElement textVat;

    @FindBy(id = "gst_number")
    WebElement textGst;

    @FindBy(id = "s2id_autogen2")
    WebElement textGroup;


    @FindBy(id = "select2-chosen-1")
    WebElement dropdownListCurrent;

    @FindBy(id = "s2id_autogen1_search")
    WebElement currentSearch;

    @FindBy(id = "currency_symbol")
    WebElement textSymbol;

    @FindBy(id = "s2id_autogen4")
    WebElement textLabel;

    @FindBy(id = "s2id_autogen4")
    WebElement searchLabel;

    @FindBy(id = "disable_online_payment")
    WebElement checkOnlinePayment;
    public Client_Page(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(_driver, this);
    }
    public void AddClientFunction(String companyName, String Owner, String address, String city, String state, String zip, String country, String phone, String website, String VAT, String GST, String group, String current, String symbol, String label) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        clientLinks.click();
        clientButton.click();
        Thread.sleep(3000);
        radioPerson.click();
        textboxClientName.sendKeys(companyName);
        ownerDropdownlist.click();
        ownerItem.click();
        textAddress.sendKeys(address);
        textAddress.sendKeys(Keys.TAB);
        textCity.sendKeys(city);
        textState.sendKeys(state);
        textZip.sendKeys(zip);
        textCountry.sendKeys(country);
        textPhone.sendKeys(phone);
        textWebsite.sendKeys(website);
        textVat.sendKeys(VAT);
        textGst.sendKeys(GST);
        textGroup.sendKeys(group);
        textGroup.sendKeys(Keys.TAB);
        dropdownListCurrent.click();
        currentSearch.sendKeys(current);
        currentSearch.sendKeys(Keys.TAB);
        textSymbol.sendKeys(symbol);
        textLabel.click();
        searchLabel.sendKeys(label);
        searchLabel.sendKeys(Keys.TAB);
        checkOnlinePayment.click();
        buttonSave.click();


        js.executeScript("arguments[0].click();", clientsTab);
        Thread.sleep(3000);
        textboxSearch.sendKeys(companyName);
    }
}

