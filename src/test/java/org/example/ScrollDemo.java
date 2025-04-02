package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ScrollDemo extends BaseTest {

    @Test
    public void ScrollDemo() throws InterruptedException {


        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //where to scroll is known prior
        //  driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));


        //scroll no prior idea
        scrollToEnd();

        Thread.sleep(3000);





    }
}
