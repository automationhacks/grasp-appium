package appium.examplesfromappiumio.commands.element;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;

public class FindElementsTest {

    private AppiumDriver driver;

    @BeforeClass
    public void setUp() {
        driver = BaseAndroid.getDriver();
    }

}
