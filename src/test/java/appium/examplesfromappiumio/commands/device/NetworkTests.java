package appium.examplesfromappiumio.commands.device;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

public class NetworkTests {
    private AppiumDriver driver;

    @Test
    public void toggleLocationServicesTest() throws InterruptedException {
        driver = BaseAndroid.getDriver();
        ((AndroidDriver) driver).toggleLocationServices();
        Thread.sleep(5000);
        driver.quit();
    }
}
