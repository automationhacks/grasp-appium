package appium.examplesfromappiumio.commands.element;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

public class FindElementTest {

    @Test
    public void findElementAndroidTest() {
        AppiumDriver driver = BaseAndroid.getDriver();
        MobileElement prefs = (MobileElement) driver.findElementByXPath("//*[@text='Preference'");
        prefs.click();
        driver.quit();
    }
}
