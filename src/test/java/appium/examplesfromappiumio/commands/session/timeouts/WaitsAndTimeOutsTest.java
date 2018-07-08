package appium.examplesfromappiumio.commands.session.timeouts;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitsAndTimeOutsTest {

    @Test
    public void timeOutTests() {
        AppiumDriver driver = BaseAndroid.getDriver();

        // Timeouts specify the amount of time than an operation can continue before
        // being aborted. (Web Context)

        // driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        // For single element, driver will poll page until element is found or timeout expires
        // whichever occurs first

        // For multiple elements, driver will poll page till one element is found or timeout expires
        // if no elements found it should return an empty list

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Amount of time that an async script executed by `execute async` are permitted to run
        // before being aborted (Web Context)

        // driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }
}
