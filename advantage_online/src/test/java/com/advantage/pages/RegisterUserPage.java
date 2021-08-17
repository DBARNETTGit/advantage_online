package com.advantage.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class RegisterUserPage {
    protected String Username;
    protected String EmailAddress;
    protected String Password;
    protected String ConfirmPassword;
    protected String FirstName;
    protected String LastName;
    protected String PhoneNumber;
    protected String City;
    protected String Address;
    protected String State;
    protected String Postcode;

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    protected boolean isElementDisplay(long timeInSeconds, WebElement displayElement) {
        try {
            Wait<WebDriver> wait1 = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeInSeconds))
                    .pollingEvery(Duration.ofMillis(10))
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class)
                    .ignoring(Exception.class);
            WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(displayElement));
            return element != null && element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public RegisterUserPage(WebDriver driver){
        this.driver = driver;
    }

    public void VerifyRegisterUserPage(){
        softAssert.assertTrue(driver.findElement
                        (By.name("usernameRegisterPage"))
                .isDisplayed());
        softAssert.assertTrue(driver.findElement(By.name("emailRegisterPage"))
                .isDisplayed());
        softAssert.assertAll();
    }

    public void EnterUserCredentials(){
        Username = "JohnDummy333";
        EmailAddress = "JohnDummer@Gmail.com";
        Password = "J0hnDummy@1";
        ConfirmPassword = Password;
        FirstName = "John";
        LastName = "Dummy";
        PhoneNumber = "07999888999";
        City = "London";
        Address = "Emirates";
        State = "London";
        Postcode = "W73EY";

        driver.findElement(By.name("usernameRegisterPage")).sendKeys(Username);
        driver.findElement(By.name("emailRegisterPage")).sendKeys(EmailAddress);
        driver.findElement(By.name("passwordRegisterPage")).sendKeys(Password);
        driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys(ConfirmPassword);
        driver.findElement(By.name("first_nameRegisterPage")).sendKeys(FirstName);
        driver.findElement(By.name("last_nameRegisterPage")).sendKeys(LastName);
        driver.findElement(By.name("phone_numberRegisterPage")).sendKeys(PhoneNumber);
        driver.findElement(By.name("countryListboxRegisterPage")).click();
        driver.findElement(By.xpath("//*[@id=\"formCover\"]/div[3]/div[1]/sec-view[1]/div/select/option[226]")).click();
        driver.findElement(By.name("cityRegisterPage")).sendKeys(City);
        driver.findElement(By.name("addressRegisterPage")).sendKeys(Address);
        driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys(State);
        driver.findElement(By.name("postal_codeRegisterPage")).sendKeys(Postcode);
        driver.findElement(By.name("allowOffersPromotion")).click();
        driver.findElement(By.name("i_agree")).click();
        isElementDisplay(10, driver.findElement(By.xpath("//*[@id=\"register_btnundefined\"]")));
        WebElement element=driver.findElement(By.xpath("//*[@id=\"register_btnundefined\"]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);



    }
}
