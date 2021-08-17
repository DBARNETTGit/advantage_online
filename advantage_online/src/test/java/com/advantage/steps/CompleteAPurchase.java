package com.advantage.steps;

import com.advantage.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class CompleteAPurchase {
    WebDriver driver;
    protected HomePage homePage;
    protected RegisterUserPage registerUserPage;
    protected SpeakerPage speakerPage;
    protected CheckOutPage checkOutPage;
    protected PaymentCompletionPage paymentCompletionPage;

    @Before()
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        registerUserPage = new RegisterUserPage(driver);
        speakerPage = new SpeakerPage(driver);
        checkOutPage = new CheckOutPage(driver);
        paymentCompletionPage = new PaymentCompletionPage(driver);
    }

    @After()
    public void teardown() {
        driver.quit();
    }

    @Given("that I am on the Homepage")
    public void thatIAmOnTheHomepage() {
        homePage.GoToHomePage();
        homePage.VerifyHomePage();
    }

    @When("I click the User button")
    public void iClickTheUserButton() {
        homePage.ClickUserButton();
    }

    @And("I click the Create New User button")
    public void iClickTheCreateNewUserButton() {
        homePage.ClickCreateNewAccount();
    }

    @And("I land on the Registration page")
    public void iLandOnTheRegistrationPage() {
        registerUserPage.VerifyRegisterUserPage();
    }

    @And("I enter the registration details")
    public void iEnterTheRegistrationDetails() {
        registerUserPage.EnterUserCredentials();
    }

    @And("I register the User")
    public void iRegisterTheUser() {
        homePage.VerifyHomePage();
        homePage.VerifyUserLogIn();
    }

    @And("I select the Speakers button")
    public void iSelectTheSpeakersButton() {
        homePage.ClickSpeakerButton();
    }

    @And("I select a speaker")
    public void iSelectASpeaker() {
        speakerPage.SelectASpeaker();
    }

    @And("I add the speaker to the basket")
    public void iAddTheSpeakerToTheBasket() {
        speakerPage.AddSpeakerToBasket();
    }

    @And("I select the basket")
    public void iSelectTheBasket() {
        speakerPage.SelectTheBasket();
        speakerPage.ClickCheckout();
    }

    @And("I enter MasterCredit Details")
    public void iEnterMasterCreditDetails() {
        checkOutPage.ValidateCheckoutPage();
        checkOutPage.ClickforPaymentDetails();
        checkOutPage.EnterCardDetails();

    }

    @When("I click Pay Now")
    public void iClickPayNow() {
        checkOutPage.ClickPayNow();
    }

    @Then("I land on the Order Payment completion page")
    public void iLandOnTheOrderPaymentCompletionPage() {
        paymentCompletionPage.VerifyPaymentCompletion();


    }
}
