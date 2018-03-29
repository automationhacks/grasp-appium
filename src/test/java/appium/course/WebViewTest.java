package appium.course;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.junit.Test;

public class WebViewTest {

    private AppiumDriver driver;

    @Test
    public void handleWebViewTest() {
        driver = BaseAndroid.getDriver();
        driver.findElementById("Views").click();
        String scrollCmd = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))";
        driver.findElement(MobileBy.AndroidUIAutomator(scrollCmd));
        driver.findElementById("WebView").click();

        driver.getContext();
        System.out.println(driver.getContextHandles());
        // TODO: Need to make below work.
        driver.context("WEBVIEW_io.appium.android.apis");
        driver.findElementById("Hello World! - 1");

        // Switching back to native.
        driver.context("NATIVE_APP");

    }
}
