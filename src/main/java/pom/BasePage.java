package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage
{
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver = driver;
    }

    protected WebDriverWait getWait(){ return wait; }

    public WebDriver getDriver(){
        return driver;
    }

    void implicitWait(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    void waitElementToBeVisible(WebElement webElement){
        getWait().until(ExpectedConditions.visibilityOf(webElement));
    }

    void waitForAllElements(List<WebElement> list){
        getWait().until(ExpectedConditions.visibilityOfAllElements(list));
    }

    void waitElementToBeClickable(WebElement webElement){
        getWait().until(ExpectedConditions.elementToBeClickable(webElement));
    }

    void completeField(WebElement webElement, String text){
        waitElementToBeVisible(webElement);
        webElement.sendKeys(text);
    }

    void clickOnElement(WebElement webElement){
        waitElementToBeClickable(webElement);
        webElement.click();
    }
}
