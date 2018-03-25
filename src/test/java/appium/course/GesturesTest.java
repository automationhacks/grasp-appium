package appium.course;

import appium.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Test;


public class GesturesTest {
    private static AppiumDriver driver;
    private static TouchAction action;

    /**
     * 1. Open API Demos app
     * 2. Tap on "Views"
     * 3. Tap on "Expandable Lists"
     * 4. Tap on "1. Custom Adapter"
     * 5. Long press on "People Names"
     * 6. Check title of displayed pop up is "Sample menu"
     */
    @Test
    public void longPressTest() {
        driver = Base.getDriver();

        action = new TouchAction(driver);
        action.tap(driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]"));
        action.perform();

        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]").click();
        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]").click();
        action = new TouchAction(driver);

        action.longPress(driver.findElementByXPath("//android.widget.TextView[@text=\"People Names\"]"));
        action.perform();

        String title = driver.findElementById("android:id/alertTitle").getText();
        assert title.equals("Sample menu");
    }
}
