package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserBaseTest {


    public AndroidDriver driver;
    public AppiumDriverLocalService service;


    @BeforeClass



    public void ConfigureAppium() throws MalformedURLException {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\vikto\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

     //   DesiredCapabilities cap = new DesiredCapabilities();
     //   cap.setCapability("chromedriver_autodownload", "true");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Vika");
        options.setChromedriverExecutable("C:\\Users\\vikto\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        options.setCapability("browserName", "Chrome");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }




    public Double getFormattedAmount(String amount) {
        Double price = (Double) Double.parseDouble(amount.substring(1));
        return price;
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}

