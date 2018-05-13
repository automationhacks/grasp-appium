package appium.course;

import appium.BaseIOS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class BasicIOSTest {

    private AppiumDriver driver;

    public void scroll(String elementId) {
        Map<String, String> scrollObject = new HashMap<>();
        scrollObject.put("element", elementId);
        scrollObject.put("toVisible", "not an empty string");
        driver.executeScript("mobile:scroll", scrollObject);
    }

    /**
     * Tap Alert Views > Tap Text Entry > Enter text in displayed pop up and tap on okay.
     */
    @Test
    public void firstIOSTest() {
        driver = BaseIOS.getDriver();
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Text Entry\"]").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("Hello World");
        driver.findElement(MobileBy.AccessibilityId("OK")).click();
    }

    /**
     * Recipe from below:
     * http://developers.perfectomobile.com/pages/viewpage.action?pageId=25199704
     * Swipe till WebView control is visible.
     */
    @Test
    public void swipeIOSTest() {
        driver = BaseIOS.getDriver();

        RemoteWebElement webView = (RemoteWebElement) driver.findElement(MobileBy.name("Web View"));
        String elementId = webView.getId();
        scroll(elementId);
    }

    /**
     * Open steppers buttons and tap + 2 times, assert the output on screen.
     */
    @Test
    public void steppersIOSTest() {
        driver = BaseIOS.getDriver();

        RemoteWebElement stepper = (RemoteWebElement) driver.findElement(MobileBy.id("Steppers"));
        String elementId = stepper.getId();

        scroll(elementId);
        stepper.click();

        WebElement increment = driver.findElement(MobileBy.xpath("//XCUIElementTypeButton[@name=\"Increment\"][1]"));
        increment.click();
        increment.click();

        WebElement incrementCount = driver.findElement(MobileBy.xpath("//XCUIElementTypeStaticText[1]"));
        int count = Integer.parseInt(incrementCount.getText());
        assert count == 2;
    }

    @Test
    public void pickerViewTest() {
        driver = BaseIOS.getDriver();

        driver.findElementByAccessibilityId("Picker View");
        driver.findElementByName("Green color component value").sendKeys("220");
    }
}
