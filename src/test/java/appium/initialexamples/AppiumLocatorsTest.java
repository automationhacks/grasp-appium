package appium.initialexamples;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static junit.framework.TestCase.assertEquals;

public class AppiumLocatorsTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("deviceName", "BasicAndroidDevice"); // emulator name or AVD name
        capabilities.setCapability("deviceName", "donatello"); // VS emulator device name by executing adb devices -l
        capabilities.setCapability("appPackage", "com.android.calculator2"); // applications package name
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator"); // activity name

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void addTwoNumbers() {
        // Click on 5 and 6
        driver.findElementById("com.android.calculator2:id/digit5").click();
        driver.findElementById("com.android.calculator2:id/digit6").click();

        // Select on plus button
        driver.findElementByAccessibilityId("plus").click();

        // Click on 9 and 4
        driver.findElementById("com.android.calculator2:id/digit9").click();
        driver.findElementById("com.android.calculator2:id/digit4").click();

        // Click on equals button
        driver.findElementByAccessibilityId("equals").click();

        // Get result text and assert with expected value
        String result = driver.findElementByClassName("android.widget.EditText").getText();
        assertEquals(result, "150");

    }


}
