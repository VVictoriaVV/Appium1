package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;


    @BeforeClass
//    public void setChromeDriver() {
//        System.setProperty("webdriver.chrome.driver", SeleniumManager.getInstance().getDriverPath("chromedriver"));
//        WebDriver driver = new ChromeDriver(); }


    public void ConfigureAppium() throws MalformedURLException {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\79255\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

          DesiredCapabilities cap = new DesiredCapabilities();
           cap.setCapability("chromedriver_autodownload", "true");
//           cap.setCapability("platformName", "Android");
//           cap.setCapability("deviceName", "Vika");
//           cap.setCapability("app", "C:\\Users\\79255\\IdeaProjects\\Mobile\\src\\resources\\General-Store.apk");

        //Build the Appium service
//           AppiumServiceBuilder builder = new AppiumServiceBuilder();
//           builder.withIPAddress("127.0.0.1");
//           builder.usingPort(4723);
//
//        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
//        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

        //Start the server with the builder
        //   AppiumDriverLocalService  service = AppiumDriverLocalService.buildService(builder);
        //   service.start();


        UiAutomator2Options options = new UiAutomator2Options();
      options.setDeviceName("Vika");
//        // options.setApp("C:\\Users\\79255\\IdeaProjects\\Mobile\\src\\resources\\ApiDemos-debug.apk");
        options.setApp("C:\\Users\\79255\\IdeaProjects\\Mobile\\src\\resources\\General-Store.apk");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public void longPressAction(WebElement button) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) button).getId(), "duration", 2000));
    }


    public void scrollToEnd() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "direction", "down",
                    "percent", 3.0
            ));
        } while (canScrollMore);
    }

    public void swipeAction(WebElement element, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    public Double getFormattedAmount(String amount) {
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}


