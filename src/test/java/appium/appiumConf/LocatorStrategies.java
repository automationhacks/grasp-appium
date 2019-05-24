package appium.appiumConf;

import appium.BaseAndroid;
import appium.BaseIOS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatorStrategies {
    private AppiumDriver driver;

    @BeforeMethod
    public void before() {
       driver = BaseAndroid.getDriver();
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }

    @Test
    public void accessibilityIdForAndroid() {
       driver.findElement(MobileBy.AccessibilityId("Graphics")).click();
    }

    // TODO: Test with valid appium and xcode version
    @Test
    public void predicateStringTest() {
        driver.findElement(MobileBy.iOSNsPredicateString(
                "type == 'XCUIElementTypeButton' AND value BEGINSWITH[c] 'Alert' AND visible = 1"))
                .click();
    }

    // TODO: Test with valid appium and xcode version
    @Test
    public void iosClassChainTest() {
        String classChain = "XCUIElementTypeWindow[`name CONTAINS[cd] \"blabla\"`]";
        driver.findElement(MobileBy.iOSClassChain(classChain)).click();
    }

    @Test
    public void uiSelectorAndroid() {
        String uiSelector = "new UiSelector().descriptionContains(\"App\")";
        driver.findElement(MobileBy.AndroidUIAutomator(uiSelector)).click();
    }

}
