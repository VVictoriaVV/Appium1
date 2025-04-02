package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MisceallaneousAppiumAct extends BaseTest {


    @Test
    public void testMiscellaneous() {

        Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies}");
        //  driver.startActivity(activity);

        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
                "intent", " io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));


        driver.findElement(By.id("android:id/checkbox")).click();

        DeviceRotation deviceRotation = new DeviceRotation(0, 0, 90);
        driver.rotate(deviceRotation);

        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");


        driver.setClipboardText("PUTINVOR");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElements(AppiumBy.className("//android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}