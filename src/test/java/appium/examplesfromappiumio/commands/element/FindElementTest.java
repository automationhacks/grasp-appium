package appium.examplesfromappiumio.commands.element;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementTest {

    private AppiumDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = BaseAndroid.getDriver();
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void usingAccessibilityIdTest() {

        // Accessibility id
        // For android: content-desc
        // For IOS: accessibility-id attribute
        MobileElement prefs = (MobileElement) driver.findElementByAccessibilityId("Preference");
        prefs.click();
    }

    @Test
    public void usingClassNameTest() {
        // findElement method returns the first match for element with matching locator strategy
        MobileElement elem = (MobileElement) driver.findElementByClassName("android.widget.TextView");
        System.out.println(elem.getText());
    }

    @Test
    public void usingIdTest() {
        // id = resource-id in android and name for IOS
        System.out.println(driver.findElementById("text1").getText());
    }

    @Test
    public void usingNameTest() {
        System.out.println("By name is deprecated, use either accessibility-id or xpath with text attribute");
        System.out.println("Reference: https://discuss.appium.io/t/why-is-name-locator-strategy-being-depreciated/7106");
    }

    @Test
    public void usingXPathTest() {
       MobileElement graphics = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Graphics']");
       graphics.click();
    }

    @Test
    public void usingBase64EncodedImage() {
        // TODO: Checkout image for element identification
        System.out.println("Implement using latest version of appium");
    }

    /**
     * UIAutomator selector class can be used to find elements as well
     * Link: https://developer.android.com/reference/android/support/test/uiautomator/UiSelector
     * Checkout above for a full list of methods which are available for use.
     */
    @Test
    public void usingUIAutomatorString() throws InterruptedException {
        String uiSelectorCmd = "new UiSelector().textContains(\"Media\")";
        MobileElement media = (MobileElement) driver.findElement(
                MobileBy.AndroidUIAutomator(uiSelectorCmd));
        media.click();

        Thread.sleep(3000);
    }

    /**
     * http://appium.io/docs/en/drivers/android-espresso/ - Setup espresso
     * https://developer.android.com/reference/android/support/test/espresso/matcher/ViewMatchers
     */
    @Test
    public void usingEspressoViewTag() {
        System.out.println("Appium has beta support for espresso");
        System.out.println("Need to investigate how to install a new version of appium and then try this out");
    }

    /**
     * http://appium.io/docs/en/drivers/ios-xcuitest/index.html
     */
    @Test
    public void usingAppleInstruments() {
        System.out.println("Implement me");
    }
}
