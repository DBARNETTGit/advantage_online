package com.advantage.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class HomePage {
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
    private WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }




    public void GoToHomePage() {
        driver.get("http://advantageonlineshopping.com/#/");
    }

    public void VerifyHomePage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert.assertTrue(driver.findElement(By.id("menuUser")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("menuCart")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("speakersImg")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("tabletsImg")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("headphonesImg")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("miceImg")).isDisplayed());
        softAssert.assertAll();

    }

    public void ClickUserButton() {

        driver.findElement(By.id("menuUser")).click();
        softAssert.assertTrue(driver.findElement(By.className("PopUp")).isDisplayed());
        softAssert.assertAll();
    }

    public void ClickCreateNewAccount() {

        WebElement element=driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);


    }

    public void VerifyUserLogIn(){

        isElementDisplay(20, driver.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span")));
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span")).getText(), "JohnDummy333");
        softAssert.assertAll();

    }

    public void ClickSpeakerButton(){
        driver.findElement(By.id("speakersImg")).click();
        softAssert.assertTrue(driver.findElement(By.id("accordionPrice")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("accordionAttrib0")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("accordionAttrib1")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("accordionAttrib2")).isDisplayed());
        softAssert.assertAll();

    }

}
