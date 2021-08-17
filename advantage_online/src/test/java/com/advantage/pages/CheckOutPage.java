package com.advantage.pages;

import org.openqa.selenium.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class CheckOutPage {

    protected String creditCardNumber;
    protected String CvvNumber;
    protected String cardHolder;
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public CheckOutPage (WebDriver driver){
        this.driver = driver;
    }



    public void ValidateCheckoutPage(){
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@id=\"userDetails\"]/div[1]/label")).getText(), "John Dummy");
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@id=\"userDetails\"]/div[3]/label")).getText(), "07999888999");
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@id=\"product\"]/td[2]/a/h3")).getText(), "BOSE SOUNDLINK BLUETOOTH SP...");
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@id=\"userCart\"]/div[2]/label[2]/span")).getText(), "$269.99");
        softAssert.assertAll();
    }

    public void ClickforPaymentDetails(){
        driver.findElement(By.id("next_btn")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"paymentMethod\"]/div/div[1]/div[2]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id=\"creditCard\"]")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id=\"paymentMethod\"]/div/div[4]/sec-form/div[1]/sec-view[2]/div/input")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id=\"paymentMethod\"]/div/div[4]/sec-form/div[2]/sec-view/div/input")).isDisplayed());
        softAssert.assertAll();
    }

    public void EnterCardDetails(){
        creditCardNumber = "488648864886";
        CvvNumber = "890";
        cardHolder = "John Dummy";

        driver.findElement(By.xpath("//*[@id=\"creditCard\"]")).sendKeys(creditCardNumber);
        driver.findElement(By.xpath("//*[@id=\"paymentMethod\"]/div/div[4]/sec-form/div[1]/sec-view[2]/div/input")).sendKeys(CvvNumber);
        driver.findElement(By.xpath("//*[@id=\"paymentMethod\"]/div/div[4]/sec-form/div[2]/sec-view/div/input")).sendKeys(creditCardNumber);

    }

    public void ClickPayNow(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("pay_now_btn_ManualPayment")).click();



    }




}
