package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {
    @Test
    public void BrowserTest() {

//        driver.get("https://www.google.com");
//        driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//
//
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        driver.findElement(By.xpath("//a[@routerlink='/products']")).click();


        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
        String text = driver.findElement(By.xpath("//a[@href='/angularAppdemo/products/3']")).getText();
        Assert.assertEquals(text, "Devops");
    }


}
