package appium.examplesfromappiumio.commands.session;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class SessionCommandsTest {

    private AppiumDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException{

        // Create capabilities object and start a driver session instance
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Automation");
        capabilities.setCapability(MobileCapabilityType.APP, new File(
                "src/test/resources/android/ApiDemos-debug.apk").getAbsolutePath());
        capabilities.setCapability("appPackage", "io.appium.android.apis");
        capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, capabilities);

    }

    @Test
    public void sessionStartTest() {
        String sessionId = driver.getSessionId().toString();
        System.out.println("Appium session id: " + sessionId);
    }

    @Test
    public void getSessionCapabilitiesTest() {
        Map<String, Object> caps = driver.getSessionDetails();
        caps.forEach((key, value) -> System.out.printf("%s : %s \n", key, value));
    }

    @AfterMethod
    public void teardown() {
        // End session
        System.out.println("Terminating appium run session");
        driver.quit();
    }
}
