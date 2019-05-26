package appium.appiumConf;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Scanner;

public class AppStateStrategies {

    private AppiumDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BaseAndroid.getDriver();
    }

    @Test
    public void usingAndroidActivities() throws InterruptedException {
        Thread.sleep(5000);
        ((AndroidDriver) driver).startActivity(new Activity("io.appium.android.apis", "io.appium.android.apis.preference.DefaultValues"));
        Thread.sleep(5000);
    }

    @Test
    public void usingAppActivityFromCapabilities() {

    }

    @Test
    public void usingDeeplinks() {
        driver.get("yourapp://test/login/my_username/my_password");
    }

    @Test
    public void usingAdbToTurnOffAnimations() throws IOException, InterruptedException {
        executeCmd("adb shell settings put global window_animation_scale 0");
        executeCmd("adb shell settings put global transition_animation_scale 0");
        executeCmd("adb shell settings put global animator_duration_scale 0");

        driver.findElementByAccessibilityId("Animation").click();
        driver.findElementByAccessibilityId("Custom Evaluator").click();
        driver.findElementById("startButton").click();
        driver.findElementById("startButton").click();
    }


    public void executeCmd(String command) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(command);
        Integer exitCode = process.waitFor();

        Scanner in = new Scanner(process.getInputStream()).useDelimiter("\\A");
        String output = in.hasNext() ? in.next() : "";

        System.out.println(String.format("Process exited with code: %d", exitCode));
        System.out.println("Process output: ");
        System.out.println(output);
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
