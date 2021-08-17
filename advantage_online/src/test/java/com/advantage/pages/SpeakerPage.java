package com.advantage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class SpeakerPage {

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

     public SpeakerPage (WebDriver driver){
         this.driver = driver;
     }

    public void SelectASpeaker(){
        driver.findElement(By.xpath("//*[@id=\"20\"]")).click();
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@id=\"Description\"]/h1")).getText(), "BOSE SOUNDLINK BLUETOOTH SPEAKER III");
        softAssert.assertTrue(driver.findElement(By.name("save_to_cart")).isDisplayed());
        softAssert.assertAll();
    }

    public void AddSpeakerToBasket(){
         driver.findElement(By.name("save_to_cart")).click();

    }

    public void SelectTheBasket(){
         driver.findElement(By.id("shoppingCartLink")).click();
        driver.findElement(By.id("checkOutPopUp")).click();
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@id=\"shoppingCart\"]/table/tfoot/tr[1]/td[2]/span[2]")).getText(), "$269.99");
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@id=\"shoppingCart\"]/table/thead/tr/th[2]/label")).getText(), "PRODUCT NAME");
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@id=\"shoppingCart\"]/table/thead/tr/th[4]/label")).getText(), "COLOR");
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@id=\"shoppingCart\"]/table/thead/tr/th[5]/label")).getText(), "QUANTITY");
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@id=\"shoppingCart\"]/table/thead/tr/th[6]/label")).getText(), "PRICE");

    }

    public void ClickCheckout(){
         driver.findElement(By.xpath("//*[@id=\"checkOutButton\"]")).click();
    }


}
