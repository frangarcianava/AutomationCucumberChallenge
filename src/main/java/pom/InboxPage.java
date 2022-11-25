package pom;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class InboxPage extends BasePage{
    public InboxPage(WebDriver driver) {
        super(driver);
    }

    int favIndex = 0;

    @FindBy(css = "[role=\"navigation\"]>div>div>[role=\"button\"]")
    private WebElement redactarBtn;

    @FindBy(css = "[role=\"tab\"][aria-label=\"Social\"]")
    private WebElement socialTab;

    @FindBy(css = "colgroup + tbody > tr[role=\"row\"]")
    private List<WebElement> mails;

    @FindBy(css = "[role=\"button\"][aria-label*=\"@\"]")
    private WebElement userProfileBtn;

    @FindBy(css = "[aria-label=\"Para\"] [role=\"combobox\"]")
    private WebElement recipientField;

    @FindBy(css = "[name=\"cc\"] input[role=\"combobox\"]")
    private WebElement ccField;

    @FindBy(css = "[aria-label*='\"Cc\"'][role=\"link\"]")
    private WebElement ccBtn;

    @FindBy(css = "input[name=\"subjectbox\"]")
    private WebElement subjectField;

    @FindBy(css = "[role=\"textbox\"]")
    private WebElement bodyField;

    @FindBy(css = "[role=\"group\"] [role=\"button\"][aria-label=\"Más opciones\"]")
    private WebElement moreOptionsBtn;

    @FindBy(css = "[role=\"dialog\"] [role=\"menu\"] div:nth-child(3)")
    private WebElement etiquetaOption;

    @FindBy(css = "[role=\"menuitemcheckbox\"][title=\"Social\"]")
    private WebElement socialTagOption;

    @FindBy(css = "[role=\"button\"][aria-label*=\"Enviar\"]")
    private WebElement btnEnviar;

    @FindBy(css = "[role=\"button\"][aria-label*=\"estaca\"]")
    private List<WebElement> starBtn;

    @FindBy(css = "[role=\"presentation\"] h2")
    private WebElement subjectTitle;

    @FindBy(css = "div > div > [role=\"presentation\"] [dir=\"ltr\"]")
    private WebElement bodyText;

    @FindBy(css="[role=\"gridcell\"] > div > span:nth-child(2) > span")
    private List<WebElement> anuncios;

    @FindBy(css = "[role=\"link\"] > div > div")
    private List<WebElement> messageInfo;


    public boolean btnRedactarIsPresent(){
        waitElementToBeVisible(redactarBtn);
        return redactarBtn.isDisplayed();
    }

    public String userIsLogged(){
        waitElementToBeVisible(userProfileBtn);
        return userProfileBtn.getAttribute("aria-label");
    }

    public int getNumberOfMails(){
        clickOnElement(socialTab);
        getWait().until(ExpectedConditions.visibilityOfAllElements(anuncios));
        waitForAllElements(mails);
        return mails.size();
    }

    public void clickOnRedactarBtn() {
        clickOnElement(redactarBtn);
    }

    public void completeFields() {
        completeField(recipientField, Constants.RECIPIENT);
        clickOnElement(ccBtn);
        completeField(ccField, Constants.CC);
        completeField(subjectField, Constants.SUBJECT);
        completeField(bodyField, Constants.MESSAGE);
    }

    public void selectSocialTag() {
        clickOnElement(moreOptionsBtn);
        Actions action = new Actions(getDriver());
        action.moveToElement(etiquetaOption).perform();
        clickOnElement(socialTagOption);
    }

    public void clickOnEnviarBtn() {
        clickOnElement(btnEnviar);
    }

    public boolean clickOnStarBtn(){
        getWait().until(ExpectedConditions.visibilityOfAllElements(messageInfo));
        implicitWait();
        for(int i = 0; i<mails.size();i++){
            if(mails.get(i).getText().contains(Constants.SUBJECT)){
                favIndex = i;
                clickOnElement(starBtn.get(favIndex));
                implicitWait();
                break;
            }
        }
        return starBtn.get(favIndex).getAttribute("aria-label").equalsIgnoreCase("destacado");
    }

    public void openReceivedEmail() {
        implicitWait();
        clickOnElement(mails.get(favIndex));
    }

    public String getSubject(){
        waitElementToBeVisible(subjectTitle);
        return subjectTitle.getText();
    }
    public String getBody(){
        return bodyText.getText();
    }
}
