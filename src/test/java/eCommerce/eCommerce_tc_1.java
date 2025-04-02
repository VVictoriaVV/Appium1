package eCommerce;

import io.appium.java_client.AppiumBy;
import org.example.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerce_tc_1 extends BaseTest {

    @Test
    public void testFillForm() throws InterruptedException {

     //   driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Victoria");

        //close keyboard
        // driver.hideKeyboard();

        //com.androidsample.generalstore:id/radioFemale
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();


        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bahrain\"));"));


        driver.findElement(By.xpath("//android.widget.TextView[@text='Bahrain']")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(3000);

        //get message from popup message
        String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[@text=\"Please enter your name\"]")).getText();


        Assert.assertEquals(toastMessage, "Please enter your name");
    }
}
