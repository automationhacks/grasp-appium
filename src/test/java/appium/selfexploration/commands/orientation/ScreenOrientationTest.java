package appium.selfexploration.commands.orientation;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

public class ScreenOrientationTest {

    @Test
    public void modifyingScreenOrientation() {
        AppiumDriver driver = BaseAndroid.getDriver();

        // Getting screen orientation
        ScreenOrientation orientation = driver.getOrientation();
        System.out.println("Original Orientation value: " + orientation.value());

        // Setting screen orientation
        driver.rotate(ScreenOrientation.LANDSCAPE);
        System.out.println("Set orientation to landscape " + driver.getOrientation().value());

        driver.quit();
    }
}
