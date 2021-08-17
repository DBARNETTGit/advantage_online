package com.advantage.pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PaymentCompletionPage {

    WebDriver driver;

    protected boolean elementDisplayed(long timeInSeconds, WebElement displayElement) {
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

    public PaymentCompletionPage (WebDriver driver){
        this.driver = driver;
    }

    public void VerifyPaymentCompletion(){

        elementDisplayed(20, driver.findElement(By.xpath("//*[@id=\"orderPaymentSuccess\"]/h2/span")));

        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot, new File ("src/main/resources/screenshots/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
