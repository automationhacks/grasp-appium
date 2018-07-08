package appium;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected static AppiumDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BaseAndroid.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
