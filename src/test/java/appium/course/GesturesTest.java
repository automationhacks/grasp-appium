package appium.course;

import appium.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


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

    /**
     * Achieve Swiping gesture
     * 1. Tap on Views
     * 2. Tap on Date Widgets
     * 3. Tap on Inline
     * 4. Tap on 9
     * 5. Swipe minutes from 15 to 45.
     */
    @Test
    public void swipeOnDateWidgetTest() {
        driver = Base.getDriver();

        driver.findElementById("Views").click();
        driver.findElementById("Date Widgets").click();
        driver.findElementById("2. Inline").click();
        driver.findElementById("9").click();

        TouchAction swipingLeft = new TouchAction(driver);
        WebElement fifteen = driver.findElementById("15");
        WebElement fortyFive = driver.findElementById("45");
        swipingLeft.longPress(fifteen).moveTo(fortyFive).release().perform();
    }

    /**
     * Checks scrolling
     * 1. Taps on "Views"
     * 2. Scrolls till "Radio Group" is shown on view.
     */
    @Test
    public void scrollIntoViewTest() {
        driver = Base.getDriver();

        driver.findElementById("Views").click();
        String androidCmd = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"))";
        driver.findElement(MobileBy.AndroidUIAutomator(androidCmd));
    }

    /**
     * Drags and drops ball in Drag and Drop demo in Views.
     */
    @Test
    public void dragAndDropTest() {
        driver = Base.getDriver();

        driver.findElement(By.id("Views")).click();
        driver.findElementById("Drag and Drop").click();

        WebElement src = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
        WebElement dest = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));

        TouchAction dragToDest = new TouchAction(driver);
        dragToDest.longPress(src).moveTo(dest).release().perform();


    }
}
