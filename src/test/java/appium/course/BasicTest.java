package appium.course;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BasicTest {

    @Test
    public void basicTest() {
        File srcDir = new File("src");
        File app = new File(srcDir, "/test/resources/android/ApiDemos-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "BasicAndroidDevice");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        try {
            AndroidDriver driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
