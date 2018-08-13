package appium.examplesfromappiumio.commands.device;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * This houses all the tests which deal with using the keys on
 * the device keyboard.
 */
public class KeysTest {
    private AppiumDriver driver;

    @Test
    public void androidKeyboardAndKeysTest() throws InterruptedException {
        driver = BaseAndroid.getDriver();
        AndroidDriver androidDriver = (AndroidDriver) driver;
        // Android key code mapping reference:
        // https://developer.android.com/reference/android/view/KeyEvent
        openTextBoxInDemoApp();

        androidDriver.pressKeyCode(AndroidKeyCode.SPACE);
        Thread.sleep(3000);

        androidDriver.longPressKeyCode(AndroidKeyCode.HOME);
        Thread.sleep(3000);

        if (androidDriver.isKeyboardShown()) {
            driver.hideKeyboard();
        }

        driver.quit();
    }

    private void openTextBoxInDemoApp() {
        WebElement preference = (
                new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//android.widget.TextView[@text='Preference']")));
        preference.click();

        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//android.widget.TextView[contains(@text, 'Preference dependencies')]"))).click();

        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("android:id/checkbox"))).click();

        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//android.widget.TextView[@text='WiFi settings']"))).click();
    }
}
