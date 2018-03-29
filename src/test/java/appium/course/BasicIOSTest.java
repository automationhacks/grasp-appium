package appium.course;

import appium.BaseIOS;
import io.appium.java_client.AppiumDriver;
import org.junit.Test;

public class BasicIOSTest {

    private AppiumDriver driver;

    @Test
    public void firstIOSTest() {
        driver = BaseIOS.getDriver();
    }
}
