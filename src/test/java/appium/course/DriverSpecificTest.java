package appium.course;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import org.junit.Test;

public class DriverSpecificTest {

    private AppiumDriver driver;

    @Test
    public void driverSpecificMethods() {
        driver = BaseAndroid.getDriver();

        // Get context: Native, Hybrid or WebView
        System.out.println(driver.getContext());

        // LANDSCAPE or PORTRAIT
        System.out.println(driver.getOrientation());

        // To remove on screen keyboard
        // driver.hideKeyboard();
    }
}
