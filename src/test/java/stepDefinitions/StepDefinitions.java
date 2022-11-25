package stepDefinitions;

import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pom.InboxPage;
import pom.LoginPage;

public class StepDefinitions {
    LoginPage loginPage;
    InboxPage inboxPage;
    int numberOfMails;

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        System.out.println("Opening login page...");
        loginPage = new LoginPage(Hooks.driver);
    }

    @Given("user enters user and password and press enter")
    public void userEntersUserAndPassword() {
        System.out.println("Setting username and password...");
        loginPage.fillEmail();
        loginPage.fillPassword();

        System.out.println("Opening inbox page...");
        inboxPage = new InboxPage(Hooks.driver);
    }

    @When("user is logged and is on inbox page")
    public void userIsLoggedAndIsOnInboxPage() {
        Assert.assertTrue(inboxPage.btnRedactarIsPresent(), "User is not on inbox page");

        System.out.println("Checking if user is logged correctly...");
        Assert.assertTrue(inboxPage.userIsLogged().contains(Constants.EMAIL),"The logged email is not correct");
    }

    @When("user creates a new email")
    public void userCreatesANewEmail() {
        System.out.println("Creating an email with the “Social” label, the subject line “QA Automation " +
                "Test” and a message body that states “InterPrice QA Automation Test Complete”...");

        numberOfMails = inboxPage.getNumberOfMails();
        inboxPage.clickOnRedactarBtn();
        inboxPage.completeFields();
        inboxPage.selectSocialTag();

    }

    @When("user sends the email")
    public void sendTheEmail() {
        System.out.println("Send the email to your personal account and CC qa@interpricetech.com");

        inboxPage.clickOnEnviarBtn();
        Assert.assertTrue(inboxPage.getNumberOfMails()>numberOfMails,"The email was not received.");

    }

    @When("user marks the received email as starred")
    public void markTheReceivedEmailAsStarred() {
        System.out.println("Mark the received email as starred");
        Assert.assertTrue(inboxPage.clickOnStarBtn(),"The mail was not starred");

    }

    @Then("open email and verify the subject and message body")
    public void openAndVerifyTheEmailIsProperlyLabeled() {
        System.out.println("Open the received email");
        inboxPage.openReceivedEmail();

        System.out.println("Verifying subject and body");
        Assert.assertEquals(Constants.SUBJECT, inboxPage.getSubject(),"The subject doesn't match");
        Assert.assertEquals(Constants.MESSAGE, inboxPage.getBody(), "The body doesn't match");
    }
}
