package appium.examplesfromappiumio.commands.device;

import appium.BaseAndroid;
import appium.BaseIOS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

public class DeviceInteractions {
    private AppiumDriver driver;

    @Test
    public void shakeTest() {
        // Per http://appium.github.io/java-client/
        // shake() is an IOS only method
        driver = BaseIOS.getDriver();
        ((IOSDriver) driver).shake();
        driver.quit();
    }

    /**
     * Test locks a device and then unlocks it
     * Observed some failure logs in appium server logs, which might be worth investigating
     */
    @Test
    public void lockUnlockDeviceTest() {
        driver = BaseAndroid.getDriver();

        sleep();
        System.out.println("Locking device...");
        ((AndroidDriver) driver).lockDevice();

        sleep();
        boolean isDeviceUnlocked = ((AndroidDriver) driver).isLocked();

        System.out.println("Device lock status: " + isDeviceUnlocked);
        if(isDeviceUnlocked) {
            System.out.println("Unlocking device...");
            ((AndroidDriver) driver).unlockDevice();
        }


        driver.quit();
    }

    private void sleep() {
        try {
            System.out.println("Sleeping for 5 secs...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // This method has not yet been implemented.
    @Test
    public void rotateDevideInThreeDimensions() {
        driver = BaseAndroid.getDriver();
        driver.rotate(new DeviceRotation(10, 10, 10));
        driver.quit();
    }
}