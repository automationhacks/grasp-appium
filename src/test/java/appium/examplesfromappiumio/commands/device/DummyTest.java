package appium.examplesfromappiumio.commands.device;

import appium.BaseAndroid;
import io.appium.java_client.android.AndroidDriver;

public class DummyTest {

    public static void main(String[] args) throws InterruptedException {
        AndroidDriver driver = (AndroidDriver) BaseAndroid.getDriver();
        Thread.sleep(5000);
        driver.closeApp();
        Thread.sleep(5000);
        driver.quit();

    }
}
