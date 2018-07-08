package appium.examplesfromappiumio.commands.session.settings;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;

public class DeviceSettingsTest {

    private AppiumDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BaseAndroid.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void deviceSettingsTest() {
        // Get current device settings
        showCurrentDeviceSettings();
    }

    private void showCurrentDeviceSettings() {
        Map<String, Object> settings = ((AndroidDriver) driver).getSettings();
        settings.forEach((k, v) -> {System.out.println(k + " " + v);});
    }

    @Test
    public void setDeviceSettingsTest() {
        // Update device settings
        ((AndroidDriver) driver).setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, Duration.ofSeconds(5));
        showCurrentDeviceSettings();
    }
}
