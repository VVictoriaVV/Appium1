package eCommerce;

import io.appium.java_client.AppiumBy;
import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class eCommerce_tc_3 extends BaseTest {

    @Test
    public void testValidationAmount() throws InterruptedException {

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Victoria");
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();


        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bahrain\"));"));


        driver.findElement(By.xpath("//android.widget.TextView[@text='Bahrain']")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));


        List<WebElement> prices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));



        int priceProducts = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        double totalSum = 0;

        for (int i = 0; i < priceProducts; i++) {
            String amountString = prices.get(i).getText();
            Double price = (Double) Double.parseDouble(amountString.substring(1));
            totalSum = totalSum + price;
        }


        String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayFormattedAmount = getFormattedAmount(total);
        Assert.assertEquals(totalSum, displayFormattedAmount);


        Thread.sleep(3000);


        longPressAction(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

        Thread.sleep(3000);
    }


}

