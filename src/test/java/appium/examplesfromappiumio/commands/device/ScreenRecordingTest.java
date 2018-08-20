package appium.examplesfromappiumio.commands.device;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

public class ScreenRecordingTest {

    @Test
    public void performScreenRecordingStartAndEndTest() {

        // startRecordingScreen() and stopRecordingScreen() method is not available in java
        AppiumDriver driver = BaseAndroid.getDriver();
    }

}
