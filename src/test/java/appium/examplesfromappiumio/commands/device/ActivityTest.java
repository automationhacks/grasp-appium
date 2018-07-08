package appium.examplesfromappiumio.commands.device;

import appium.BaseTest;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

public class ActivityTest extends BaseTest {

    private AndroidDriver androidDriver;

    // Start an android activity from within native app context
    @Test
    public void startActivityTest() {
        androidDriver = (AndroidDriver) driver;
        androidDriver.startActivity(
                new Activity("com.android.calculator2",
                        "com.android.calculator2.Calculator"));
    }

    // Get current apps activity and package name
    @Test
    public void showCurrentPackageAndActivityTest() {
        androidDriver = (AndroidDriver) driver;
        String curActivity = androidDriver.currentActivity();
        System.out.println(curActivity);

        String currentPackage = androidDriver.getCurrentPackage();
        System.out.println(currentPackage);
    }
}
