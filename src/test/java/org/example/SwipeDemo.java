package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeDemo extends BaseTest {


    @Test
    public void swipeDemo() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Gallery']")).click();

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();


        WebElement photo = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "true");

        swipeAction(photo, "left");


        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "false");


    }
}
