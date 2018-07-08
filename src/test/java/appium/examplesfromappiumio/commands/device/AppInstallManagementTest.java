package appium.examplesfromappiumio.commands.device;

import appium.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class AppInstallManagementTest extends BaseTest {
    private AndroidDriver androidDriver;

    @Test
    public void appInstallAndroidTest() {
        String fgpsPackageName = "com.lexa.fakegps";
        androidDriver = (AndroidDriver) driver;

        Boolean isAppInstalled = checkIfAppIsInstalled(fgpsPackageName);
        removeAppIfInstalledAlready(fgpsPackageName, isAppInstalled);
        installAppOnDevice(fgpsPackageName);
    }

    // Returns a java.lang.NullPointerException. Need to debug.
    @Test
    public void backgroundAppTest() throws InterruptedException {
        Thread.sleep(5000);
        androidDriver.runAppInBackground(Duration.ofSeconds(10));
    }

    @Test
    public void closeAppTest() throws InterruptedException {
        Thread.sleep(5000);
        androidDriver.closeApp();
        Thread.sleep(5000);
    }

    @Test
    public void launchAppTest() throws InterruptedException {
        Thread.sleep(5000);
        androidDriver.launchApp();
    }

    @Test
    public void resetAppTest() throws InterruptedException {
        Thread.sleep(5000);
        androidDriver.resetApp();
    }

    private Boolean checkIfAppIsInstalled(String fgpsPackageName) {
        // Check if app is installed
        Boolean isAppInstalled = androidDriver.isAppInstalled(fgpsPackageName);
        System.out.println("Fake GPS Installed: " + isAppInstalled);
        return isAppInstalled;
    }

    private void removeAppIfInstalledAlready(String fgpsPackageName, Boolean isAppInstalled) {
        // Remove app if installed
        if (isAppInstalled) {
            androidDriver.removeApp(fgpsPackageName);
            System.out.println("Is fake gps installed currently? " +
                    androidDriver.isAppInstalled(fgpsPackageName));
        }
    }

    private void installAppOnDevice(String fgpsPackageName) {
        System.out.println("Lets install Fake GPS app...");
        File basePath = new File("src");
        File appPath = new File(basePath, "test/resources/android/fake_gps.apk");
        androidDriver.installApp(appPath.getAbsolutePath());

        System.out.println("Is App installed successfully? " + androidDriver.isAppInstalled(fgpsPackageName));
    }
}
