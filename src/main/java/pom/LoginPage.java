package pom;

import constants.Constants;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="identifierId")
    private WebElement usernameField;

    @FindBy(css = "input[type=\"password\"]")
    private WebElement passwordField;

    public void fillEmail(){
        completeField(usernameField, Constants.EMAIL);
        usernameField.sendKeys(Keys.ENTER);
    }

    public void fillPassword(){
        completeField(passwordField, Constants.PASSWORD);
        passwordField.sendKeys(Keys.ENTER);
    }
}
