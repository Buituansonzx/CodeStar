package org.example.common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonBase {
    public WebDriver driver;
    private int initWaitTime = 10;

    public WebDriver initChromeDriver(String URL) {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        // For MAC: System.getProperty("user.dir") + "/driver/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        return driver;
    }

    /*
     * Handle hÃ m isDisplayed()
     * Happy case/ Positive case: Sáº½ tráº£ vá» true
     * Unhappy case/ Negative case: isDisplayed() tráº£ vá» false
     * -> Hoáº·c trÆ°á»›c khi cháº¡y Ä‘áº¿n isDisplay Ä‘Ã£ bá»‹ exception á»Ÿ má»™t dÃ²ng code cá»§a hÃ m nÃ o trÆ°á»›c Ä‘Ã³
     * -> Catch exception vÃ  return false.
     */
    public boolean isElementPresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        } catch (org.openqa.selenium.TimeoutException e2) {
            return false;
        }
    }

    /*Handle Click
     * Happy case/ Positive case: FindElement vÃ  Click thÃ nh cÃ´ng
     * Unhappy case/ Negative case: 3 trÆ°á»ng há»£p
     * 1. FindElement vÄƒng ra exception (xá»­ lÃ½ Ä‘á»£i explicit wait cho hÃ m FindElement)
     */
    public WebElement getElementPresentDOM(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void click(By locator) {
        WebElement element = getElementPresentDOM(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    // 2. elementToBeClickable bá»‹ exception do element Ä‘Ã³ khÃ´ng cho phÃ©p Click(ElementClickInterceptedException)
    public void clickByJsExecutor(By locator)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", locator);
    }

    /* Handle SenKeys
     * Happy case: FindElement vÃ  sendKey thÃ nh cÃ´ng
     * Unhappy case/ Negative case: 2 trÆ°á»ng há»£p
     * 1. FindElement vÄƒng ra exception (xá»­ lÃ½ Ä‘á»£i explicit wait cho hÃ m FindElement) => done báº±ng getElementPresentDOM
     * */
    public void type(By locator, String value) {
        WebElement element = getElementPresentDOM(locator);
        element.clear();
        element.sendKeys(value);
    }

    // 2. SendKeys khÃ´ng thÃ nh cÃ´ng do element readonly/ khÃ´ng cho nháº­p báº±ng bÃ¬nh thÆ°á»ng (ElementNotInteractableException)
    public void typeInValue_ByJsExecutor(By locator, String value) throws InterruptedException
    {
        WebElement element = getElementPresentDOM(locator);
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + value + "'", element);
        } catch (StaleElementReferenceException ex) {
            pause(1000);
            typeInValue_ByJsExecutor(locator, value);
        }
    }
    public void inputTextJavaScript_ToInnerHTMLAttribute(By inputElement, String value) {
        WebElement element = driver.findElement(inputElement);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        try {
            executor.executeScript("arguments[0].innerHTML = '" + value + "'", element);
        } catch (StaleElementReferenceException ex) {
            pause(1000);
            inputTextJavaScript_ToInnerHTMLAttribute(inputElement, value);
        }
    }

    // Handle Thread.sleep(miliSeconds);
    public void pause(long miliSeconds)
    {
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Handle Scroll tá»›i element MÃ€ VáºªN NHÃŒN THáº¤Y TRÃŠN MÃ€N HÃŒNH (scroll Ä‘áº¿n element cuá»‘i cÃ¹ng nhÃ¬n tháº¥y trÃªn mÃ n hÃ¬nh)
    public void scrollToElement(By locator) {
        WebElement element = getElementPresentDOM(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}
