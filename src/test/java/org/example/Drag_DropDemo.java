package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Drag_DropDemo extends BaseTest {


    @Test
    public void dragDropDemo() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement sourcefrom = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));


        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) sourcefrom).getId(),
                "endX", 712,
                "endY", 670
        ));
        Thread.sleep(3000);


        WebElement dropped_message = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text"));
        Assert.assertEquals(dropped_message.getText(), "Dropped!");
    }
}
