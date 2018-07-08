package appium;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected static AppiumDriver driver;

    @BeforeClass
    public void setUp() {
        driver = BaseAndroid.getDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
