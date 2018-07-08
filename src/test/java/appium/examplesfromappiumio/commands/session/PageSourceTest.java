package appium.examplesfromappiumio.commands.session;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.junit.Test;

public class PageSourceTest {

    @Test
    public void getPageSourceAndroid() {
        AppiumDriver driver = BaseAndroid.getDriver();
        System.out.println(driver.getPageSource());
        driver.quit();
    }

    // Need to investigate more...
    // Some threads for this:
    // https://discuss.appium.io/t/switch-app-to-browser-and-back-to-app/987/23
    // https://appium.io/docs/en/writing-running-appium/web/hybrid/
    @Test
    public void getPageSourceBrowser() throws InterruptedException {
        AppiumDriver driver = BaseAndroid.getDriver();

        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.HOME);
        Thread.sleep(2000);
        ((AndroidDriver) driver).startActivity(new Activity("com.google.android.apps.chrome", "Main"));
        Thread.sleep(2000);

        driver.get("http://www.google.com");
        driver.quit();
    }
}
