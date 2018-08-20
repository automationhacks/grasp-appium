package appium.examplesfromappiumio.commands.device;

import appium.BaseAndroid;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

import java.util.Map;

public class SystemControlsTest {

    // This method is only available on Android emulator
    @Test
    public void openAndroidNotificationsTest() throws InterruptedException {
        AndroidDriver driver = (AndroidDriver) BaseAndroid.getDriver();
        Thread.sleep(2000);
        driver.openNotifications();
        Thread.sleep(2000);
        driver.quit();
    }

    // Getting below error: Need to debug, looks like an issue with appium version as per threads
    // com.google.common.collect.Maps$TransformedEntriesMap cannot be cast to java.lang.String
    @Test
    public void getSystemBarsInformationTest() throws InterruptedException {
        AndroidDriver driver = (AndroidDriver) BaseAndroid.getDriver();
        Thread.sleep(3000);
        Map<String, String> systemBars = driver.getSystemBars();
        for(String key : systemBars.keySet()) {
            System.out.println("Key: " + key + "Value: " + systemBars.get(key));
        }
        driver.quit();
    }

    @Test
    public void getSystemTimeTest() {
        AndroidDriver driver = (AndroidDriver) BaseAndroid.getDriver();
        System.out.println(driver.getDeviceTime());
        driver.quit();
    }
}
